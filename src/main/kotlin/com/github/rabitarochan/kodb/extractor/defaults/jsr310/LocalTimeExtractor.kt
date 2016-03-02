package com.github.rabitarochan.kodb.extractor.defaults.jsr310

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import com.github.rabitarochan.kodb.extractor.defaults.firstColumnIndex
import java.sql.ResultSet
import java.time.LocalTime
import kotlin.reflect.KClass


class LocalTimeExtractor() : ResultSetExtractor<LocalTime> {

    override fun extract(rs: ResultSet): LocalTime? {
        val sqlTime = rs.getTime(firstColumnIndex) ?: return null
        val localTime = sqlTime.toLocalTime()
        return localTime
    }

    override fun getTargetType(): KClass<*> {
        return LocalTime::class
    }

}
