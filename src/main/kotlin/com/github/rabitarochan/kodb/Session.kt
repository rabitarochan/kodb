package com.github.rabitarochan.kodb

import com.github.rabitarochan.kodb.extractor.ExtractorFactory
import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import com.github.rabitarochan.kodb.handler.TypeHandler
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Types
import kotlin.reflect.KFunction
import kotlin.reflect.defaultType
import kotlin.reflect.jvm.javaType
import kotlin.reflect.primaryConstructor

class Session(val connection: Connection) {

    fun <T : Any> queryRaw(sql: String, f: (ResultSet) -> T): List<T> {
        val ps = connection.prepareStatement(sql)
        val rs = ps.executeQuery()

        var xs = mutableListOf<T>()
        while (rs.next()) {
            xs.add(f(rs))
        }
        return xs
    }

    inline fun <reified T : Any?> query(sql: String, params: Array<Any?>? = null): List<T> {
        val ps = createStatement(connection, sql, params)
        val rs = ps.executeQuery()

        val typeName = T::class.defaultType.javaType.typeName

        val extractor = ResultSetExtractor.get(typeName, { T::class.constructors.first() })
        val result = mutableListOf<T?>()
        while(rs.next()) {
            result.add(extractor.extract(rs))
        }

        @Suppress("UNCHECKED_CAST")
        return result as List<T>
    }

    inline fun <reified T : Any?> queryOne(sql: String, params: Array<Any?>? = null): T? {
        val ps = createStatement(connection, sql, params)
        val rs = ps.executeQuery()

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

}
