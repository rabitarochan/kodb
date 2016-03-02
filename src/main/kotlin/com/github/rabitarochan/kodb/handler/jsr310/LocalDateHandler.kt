package com.github.rabitarochan.kodb.handler.jsr310

import com.github.rabitarochan.kodb.handler.TypeHandler
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDate
import kotlin.reflect.KClass

class LocalDateHandler() : TypeHandler {

    override fun getValue(rs: ResultSet, name: String): Any? {
        val sqlDate = rs.getDate(name) ?: return null
        val localDate = sqlDate.toLocalDate()
        return localDate
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setDate(parameterIndex, java.sql.Date.valueOf(value as LocalDate))
    }

    override fun getType(): KClass<*> {
        return LocalDate::class
    }

}
