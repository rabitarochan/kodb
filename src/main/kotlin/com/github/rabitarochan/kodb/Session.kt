package com.github.rabitarochan.kodb

import com.github.rabitarochan.kodb.extractor.ExtractorFactory
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class Session(val connection: Connection) {

    fun <T : Any> query(sql: String, f: (ResultSet) -> T): List<T> {
        val ps = connection.prepareStatement(sql)
        val rs = ps.executeQuery()

        var xs = mutableListOf<T>()
        while (rs.next()) {
            xs.add(f(rs))
        }
        return xs
    }

    inline fun <reified T : Any> query(sql: String): List<T> {
        val ps = connection.prepareStatement(sql)
        val rs = ps.executeQuery()

        val extractor = ExtractorFactory.get<T>()
        val result = mutableListOf<T>()
        while(rs.next()) {
            result.add(extractor.extract(rs))
        }
        return result
    }

    inline fun <reified T : Any> queryOne(sql: String): T? {
        val ps = connection.prepareStatement(sql)
        val rs = ps.executeQuery()

        val extractor = ExtractorFactory.get<T>()

        if (rs.next()) {
            return extractor.extract(rs)
        } else {
            return null
        }
    }

    fun execute(sql: String): Boolean {
        val ps = connection.prepareStatement(sql)
        val result = ps.execute()
        return result
    }

    fun createStatement(sql: String): PreparedStatement {
        throw NotImplementedError()
    }

}