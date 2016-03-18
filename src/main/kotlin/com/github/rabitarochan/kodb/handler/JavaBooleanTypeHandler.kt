package com.github.rabitarochan.kodb.handler

import com.github.rabitarochan.kodb.WrappedResultSet
import java.sql.PreparedStatement
import kotlin.reflect.KClass

class JavaBooleanTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.boolean(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setBoolean(parameterIndex, value as Boolean)
    }

    override fun getType(): KClass<*> {
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
        return java.lang.Boolean::class
    }

}
