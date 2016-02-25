package com.github.rabitarochan.kodb.extractor

import java.sql.ResultSet
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.defaultType

interface ResultSetExtractor<T: Any> {

    fun extract(rs: ResultSet): T

    fun getTargetType(): KClass<*>

    companion object {

        val extractors: Map<KType, ResultSetExtractor<*>> by lazy {
            val loader = ServiceLoader.load(ResultSetExtractor::class.java)
            loader.map { Pair(it.getTargetType().defaultType, it) }.toMap()
        }

        val generatedExtractors = mutableMapOf<KType, ResultSetExtractor<*>>()

        fun <T: Any> get(kclass: KClass<T>): ResultSetExtractor<T> {
            val type = kclass.defaultType
            generatedExtractors.get(type)?.let {
                @Suppress("UNCHECKED_CAST")
                return it as ResultSetExtractor<T>
            }

            extractors.get(type)?.let {
                @Suppress("UNCHECKED_CAST")
                return it as ResultSetExtractor<T>
            }

            // generate
            val extractor = ExtractorFactory.create(kclass)
            generatedExtractors.put(type, extractor)
            return extractor
        }

    }


}
