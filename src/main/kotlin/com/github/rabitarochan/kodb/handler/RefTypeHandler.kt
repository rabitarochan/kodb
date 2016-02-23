package com.github.rabitarochan.kodb.handler

import java.sql.PreparedStatement
import java.sql.Ref
import java.sql.ResultSet
import kotlin.reflect.KClass

class RefTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getRef(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setRef(parameterIndex, value as Ref)
    }

    override fun getType(): KClass<*> {
        return Ref::class
    }

}