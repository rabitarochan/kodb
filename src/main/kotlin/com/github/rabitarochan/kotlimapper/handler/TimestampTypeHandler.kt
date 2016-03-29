package com.github.rabitarochan.kotlimapper.handler

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import java.sql.PreparedStatement
import java.sql.Timestamp
import kotlin.reflect.KClass

class TimestampTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.sqlTimestamp(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setTimestamp(parameterIndex, value as Timestamp)
    }

    override fun getType(): KClass<*> {
        return Timestamp::class
    }

}
