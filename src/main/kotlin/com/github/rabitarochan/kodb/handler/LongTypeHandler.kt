package com.github.rabitarochan.kodb.handler

import java.sql.ResultSet
import kotlin.reflect.KClass

class LongTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getLong(name)
    }

    override fun getType(): KClass<*> {
        return Long::class
    }

}