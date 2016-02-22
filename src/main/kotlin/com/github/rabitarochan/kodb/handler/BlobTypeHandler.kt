package com.github.rabitarochan.kodb.handler

import java.sql.Blob
import java.sql.ResultSet
import kotlin.reflect.KClass

class BlobTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getBlob(name)
    }

    override fun getType(): KClass<*> {
        return Blob::class
    }

}