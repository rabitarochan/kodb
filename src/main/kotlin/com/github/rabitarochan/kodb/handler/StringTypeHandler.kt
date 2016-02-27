package com.github.rabitarochan.kodb.handler

import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.KClass

class StringTypeHandler() : TypeHandler {

    override fun getValue(rs: ResultSet, name: String): Any {
        return rs.getString(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setString(parameterIndex, value as String)
    }

    override fun getType(): KClass<*> {
        return String::class
    }

}