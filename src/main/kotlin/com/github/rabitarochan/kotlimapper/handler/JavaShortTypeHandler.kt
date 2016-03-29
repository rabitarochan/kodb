package com.github.rabitarochan.kotlimapper.handler

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import java.sql.PreparedStatement
import kotlin.reflect.KClass

class JavaShortTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.short(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setShort(parameterIndex, value as Short)
    }

    override fun getType(): KClass<*> {
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
        return java.lang.Short::class
    }

}
