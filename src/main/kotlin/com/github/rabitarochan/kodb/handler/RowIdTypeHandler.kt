package com.github.rabitarochan.kodb.handler

import com.github.rabitarochan.kodb.WrappedResultSet
import java.sql.PreparedStatement
import java.sql.RowId
import kotlin.reflect.KClass

class RowIdTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.rowId(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setRowId(parameterIndex, value as RowId)
    }

    override fun getType(): KClass<*> {
        return RowId::class
    }

}
