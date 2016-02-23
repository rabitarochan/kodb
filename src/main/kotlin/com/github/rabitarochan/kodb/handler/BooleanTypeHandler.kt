package com.github.rabitarochan.kodb.handler

import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.KClass

class BooleanTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getBoolean(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setBoolean(parameterIndex, value as Boolean)
    }

    override fun getType(): KClass<*> {
        return Boolean::class
    }

}