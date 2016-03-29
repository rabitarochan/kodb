package com.github.rabitarochan.kotlimapper

import com.github.rabitarochan.kotlimapper.extractor.ResultSetExtractor
import com.github.rabitarochan.kotlimapper.handler.TypeHandler
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.Types
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.defaultType
import kotlin.reflect.jvm.javaType

class Session(val connection: Connection) {

    fun <T : Any> queryRaw(sql: String, f: (WrappedResultSet) -> T): List<T> {
        val ps = connection.prepareStatement(sql)
        val rs = WrappedResultSet(ps.executeQuery())

        var xs = mutableListOf<T>()
        while (rs.next()) {
            xs.add(f(rs))
        }
        return xs
    }

    inline fun <reified T> query(sql: String, params: Array<Any?>? = null): List<T> {
        val ps = createStatement(connection, sql, params)
        val rs = WrappedResultSet(ps.executeQuery())

        val typeName = T::class.defaultType.javaType.typeName

        val extractor = ResultSetExtractor.get(typeName, { T::class.constructors.first() })
        val result = mutableListOf<T?>()
        while(rs.next()) {
            result.add(extractor.extract(rs))
        }

        @Suppress("UNCHECKED_CAST")
        return result as List<T>
    }

    inline fun <reified T> queryOne(sql: String, params: Array<Any?>? = null): T? {
        val ps = createStatement(connection, sql, params)
        val rs = WrappedResultSet(ps.executeQuery())

        val typeName = T::class.defaultType.javaType.typeName

        val extractor = ResultSetExtractor.get(typeName, { T::class.constructors.first() })

        if (rs.next()) {
            return extractor.extract(rs)
        } else {
            return null
        }
    }

    fun update(sql: String, params: Array<Any?>? = null): Int {
        val ps = createStatement(connection, sql, params)
        val result = ps.executeUpdate()
        return result
    }

    fun execute(sql: String, params: Array<Any?>? = null): Boolean {
        val ps = createStatement(connection, sql, params)
        val result = ps.execute()
        return result
    }

    fun createStatement(conn: Connection, sql: String, params: Array<Any?>?): PreparedStatement {
        val ps = conn.prepareStatement(sql)
        if (params == null) return ps

        params.forEachIndexed { i, param ->
            if (param == null) {
                ps.setNull(i + 1, Types.NULL)
            } else {
                val kclass = param.javaClass.kotlin
                val handler = TypeHandler.get(kclass)
                handler.setValue(ps, i + 1, param)
            }
        }
        return ps
    }

    private fun <T: Any> getConstructor(kc: KClass<T>): KFunction<T> {
        return kc.constructors.first()
    }

}
