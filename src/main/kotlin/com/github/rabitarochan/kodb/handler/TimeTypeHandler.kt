package com.github.rabitarochan.kodb.handler

import java.sql.ResultSet
import java.sql.Time
import kotlin.reflect.KClass

class TimeTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getTime(name)
    }

    override fun getType(): KClass<*> {
        return Time::class
    }

}