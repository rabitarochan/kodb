package com.github.rabitarochan.kodb.handler

import com.github.rabitarochan.kodb.WrappedResultSet
import java.sql.PreparedStatement
import kotlin.reflect.KClass

class JavaByteTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.byte(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setByte(parameterIndex, value as Byte)
    }

    override fun getType(): KClass<*> {
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
        return java.lang.Byte::class
    }

}
