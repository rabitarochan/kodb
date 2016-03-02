package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.ResultSet
import kotlin.reflect.KClass

class ShortExtractor() : ResultSetExtractor<Short> {

    override fun extract(rs: ResultSet): Short {
        return rs.getShort(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        TODO()
    }

    override fun getTargetTypes(): Array<KClass<*>> {
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
        return arrayOf(Short::class, java.lang.Short::class)
    }

}
