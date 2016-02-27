package com.github.rabitarochan.kodb.handler

import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.KClass

class ArrayTypeHandler() : TypeHandler {

    override fun getValue(rs: ResultSet, name: String): Any {
        return rs.getArray(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setArray(parameterIndex, value as java.sql.Array)
    }

    override fun getType(): KClass<*> {
        return java.sql.Array::class
    }

}