package com.github.rabitarochan.kodb.handler

import java.sql.Blob
import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.KClass

class BlobTypeHandler() : TypeHandler {

    override fun get(name: String, rs: ResultSet): Any {
        return rs.getBlob(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setBlob(parameterIndex, value as Blob)
    }

    override fun getType(): KClass<*> {
        return Blob::class
    }

}