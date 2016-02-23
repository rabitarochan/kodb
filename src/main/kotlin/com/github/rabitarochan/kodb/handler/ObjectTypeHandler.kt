package com.github.rabitarochan.kodb.handler

import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.KClass

class ObjectTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getObject(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setObject(parameterIndex, value)
    }

    override fun getType(): KClass<*> {
        return Any::class
    }

}
