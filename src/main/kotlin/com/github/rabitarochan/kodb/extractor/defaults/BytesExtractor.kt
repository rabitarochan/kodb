package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.WrappedResultSet
import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import kotlin.reflect.KClass

class BytesExtractor() : ResultSetExtractor<Array<Byte>> {

    override fun extract(rs: WrappedResultSet): Array<Byte>? {
        return rs.bytes(firstColumnIndex)?.toTypedArray()
    }

    override fun getTargetType(): KClass<*> {
        return Array<Byte>::class
    }
}
