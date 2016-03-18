package com.github.rabitarochan.kodb.extractor

import com.github.rabitarochan.kodb.Session
import com.github.rabitarochan.kodb.use
import org.junit.Test
import java.sql.Connection
import java.sql.DriverManager
import java.time.LocalDateTime
import kotlin.test.assertEquals

class DataClassExtractorTest {

    data class Account(
            val id: Long,
            val name: String,
            val description: String?,
            val createdAt: LocalDateTime)

    @Test
    fun test() {
        createConnection().use {
            val session = Session(it)

            session.execute("drop table account if exists")
            session.execute("""
                create table account (
                  id serial primary key,
                  name varchar not null,
                  description varchar null,
                  created_at timestamp not null
                )
            """)

            for (i in 1..10) {
                session.update(
                        "insert into account values(?, ?, ?, ?)",
                        arrayOf(
                                i,
                                "User-${i}",
                                if (i % 2 == 0) null else "Description-${i}",
                                LocalDateTime.of(2016, 1, i, 12, 34, i)
                        )
                )
            }

            // test
            val accounts = session.query<Account>("select * from account")
            assertEquals(10, accounts.size)
        }
    }

    // private

    private fun createConnection(): Connection {
        return DriverManager.getConnection("jdbc:h2:mem:kodb", "u", "p")
    }

}
