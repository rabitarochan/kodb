package com.github.rabitarochan.kotlimapper.handler

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import java.sql.PreparedStatement
import kotlin.reflect.KClass

class StringTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.string(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setString(parameterIndex, value as String)
    }

    override fun getType(): KClass<*> {
        return String::class
    }

}
