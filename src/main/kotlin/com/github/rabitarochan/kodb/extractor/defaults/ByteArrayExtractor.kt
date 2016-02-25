package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.ResultSet
import kotlin.reflect.KClass

class ByteArrayExtractor() : ResultSetExtractor<ByteArray> {

    override fun extract(rs: ResultSet): ByteArray {
        return rs.getBytes(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return ByteArray::class
    }
}
