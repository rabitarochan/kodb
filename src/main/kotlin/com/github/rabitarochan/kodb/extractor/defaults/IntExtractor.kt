package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.ResultSet
import kotlin.reflect.KClass

class IntExtractor() : ResultSetExtractor<Int> {

    override fun extract(rs: ResultSet): Int {
        return rs.getInt(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return Int::class
    }

}