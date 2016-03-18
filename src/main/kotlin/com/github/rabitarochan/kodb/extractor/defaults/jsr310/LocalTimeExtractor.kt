package com.github.rabitarochan.kodb.extractor.defaults.jsr310

import com.github.rabitarochan.kodb.WrappedResultSet
import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import com.github.rabitarochan.kodb.extractor.defaults.firstColumnIndex
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
