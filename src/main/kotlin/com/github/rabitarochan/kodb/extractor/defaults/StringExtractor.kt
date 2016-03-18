package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.WrappedResultSet
import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import kotlin.reflect.KClass

class StringExtractor() : ResultSetExtractor<String> {

    override fun extract(rs: WrappedResultSet): String? {
        return rs.string(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return String::class
    }

}
