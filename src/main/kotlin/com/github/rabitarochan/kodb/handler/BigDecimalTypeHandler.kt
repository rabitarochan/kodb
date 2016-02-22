package com.github.rabitarochan.kodb.handler

import java.math.BigDecimal
import java.sql.ResultSet
import kotlin.reflect.KClass

class BigDecimalTypeHandler() : TypeHandler {

    override fun getType(): KClass<*> {
        return BigDecimal::class
    }

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getBigDecimal(name)
    }

}