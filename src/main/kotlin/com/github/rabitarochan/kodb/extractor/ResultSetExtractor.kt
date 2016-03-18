package com.github.rabitarochan.kodb.extractor

import com.github.rabitarochan.kodb.WrappedResultSet
import java.sql.ResultSet
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KType
import kotlin.reflect.defaultType
import kotlin.reflect.jvm.javaType
import kotlin.reflect.jvm.jvmName

interface ResultSetExtractor<T> {

    fun extract(rs: WrappedResultSet): T?

    fun getTargetType(): KClass<*>

    open fun getTargetTypes(): Array<KClass<*>> {
        return arrayOf(getTargetType())
    }

    companion object {

        val extractors: Map<String, ResultSetExtractor<*>> by lazy {
            val loader = ServiceLoader.load(ResultSetExtractor::class.java)
            loader.flatMap { extractor ->
                extractor.getTargetTypes()
                         .map { Pair(it.defaultType.javaType.typeName, extractor) }
            }.toMap()
        }

        val generatedExtractors = mutableMapOf<String, ResultSetExtractor<*>>()

        fun <T: Any?> get(typeName: String, ctor: () -> KFunction<T>): ResultSetExtractor<T> {
            generatedExtractors.get(typeName)?.let {
                @Suppress("UNCHECKED_CAST")
                return it as ResultSetExtractor<T>
            }

            extractors.get(typeName)?.let {
                @Suppress("UNCHECKED_CAST")
                return it as ResultSetExtractor<T>
            }

            // generate
            val extractor = ExtractorFactory.create(ctor())
            generatedExtractors.put(typeName, extractor)
            return extractor
        }

    }


}
