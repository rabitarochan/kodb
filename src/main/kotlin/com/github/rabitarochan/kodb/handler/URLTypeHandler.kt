package com.github.rabitarochan.kodb.handler

import com.github.rabitarochan.kodb.WrappedResultSet
import java.net.URL
import java.sql.PreparedStatement
import kotlin.reflect.KClass

class URLTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.url(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setURL(parameterIndex, value as URL)
    }

    override fun getType(): KClass<*> {
        return URL::class
    }

}
