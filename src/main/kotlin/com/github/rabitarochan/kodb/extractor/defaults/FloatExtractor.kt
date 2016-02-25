package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.ResultSet
import kotlin.reflect.KClass

class FloatExtractor() : ResultSetExtractor<Float> {

    override fun extract(rs: ResultSet): Float {
        return rs.getFloat(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return Float::class
    }
}
