package com.github.rabitarochan.kodb.handler

import java.sql.Date
import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.KClass

class DateTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getDate(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setDate(parameterIndex, value as Date)
    }

    override fun getType(): KClass<*> {
        return Date::class
    }

}