package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.WrappedResultSet
import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import kotlin.reflect.KClass

class ByteExtractor() : ResultSetExtractor<Byte> {

    override fun extract(rs: WrappedResultSet): Byte? {
        return rs.byte(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        TODO()
    }

    override fun getTargetTypes(): Array<KClass<*>> {
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
        return arrayOf(Byte::class, java.lang.Byte::class)
    }

}
