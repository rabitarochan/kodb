package com.github.rabitarochan.kodb.handler

import java.sql.ResultSet
import kotlin.reflect.KClass

class BooleanTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getBoolean(name)
    }

    override fun getType(): KClass<*> {
        return Boolean::class
    }

}