package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.ResultSet
import java.sql.Timestamp
import kotlin.reflect.KClass

class SQLTimestampExtractor() : ResultSetExtractor<Timestamp> {

    override fun extract(rs: ResultSet): Timestamp {
        return rs.getTimestamp(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return Timestamp::class
    }

}
