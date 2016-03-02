package com.github.rabitarochan.kodb.extractor.defaults.jsr310

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import com.github.rabitarochan.kodb.extractor.defaults.firstColumnIndex
import java.sql.ResultSet
import java.time.LocalDateTime
import kotlin.reflect.KClass


class LocalDateTimeExtractor() : ResultSetExtractor<LocalDateTime> {

    override fun extract(rs: ResultSet): LocalDateTime? {
        val sqlDateTime = rs.getTimestamp(firstColumnIndex) ?: return null
        val localDateTime = sqlDateTime.toLocalDateTime()
        return localDateTime
    }

    override fun getTargetType(): KClass<*> {
        return LocalDateTime::class
    }

}
