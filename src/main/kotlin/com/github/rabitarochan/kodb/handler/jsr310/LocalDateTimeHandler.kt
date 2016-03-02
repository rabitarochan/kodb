package com.github.rabitarochan.kodb.handler.jsr310

import com.github.rabitarochan.kodb.handler.TypeHandler
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.reflect.KClass

class LocalDateTimeHandler() : TypeHandler {

    override fun getValue(rs: ResultSet, name: String): Any? {
        val sqlTimestamp = rs.getTimestamp(name) ?: return null
        val localDateTime = sqlTimestamp.toLocalDateTime()
        return localDateTime
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setTimestamp(parameterIndex, java.sql.Timestamp.valueOf(value as LocalDateTime))
    }

    override fun getType(): KClass<*> {
        return LocalDateTime::class
    }

}
