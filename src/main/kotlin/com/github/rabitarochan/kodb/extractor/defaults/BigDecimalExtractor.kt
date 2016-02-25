package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.math.BigDecimal
import java.sql.ResultSet
import kotlin.reflect.KClass

class BigDecimalExtractor() : ResultSetExtractor<BigDecimal> {

    override fun extract(rs: ResultSet): BigDecimal {
        return rs.getBigDecimal(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return BigDecimal::class
    }
}
