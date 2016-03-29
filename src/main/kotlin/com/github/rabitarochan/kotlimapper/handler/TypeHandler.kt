package com.github.rabitarochan.kotlimapper.handler

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import java.sql.PreparedStatement
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.defaultType
import kotlin.reflect.jvm.javaType

interface TypeHandler {

    fun getValue(rs: WrappedResultSet, name: String): Any?

    fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any)

    fun getType(): KClass<*>

    companion object {

        val handlers: Map<String, TypeHandler> by lazy {
            val loader = ServiceLoader.load(TypeHandler::class.java)
            loader.map { Pair(it.getType().defaultType.javaType.typeName, it) }.toMap()
        }

        fun get(kclass: KClass<*>): TypeHandler {
            return get(kclass.defaultType)
        }

        fun get(ktype: KType): TypeHandler {
            val typeName = ktype.javaType.typeName
            val handler = handlers.get(typeName)
            if (handler == null) {
                throw NotImplementedError("TypeHandler of '${typeName}' is not registered.")
            } else {
                return handler
            }
        }

    }

}
