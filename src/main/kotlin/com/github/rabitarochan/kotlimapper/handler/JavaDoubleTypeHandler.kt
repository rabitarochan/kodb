package com.github.rabitarochan.kotlimapper.handler

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import java.sql.PreparedStatement
import kotlin.reflect.KClass

class JavaDoubleTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.double(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setDouble(parameterIndex, value as Double)
    }

    override fun getType(): KClass<*> {
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
        return java.lang.Double::class
    }

}
