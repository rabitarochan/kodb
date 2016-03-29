package com.github.rabitarochan.kotlimapper.handler

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import java.sql.Clob
import java.sql.PreparedStatement
import kotlin.reflect.KClass

class ClobTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.clob(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setClob(parameterIndex, value as Clob)
    }

    override fun getType(): KClass<*> {
        return Clob::class
    }

}
