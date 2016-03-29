package com.github.rabitarochan.kotlimapper.extractor.defaults

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import com.github.rabitarochan.kotlimapper.extractor.ResultSetExtractor
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
