package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.Date
import java.sql.ResultSet
import kotlin.reflect.KClass

class SQLDateExtractor() : ResultSetExtractor<Date> {

    override fun extract(rs: ResultSet): Date {
        return rs.getDate(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return Date::class
    }

}
