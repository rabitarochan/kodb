package com.github.rabitarochan.kodb.handler

import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.KClass

class FloatTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getFloat(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setFloat(parameterIndex, value as Float)
    }

    override fun getType(): KClass<*> {
        return Float::class
    }

}