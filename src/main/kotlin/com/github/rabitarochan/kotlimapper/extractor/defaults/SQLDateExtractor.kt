package com.github.rabitarochan.kotlimapper.extractor.defaults

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import com.github.rabitarochan.kotlimapper.extractor.ResultSetExtractor
import java.sql.Date
import kotlin.reflect.KClass

class SQLDateExtractor() : ResultSetExtractor<Date> {

    override fun extract(rs: WrappedResultSet): Date? {
        return rs.sqlDate(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return Date::class
    }

}
