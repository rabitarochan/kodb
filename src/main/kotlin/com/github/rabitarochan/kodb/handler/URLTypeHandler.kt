package com.github.rabitarochan.kodb.handler

import java.net.URL
import java.sql.ResultSet
import kotlin.reflect.KClass

class URLTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getURL(name)
    }

    override fun getType(): KClass<*> {
        return URL::class
    }


}