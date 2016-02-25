package com.github.rabitarochan.kodb.extractor

import java.lang.reflect.Constructor
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.sql.ResultSet
import kotlin.reflect.KClass

class ExtractHandler<T>(val ctor: Constructor<T>, val params: List<ExtractParameter>, val kclass: KClass<*>) : InvocationHandler {

    override fun invoke(proxy: Any, method: Method, args: Array<out Any>): Any {
        when (method.name) {
            "extract" -> return extractHandler(args[0] as ResultSet)
            "getTargetType" -> return getTargetTypeHandler()
            else -> error("")
        }
    }

    private fun extractHandler(rs: ResultSet): Any {
        val ctorArgs = params.map { param ->
            param.typeHandler.get(param.name, rs)
        }.toTypedArray()

        val instance = ctor.newInstance(*ctorArgs)
        return instance as Any
    }

    private fun getTargetTypeHandler(): Any {
        return kclass
    }

}
