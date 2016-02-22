package com.github.rabitarochan.kodb.extractor

import java.lang.reflect.Constructor
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.sql.ResultSet

class ExtractHandler<T>(val ctor: Constructor<T>, val params: List<ExtractParameter>) : InvocationHandler {

    override fun invoke(proxy: Any, method: Method, args: Array<out Any>): Any {
        val rs = args[0] as ResultSet
        val ctorArgs = params.map { param ->
            param.typeHandler.get(param.name, rs)
        }.toTypedArray()

        val instance = ctor.newInstance(*ctorArgs)
        return instance as Any
    }


}
