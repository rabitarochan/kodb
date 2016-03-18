package com.github.rabitarochan.kodb.extractor.defaults.jsr310

import com.github.rabitarochan.kodb.WrappedResultSet
import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import com.github.rabitarochan.kodb.extractor.defaults.firstColumnIndex
import java.time.LocalDate
import kotlin.reflect.KClass


class LocalDateExtractor() : ResultSetExtractor<LocalDate> {

    override fun extract(rs: WrappedResultSet): LocalDate? {
        return rs.sqlDate(firstColumnIndex)?.toLocalDate()
    }

    override fun getTargetType(): KClass<*> {
        return LocalDate::class
    }

}
