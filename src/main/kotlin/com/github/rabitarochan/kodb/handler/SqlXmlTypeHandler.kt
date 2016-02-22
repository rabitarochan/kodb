package com.github.rabitarochan.kodb.handler

import java.sql.ResultSet
import java.sql.SQLXML
import kotlin.reflect.KClass

class SqlXmlTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getSQLXML(name)
    }

    override fun getType(): KClass<*> {
        return SQLXML::class
    }

}