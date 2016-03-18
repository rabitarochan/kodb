package com.github.rabitarochan.kodb.handler

import com.github.rabitarochan.kodb.WrappedResultSet
import java.sql.PreparedStatement
import kotlin.reflect.KClass

class FloatTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.float(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setFloat(parameterIndex, value as Float)
    }

    override fun getType(): KClass<*> {
        return Float::class
    }

}
