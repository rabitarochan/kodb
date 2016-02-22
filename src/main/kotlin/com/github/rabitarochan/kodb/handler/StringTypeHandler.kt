package com.github.rabitarochan.kodb.handler

import java.sql.ResultSet
import kotlin.reflect.KClass

class StringTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getString(name)
    }

    override fun getType(): KClass<*> {
        return String::class
    }

}