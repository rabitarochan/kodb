package com.github.rabitarochan.kotlimapper.handler

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import java.sql.Blob
import java.sql.PreparedStatement
import kotlin.reflect.KClass

class BlobTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.blob(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setBlob(parameterIndex, value as Blob)
    }

    override fun getType(): KClass<*> {
        return Blob::class
    }

}
