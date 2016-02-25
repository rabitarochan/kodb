package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.ResultSet
import kotlin.reflect.KClass

class StringExtractor() : ResultSetExtractor<String> {

    override fun extract(rs: ResultSet): String {
        return rs.getString(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return String::class
    }

}