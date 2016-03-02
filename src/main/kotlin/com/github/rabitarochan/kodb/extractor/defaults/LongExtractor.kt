package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.ResultSet
import kotlin.reflect.KClass

class LongExtractor() : ResultSetExtractor<Long> {

    override fun extract(rs: ResultSet): Long {
        return rs.getLong(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        TODO()
    }

    override fun getTargetTypes(): Array<KClass<*>> {
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
        return arrayOf(Long::class, java.lang.Long::class)
    }

}
