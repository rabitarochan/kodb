package com.github.rabitarochan.kotlimapper.extractor.defaults.jsr310

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import com.github.rabitarochan.kotlimapper.extractor.ResultSetExtractor
import com.github.rabitarochan.kotlimapper.extractor.defaults.firstColumnIndex
import java.sql.ResultSet
import java.time.LocalDateTime
import kotlin.reflect.KClass


class LocalDateTimeExtractor() : ResultSetExtractor<LocalDateTime> {

    override fun extract(rs: WrappedResultSet): LocalDateTime? {
        return rs.sqlTimestamp(firstColumnIndex)?.toLocalDateTime()
    }

    override fun getTargetType(): KClass<*> {
        return LocalDateTime::class
    }

}
