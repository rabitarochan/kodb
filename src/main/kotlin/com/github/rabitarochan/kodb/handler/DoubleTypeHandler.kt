package com.github.rabitarochan.kodb.handler

import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.KClass

class DoubleTypeHandler() : TypeHandler {

    override fun getValue(rs: ResultSet, name: String): Any? {
        return rs.getDouble(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setDouble(parameterIndex, value as Double)
    }

    override fun getType(): KClass<*> {
        return Double::class
    }

}
