package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.WrappedResultSet
import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
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
