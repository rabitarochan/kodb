package com.github.rabitarochan.kodb.handler

import com.github.rabitarochan.kodb.WrappedResultSet
import java.sql.PreparedStatement
import java.sql.Ref
import kotlin.reflect.KClass

class RefTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.ref(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setRef(parameterIndex, value as Ref)
    }

    override fun getType(): KClass<*> {
        return Ref::class
    }

}
