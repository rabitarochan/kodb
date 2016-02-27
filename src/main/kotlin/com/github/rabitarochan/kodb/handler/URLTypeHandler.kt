package com.github.rabitarochan.kodb.handler

import java.net.URL
import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.KClass

class URLTypeHandler() : TypeHandler {

    override fun getValue(rs: ResultSet, name: String): Any {
        return rs.getURL(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setURL(parameterIndex, value as URL)
    }

    override fun getType(): KClass<*> {
        return URL::class
    }

}