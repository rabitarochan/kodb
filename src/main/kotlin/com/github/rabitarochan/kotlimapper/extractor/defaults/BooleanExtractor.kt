package com.github.rabitarochan.kotlimapper.extractor.defaults

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import com.github.rabitarochan.kotlimapper.extractor.ResultSetExtractor
import kotlin.reflect.KClass

class BooleanExtractor() : ResultSetExtractor<Boolean> {

    override fun extract(rs: WrappedResultSet): Boolean? {
        return rs.boolean(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        TODO()
    }

    override fun getTargetTypes(): Array<KClass<*>> {
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
        return arrayOf(Boolean::class, java.lang.Boolean::class)
    }

}
