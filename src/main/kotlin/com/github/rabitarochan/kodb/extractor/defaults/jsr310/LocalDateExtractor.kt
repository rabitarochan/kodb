package com.github.rabitarochan.kodb.extractor.defaults.jsr310

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import com.github.rabitarochan.kodb.extractor.defaults.firstColumnIndex
import java.sql.ResultSet
import java.time.LocalDate
import kotlin.reflect.KClass


class LocalDateExtractor() : ResultSetExtractor<LocalDate> {

    override fun extract(rs: ResultSet): LocalDate {
        val sqlDate = rs.getDate(firstColumnIndex)
        val localDate = sqlDate.toLocalDate()
        return localDate
    }

    override fun getTargetType(): KClass<*> {
        return LocalDate::class
    }

}
