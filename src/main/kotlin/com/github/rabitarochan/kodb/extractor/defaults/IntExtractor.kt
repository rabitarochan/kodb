package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.WrappedResultSet
import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import kotlin.reflect.KClass

class IntExtractor() : ResultSetExtractor<Int> {

    override fun extract(rs: WrappedResultSet): Int? {
        return rs.int(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        TODO()
    }

    override fun getTargetTypes(): Array<KClass<*>> {
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
        return arrayOf(Int::class, java.lang.Integer::class)
    }

}
