package com.github.rabitarochan.kodb.handler

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Timestamp
import kotlin.reflect.KClass

class TimestampTypeHandler() : TypeHandler {

    override fun getValue(rs: ResultSet, name: String): Any {
        return rs.getTimestamp(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setTimestamp(parameterIndex, value as Timestamp)
    }

    override fun getType(): KClass<*> {
        return Timestamp::class
    }

}