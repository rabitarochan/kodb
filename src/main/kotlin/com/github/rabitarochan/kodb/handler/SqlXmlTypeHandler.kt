package com.github.rabitarochan.kodb.handler

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLXML
import kotlin.reflect.KClass

class SqlXmlTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getSQLXML(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setSQLXML(parameterIndex, value as SQLXML)
    }

    override fun getType(): KClass<*> {
        return SQLXML::class
    }

}