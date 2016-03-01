package com.github.rabitarochan.kodb.handler

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.RowId
import kotlin.reflect.KClass

class RowIdTypeHandler() : TypeHandler {

    override fun getValue(rs: ResultSet, name: String): Any? {
        return rs.getRowId(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setRowId(parameterIndex, value as RowId)
    }

    override fun getType(): KClass<*> {
        return RowId::class
    }

}
