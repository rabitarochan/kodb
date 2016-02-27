package com.github.rabitarochan.kodb.handler

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Time
import kotlin.reflect.KClass

class TimeTypeHandler() : TypeHandler {

    override fun getValue(rs: ResultSet, name: String): Any {
        return rs.getTime(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setTime(parameterIndex, value as Time)
    }

    override fun getType(): KClass<*> {
        return Time::class
    }

}