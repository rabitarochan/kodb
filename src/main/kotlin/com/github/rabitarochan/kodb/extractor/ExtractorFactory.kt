package com.github.rabitarochan.kodb.extractor

import com.github.rabitarochan.kodb.handler.TypeHandler
import java.lang.reflect.Proxy
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.defaultType
import kotlin.reflect.jvm.javaConstructor
import kotlin.reflect.primaryConstructor

object ExtractorFactory {

    fun <T : Any> create(kclass: KClass<T>): ResultSetExtractor<T> {
        val ctor = kclass.primaryConstructor!!
        val params =
                ctor.parameters
                    .sortedBy { it.index }
                    .map { ExtractParameter(it.name!!, getTypeHandler(it.type))}
        val proxyObject =
                Proxy.newProxyInstance(
                        ResultSetExtractor::class.java.classLoader,
                        arrayOf(ResultSetExtractor::class.java),
                        ExtractHandler(ctor.javaConstructor!!, params, kclass)
                )

        @Suppress("UNCHECKED_CAST")
        return proxyObject as ResultSetExtractor<T>
    }

    fun getTypeHandler(type: KType): TypeHandler {
        return TypeHandler.get(type)
    }

}
