package com.github.rabitarochan.kodb.handler

import com.github.rabitarochan.kodb.WrappedResultSet
import java.sql.PreparedStatement
import java.sql.Time
import kotlin.reflect.KClass

class TimeTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.sqlTime(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setTime(parameterIndex, value as Time)
    }

    override fun getType(): KClass<*> {
        return Time::class
    }

}
