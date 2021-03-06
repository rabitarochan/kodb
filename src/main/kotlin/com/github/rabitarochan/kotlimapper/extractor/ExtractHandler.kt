package com.github.rabitarochan.kotlimapper.extractor

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import java.lang.reflect.Constructor
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.sql.ResultSet

class ExtractHandler<T>(val ctor: Constructor<T>, val params: List<ExtractParameter>) : InvocationHandler {

    override fun invoke(proxy: Any, method: Method, args: Array<out Any>): Any {
        val methodName = method.name
        when (methodName) {
            "extract" -> return invokeExtract(args[0] as WrappedResultSet)
            "getTargetType" -> return invokeGetTargetType()
            else -> throw NotImplementedError("Method '$methodName' is not implemented.")
        }
    }

    private fun invokeExtract(rs: WrappedResultSet): Any {
        val ctorArgs = params.map { param ->
            param.typeHandler.getValue(rs, param.columnName)
        }.toTypedArray()

        val instance = ctor.newInstance(*ctorArgs)
        return instance as Any
    }

    private fun invokeGetTargetType(): Any {
        TODO("Do not invoke method 'ExtractHandler#getTargetType' in proxy class.")
    }

}
