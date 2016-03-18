package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.WrappedResultSet
import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.Timestamp
import kotlin.reflect.KClass

class SQLTimestampExtractor() : ResultSetExtractor<Timestamp> {

    override fun extract(rs: WrappedResultSet): Timestamp? {
        return rs.sqlTimestamp(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return Timestamp::class
    }

}
