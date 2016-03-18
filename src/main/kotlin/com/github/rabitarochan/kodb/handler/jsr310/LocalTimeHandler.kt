package com.github.rabitarochan.kodb.handler.jsr310

import com.github.rabitarochan.kodb.WrappedResultSet
import com.github.rabitarochan.kodb.handler.TypeHandler
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDate
import java.time.LocalTime
import kotlin.reflect.KClass

class LocalTimeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.sqlTime(name)?.toLocalTime()
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setTime(parameterIndex, java.sql.Time.valueOf(value as LocalTime))
    }

    override fun getType(): KClass<*> {
        return LocalTime::class
    }

}
