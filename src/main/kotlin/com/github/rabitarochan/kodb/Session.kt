package com.github.rabitarochan.kodb

import com.github.rabitarochan.kodb.extractor.ExtractorFactory
import com.github.rabitarochan.kodb.extractor.ResultSetExtractor
import com.github.rabitarochan.kodb.handler.TypeHandler
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.reflect.defaultType

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

    inline fun <reified T : Any> query(sql: String, params: Array<Any>? = null): List<T> {
        val ps = createStatement(connection, sql, params)
        val rs = ps.executeQuery()

        val extractor = ResultSetExtractor.get(T::class)
        val result = mutableListOf<T>()
        while(rs.next()) {
            result.add(extractor.extract(rs))
        }
        return result
    }

    inline fun <reified T : Any> queryOne(sql: String, params: Array<Any>? = null): T? {
        val ps = createStatement(connection, sql, params)
        val rs = ps.executeQuery()

        val extractor = ResultSetExtractor.get(T::class)

        if (rs.next()) {
            return extractor.extract(rs)
        } else {
            return null
        }
    }

    fun update(sql: String, params: Array<Any>? = null): Int {
        val ps = createStatement(connection, sql, params)
        val result = ps.executeUpdate()
        return result
    }

    fun execute(sql: String, params: Array<Any>? = null): Boolean {
        val ps = createStatement(connection, sql, params)
        val result = ps.execute()
        return result
    }

    fun createStatement(conn: Connection, sql: String, params: Array<Any>?): PreparedStatement {
        val ps = conn.prepareStatement(sql)
        if (params == null) return ps

        params.forEachIndexed { i, param ->
            val kclass = param.javaClass.kotlin
            val handler = TypeHandler.get(kclass)
            handler.setValue(ps, i + 1, param)
        }
        return ps
    }

}
