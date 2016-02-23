package com.github.rabitarochan.kodb.handler

import java.math.BigDecimal
import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.KClass

class BigDecimalTypeHandler() : TypeHandler {

    override fun getType(): KClass<*> {
        return BigDecimal::class
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setBigDecimal(parameterIndex, value as BigDecimal)
    }

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getBigDecimal(name)
    }

}