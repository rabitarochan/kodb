package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.ResultSet
import java.util.*
import kotlin.reflect.KClass

class DateExtractor() : ResultSetExtractor<Date> {

    override fun extract(rs: ResultSet): Date {
        return rs.getTimestamp(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return Date::class
    }

}
