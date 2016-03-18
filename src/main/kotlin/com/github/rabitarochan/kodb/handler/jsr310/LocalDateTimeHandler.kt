package com.github.rabitarochan.kodb.handler.jsr310

import com.github.rabitarochan.kodb.WrappedResultSet
import com.github.rabitarochan.kodb.handler.TypeHandler
import java.sql.PreparedStatement
import java.time.LocalDateTime
import kotlin.reflect.KClass

class LocalDateTimeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.sqlTimestamp(name)?.toLocalDateTime()
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setTimestamp(parameterIndex, java.sql.Timestamp.valueOf(value as LocalDateTime))
    }

    override fun getType(): KClass<*> {
        return LocalDateTime::class
    }

}
