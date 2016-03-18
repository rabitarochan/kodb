package com.github.rabitarochan.kodb.handler

import com.github.rabitarochan.kodb.WrappedResultSet
import java.sql.PreparedStatement
import kotlin.reflect.KClass

class JavaIntTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.int(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setInt(parameterIndex, value as Int)
    }

    override fun getType(): KClass<*> {
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
        return java.lang.Integer::class
    }

}
