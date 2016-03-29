package com.github.rabitarochan.kotlimapper.extractor

import com.github.rabitarochan.kotlimapper.handler.TypeHandler
import java.lang.reflect.Constructor
import java.lang.reflect.Proxy
import kotlin.reflect.*
import kotlin.reflect.jvm.javaConstructor

object ExtractorFactory {

    fun <T: Any?> create(ctor: KFunction<T>): ResultSetExtractor<T> {
        val params =
                ctor.parameters
                    .sortedBy { it.index }
                    .map { ExtractParameter(it.name!!, getTypeHandler(it.type)) }
        val proxyObject =
                Proxy.newProxyInstance(
                        ResultSetExtractor::class.java.classLoader,
                        arrayOf(ResultSetExtractor::class.java),
                        ExtractHandler(ctor.javaConstructor!!, params)
                )

        @Suppress("UNCHECKED_CAST")
        return proxyObject as ResultSetExtractor<T>
    }

    fun getTypeHandler(type: KType): TypeHandler {
        return TypeHandler.get(type)
    }

}
