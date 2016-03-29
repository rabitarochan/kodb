package com.github.rabitarochan.kotlimapper.extractor.defaults

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import com.github.rabitarochan.kotlimapper.extractor.ResultSetExtractor
import kotlin.reflect.KClass

class ByteArrayExtractor() : ResultSetExtractor<ByteArray> {

    override fun extract(rs: WrappedResultSet): ByteArray? {
        return rs.bytes(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return ByteArray::class
    }
}
