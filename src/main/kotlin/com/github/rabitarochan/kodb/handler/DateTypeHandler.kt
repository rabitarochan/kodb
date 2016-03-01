package com.github.rabitarochan.kodb.handler

import java.sql.Date
import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.KClass

class DateTypeHandler() : TypeHandler {

    override fun getValue(rs: ResultSet, name: String): Any? {
        return rs.getDate(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setDate(parameterIndex, value as Date)
    }

    override fun getType(): KClass<*> {
        return Date::class
    }

}
