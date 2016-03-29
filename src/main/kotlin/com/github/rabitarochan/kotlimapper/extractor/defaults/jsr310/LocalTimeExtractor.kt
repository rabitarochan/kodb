package com.github.rabitarochan.kotlimapper.extractor.defaults.jsr310

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import com.github.rabitarochan.kotlimapper.extractor.ResultSetExtractor
import com.github.rabitarochan.kotlimapper.extractor.defaults.firstColumnIndex
import java.sql.ResultSet
import java.time.LocalTime
import kotlin.reflect.KClass


class LocalTimeExtractor() : ResultSetExtractor<LocalTime> {

    override fun extract(rs: WrappedResultSet): LocalTime? {
        return rs.sqlTime(firstColumnIndex)?.toLocalTime()
    }

    override fun getTargetType(): KClass<*> {
        return LocalTime::class
    }

}
