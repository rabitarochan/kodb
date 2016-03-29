package com.github.rabitarochan.kotlimapper.extractor.defaults.jsr310

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import com.github.rabitarochan.kotlimapper.extractor.ResultSetExtractor
import com.github.rabitarochan.kotlimapper.extractor.defaults.firstColumnIndex
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
