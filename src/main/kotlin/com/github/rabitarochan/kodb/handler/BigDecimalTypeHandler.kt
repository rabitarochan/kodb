package com.github.rabitarochan.kodb.handler

import com.github.rabitarochan.kodb.WrappedResultSet
import java.math.BigDecimal
import java.sql.PreparedStatement
import kotlin.reflect.KClass

class BigDecimalTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.bigDecimal(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setBigDecimal(parameterIndex, value as BigDecimal)
    }

    override fun getType(): KClass<*> {
        return BigDecimal::class
    }

}
