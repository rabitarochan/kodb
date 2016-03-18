package com.github.rabitarochan.kodb.extractor.defaults

import com.github.rabitarochan.kodb.WrappedResultSet
import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import java.math.BigDecimal
import kotlin.reflect.KClass

class BigDecimalExtractor() : ResultSetExtractor<BigDecimal> {

    override fun extract(rs: WrappedResultSet): BigDecimal? {
        return rs.bigDecimal(firstColumnIndex)
    }

    override fun getTargetType(): KClass<*> {
        return BigDecimal::class
    }
}
