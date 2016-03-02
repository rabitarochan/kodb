package com.github.rabitarochan.kodb.handler.jsr310

import com.github.rabitarochan.kodb.handler.TypeHandler
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDate
import java.time.LocalTime
import kotlin.reflect.KClass

class LocalTimeHandler() : TypeHandler {

    override fun getValue(rs: ResultSet, name: String): Any? {
        val sqlTime = rs.getTime(name) ?: return null
        val localTime = sqlTime.toLocalTime()
        return localTime
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setTime(parameterIndex, java.sql.Time.valueOf(value as LocalTime))
    }

    override fun getType(): KClass<*> {
        return LocalTime::class
    }

}
