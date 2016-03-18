package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.WrappedResultSet
import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.Time
import kotlin.reflect.KClass

class SQLTimeExtractor() : ResultSetExtractor<Time> {

    override fun extract(rs: WrappedResultSet): Time? {
        return rs.sqlTime(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return Time::class
    }

}
