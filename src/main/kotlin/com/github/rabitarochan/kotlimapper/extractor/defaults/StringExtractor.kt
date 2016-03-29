package com.github.rabitarochan.kotlimapper.extractor.defaults

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import com.github.rabitarochan.kotlimapper.extractor.ResultSetExtractor
import kotlin.reflect.KClass

class StringExtractor() : ResultSetExtractor<String> {

    override fun extract(rs: WrappedResultSet): String? {
        return rs.string(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return String::class
    }

}
