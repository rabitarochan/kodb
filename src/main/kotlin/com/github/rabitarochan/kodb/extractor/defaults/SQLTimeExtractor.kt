package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.Time
import java.sql.ResultSet
import kotlin.reflect.KClass

class SQLTimeExtractor() : ResultSetExtractor<Time> {

    override fun extract(rs: ResultSet): Time {
        return rs.getTime(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return Time::class
    }

}
