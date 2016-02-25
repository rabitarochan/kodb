package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.ResultSet
import kotlin.reflect.KClass

class LongExtractor() : ResultSetExtractor<Long> {

    override fun extract(rs: ResultSet): Long {
        return rs.getLong(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return Long::class
    }

}