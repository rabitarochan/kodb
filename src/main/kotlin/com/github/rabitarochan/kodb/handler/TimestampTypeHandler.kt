package com.github.rabitarochan.kodb.handler

import java.sql.ResultSet
import java.sql.Timestamp
import kotlin.reflect.KClass

class TimestampTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getTimestamp(name)
    }

    override fun getType(): KClass<*> {
        return Timestamp::class
    }

}