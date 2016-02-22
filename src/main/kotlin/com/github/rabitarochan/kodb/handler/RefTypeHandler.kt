package com.github.rabitarochan.kodb.handler

import java.sql.Ref
import java.sql.ResultSet
import kotlin.reflect.KClass

class RefTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getRef(name)
    }

    override fun getType(): KClass<*> {
        return Ref::class
    }

}