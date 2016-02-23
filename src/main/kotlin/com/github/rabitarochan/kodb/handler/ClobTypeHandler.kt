package com.github.rabitarochan.kodb.handler

import java.sql.Clob
import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.KClass

class ClobTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getClob(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setClob(parameterIndex, value as Clob)
    }

    override fun getType(): KClass<*> {
        return Clob::class
    }

}