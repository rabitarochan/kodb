package com.github.rabitarochan.kotlimapper.extractor

import com.github.rabitarochan.kotlimapper.Session
import com.github.rabitarochan.kotlimapper.use
import org.junit.Test
import java.sql.Connection
import java.sql.DriverManager
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class Jsr310ExtractorTest() {

    @Test
    fun testLocalDate() {
        createConnection().use {
            val session = Session(it)

            session.execute("drop table test if exists")
            session.execute("""
                create table test (
                    id serial primary key,
                    col_localdate date not null,
                    col_localdatenull date null
                )
            """)

            for (i in 1..10) {
                session.update(
                        "insert into test values(?, ?, ?)",
                        arrayOf(
                                i,
                                LocalDate.of(2016, 1, i),
                                if (i % 2 == 0) null else LocalDate.of(2016, 1, i)
                        )
                )
            }

            session.query<LocalDate>("select col_localdate from test").let {
                assertEquals(10, it.size)
                assertEquals(LocalDate.of(2016, 1, 1), it.first())
                assertEquals(LocalDate.of(2016, 1, 10), it.last())
            }

            session.query<LocalDate?>("select col_localdatenull from test").let {
                assertEquals(10, it.size)
                assertEquals(5, it.filter { it == null }.size)
                assertEquals(LocalDate.of(2016, 1, 1), it.first())
                assertNull(it.last())
            }

        }
    }

    @Test
    fun testLocalTime() {
        createConnection().use {
            val session = Session(it)

            session.execute("drop table test if exists")
            session.execute("""
                create table test (
                    id serial primary key,
                    col_localtime time not null,
                    col_localtimenull time null
                )
            """)

            for (i in 1..10) {
                session.update(
                        "insert into test values(?, ?, ?)",
                        arrayOf(
                                i,
                                LocalTime.of(12, 34, i),
                                if (i % 2 == 0) null else LocalTime.of(12, 34, i)
                        )
                )
            }

            session.query<LocalTime>("select col_localtime from test").let {
                assertEquals(10, it.size)
                assertEquals(LocalTime.of(12, 34, 1), it.first())
                assertEquals(LocalTime.of(12, 34, 10), it.last())
            }

            session.query<LocalTime?>("select col_localtimenull from test").let {
                assertEquals(10, it.size)
                assertEquals(5, it.filter { it == null }.size)
                assertEquals(LocalTime.of(12, 34, 1), it.first())
                assertNull(it.last())
            }
        }
    }

    @Test
    fun testLocalDateTime() {
        createConnection().use {
            val session = Session(it)

            session.execute("drop table test if exists")
            session.execute("""
                create table test (
                    id serial primary key,
                    col_localdatetime timestamp not null,
                    col_localdatetimenull timestamp null
                )
            """)

            for (i in 1..10) {
                session.update(
                        "insert into test values(?, ?, ?)",
                        arrayOf(
                                i,
                                LocalDateTime.of(2016, 1, i, 12, 34, i, i),
                                if (i % 2 == 0) null else LocalDateTime.of(2016, 1, i, 12, 34, i, i)
                        )
                )
            }

            session.query<LocalDateTime>("select col_localdatetime from test").let {
                assertEquals(10, it.size)
                assertEquals(LocalDateTime.of(2016, 1, 1, 12, 34, 1, 1), it.first())
                assertEquals(LocalDateTime.of(2016, 1, 10, 12, 34, 10, 10), it.last())
            }

            session.query<LocalDateTime?>("select col_localdatetimenull from test").let {
                assertEquals(10, it.size)
                assertEquals(5, it.filter { it == null }.size)
                assertEquals(LocalDateTime.of(2016, 1, 1, 12, 34, 1, 1), it.first())
                assertNull(it.last())
            }
        }
    }

    fun createConnection(): Connection {
        return DriverManager.getConnection("jdbc:h2:mem:test", "u", "p")
    }

}
