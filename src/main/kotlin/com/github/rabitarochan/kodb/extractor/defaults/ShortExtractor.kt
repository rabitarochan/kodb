package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.ResultSet
import kotlin.reflect.KClass

class ShortExtractor() : ResultSetExtractor<Short> {

    override fun extract(rs: ResultSet): Short {
        return rs.getShort(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return Short::class
    }

}
