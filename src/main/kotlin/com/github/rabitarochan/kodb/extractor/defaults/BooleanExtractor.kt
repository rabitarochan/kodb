package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.sql.ResultSet
import kotlin.reflect.KClass

class BooleanExtractor() : ResultSetExtractor<Boolean> {

    override fun extract(rs: ResultSet): Boolean {
        return rs.getBoolean(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return Boolean::class
    }

}
