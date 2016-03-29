package com.github.rabitarochan.kotlimapper.extractor.defaults

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import com.github.rabitarochan.kotlimapper.extractor.ResultSetExtractor
import java.util.*
import kotlin.reflect.KClass

class DateExtractor() : ResultSetExtractor<Date> {

    override fun extract(rs: WrappedResultSet): Date? {
        return rs.sqlTimestamp(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return Date::class
    }

}
