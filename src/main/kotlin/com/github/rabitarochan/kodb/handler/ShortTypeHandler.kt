package com.github.rabitarochan.kodb.handler

import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.KClass

class ShortTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getShort(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setShort(parameterIndex, value as Short)
    }

    override fun getType(): KClass<*> {
        return Short::class
    }

}