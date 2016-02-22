package com.github.rabitarochan.kodb.handler

import java.sql.Clob
import java.sql.ResultSet
import kotlin.reflect.KClass

class ClobTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getClob(name)
    }

    override fun getType(): KClass<*> {
        return Clob::class
    }

}