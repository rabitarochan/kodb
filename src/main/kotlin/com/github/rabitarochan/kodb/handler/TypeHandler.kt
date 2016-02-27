package com.github.rabitarochan.kodb.handler

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.defaultType

interface TypeHandler {

    fun getValue(rs: ResultSet, name: String): Any

    fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any)

    fun getType(): KClass<*>

    companion object {

        val handlers: Map<KType, TypeHandler> by lazy {
            val loader = ServiceLoader.load(TypeHandler::class.java)
            loader.map { Pair(it.getType().defaultType, it) }.toMap()
        }

        fun get(kclass: KClass<*>): TypeHandler {
            return get(kclass.defaultType)
        }

        fun get(ktype: KType): TypeHandler {
            return handlers.get(ktype) ?: throw NotImplementedError("")
        }

    }

}