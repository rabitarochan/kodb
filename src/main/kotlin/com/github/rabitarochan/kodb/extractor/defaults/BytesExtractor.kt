package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.ResultSet
import kotlin.reflect.KClass

class BytesExtractor() : ResultSetExtractor<Array<Byte>> {

    override fun extract(rs: ResultSet): Array<Byte> {
        return rs.getBytes(firstColumnIndex).toTypedArray()
    }

    override fun getTargetType(): KClass<*> {
        return Array<Byte>::class
    }
}
