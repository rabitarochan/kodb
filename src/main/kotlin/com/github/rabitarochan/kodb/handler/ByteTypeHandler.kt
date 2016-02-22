package com.github.rabitarochan.kodb.handler

import java.sql.ResultSet
import kotlin.reflect.KClass

class ByteTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getByte(name)
    }

    override fun getType(): KClass<*> {
        return Byte::class
    }


}