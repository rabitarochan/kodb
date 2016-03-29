package com.github.rabitarochan.kotlimapper.extractor

import com.github.rabitarochan.kotlimapper.Session
import com.github.rabitarochan.kotlimapper.use
import org.junit.Test
import java.sql.Connection
import java.sql.DriverManager
import kotlin.test.assertEquals

class NullableExtractorTest {

    @Test
    fun nullableStringTest() {
        data class NullableString(val id: Long, val col_string: String, val col_nstring: String?)

        createConnection().use {
            val session = Session(it)

            session.execute("drop table test if exists")
            session.execute("""
                create table test (
                    id serial not null,
                    col_string varchar not null,
                    col_nstring varchar null
                )
            """)

            for (i in 1..10) {
                session.update("insert into test values (?, ?, null)", arrayOf(i, "col$i"))
            }

            val xs = session.query<NullableString>("select * from test")
            assertEquals(10, xs.size)
        }
    }

    private fun createConnection(): Connection {
        return DriverManager.getConnection("jdbc:h2:mem:kotlimapper", "u", "p")
    }

}
