package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.WrappedResultSet
import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import kotlin.reflect.KClass

class ByteArrayExtractor() : ResultSetExtractor<ByteArray> {

    override fun extract(rs: WrappedResultSet): ByteArray? {
        return rs.bytes(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return ByteArray::class
    }
}
