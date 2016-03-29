package com.github.rabitarochan.kotlimapper.handler

import com.github.rabitarochan.kotlimapper.WrappedResultSet
import java.sql.PreparedStatement
import java.sql.SQLXML
import kotlin.reflect.KClass

class SqlXmlTypeHandler() : TypeHandler {

    override fun getValue(rs: WrappedResultSet, name: String): Any? {
        return rs.sqlXml(name)
    }

    override fun setValue(ps: PreparedStatement, parameterIndex: Int, value: Any) {
        ps.setSQLXML(parameterIndex, value as SQLXML)
    }

    override fun getType(): KClass<*> {
        return SQLXML::class
    }

}
