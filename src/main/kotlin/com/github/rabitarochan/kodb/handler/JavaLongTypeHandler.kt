package com.github.rabitarochan.kodb.handler

import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.KClass

class JavaLongTypeHandler() : TypeHandler {

    override fun getValue(rs: ResultSet, name: String): Any? {
        return rs.getLong(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setLong(parameterIndex, value as Long)
    }

    override fun getType(): KClass<*> {
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
        return java.lang.Long::class
    }

}
