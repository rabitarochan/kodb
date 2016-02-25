package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.ResultSet
import kotlin.reflect.KClass

class ByteExtractor() : ResultSetExtractor<Byte> {

    override fun extract(rs: ResultSet): Byte {
        return rs.getByte(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return Byte::class
    }
}
