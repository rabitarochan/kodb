package com.github.rabitarochan.kodb.handler

import java.sql.ResultSet
import kotlin.reflect.KClass

class DoubleTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getDouble(name)
    }

    override fun getType(): KClass<*> {
        return Double::class
    }

}