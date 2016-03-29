package com.github.rabitarochan.kotlimapper.handler

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import java.sql.Date
import java.sql.PreparedStatement
import kotlin.reflect.KClass

class DateTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.sqlDate(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setDate(parameterIndex, value as Date)
    }

    override fun getType(): KClass<*> {
        return Date::class
    }

}
