package com.github.rabitarochan.kodb.handler

import com.github.rabitarochan.kodb.WrappedResultSet
import java.sql.PreparedStatement
import kotlin.reflect.KClass

class ByteTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.byte(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setByte(parameterIndex, value as Byte)
    }

    override fun getType(): KClass<*> {
        return Byte::class
    }

}
