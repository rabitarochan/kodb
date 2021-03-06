package com.github.rabitarochan.kotlimapper.extractor.defaults

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import com.github.rabitarochan.kotlimapper.extractor.ResultSetExtractor
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
