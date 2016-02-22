package com.github.rabitarochan.kodb.handler

import java.sql.ResultSet
import java.sql.RowId
import kotlin.reflect.KClass

class RowIdTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getRowId(name)
    }

    override fun getType(): KClass<*> {
        return RowId::class
    }

}