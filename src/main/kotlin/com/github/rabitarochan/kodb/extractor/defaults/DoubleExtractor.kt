package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.WrappedResultSet
import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import kotlin.reflect.KClass

class DoubleExtractor() : ResultSetExtractor<Double> {

    override fun extract(rs: WrappedResultSet): Double? {
        return rs.double(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        TODO()
    }

    override fun getTargetTypes(): Array<KClass<*>> {
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
        return arrayOf(Double::class, java.lang.Double::class)
    }

}
