package com.github.rabitarochan.kodb.extractor

import com.github.rabitarochan.kodb.Session
import com.github.rabitarochan.kodb.use
import org.junit.Test
import java.sql.Connection
import java.sql.DriverManager
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.test.assertEquals

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
                        "insert into test values(?, ?, null)",
                        arrayOf(
                                i,
                                LocalDate.of(2016, 1, i)
                        )
                )
            }

            val result = session.query<LocalDate>("select col_localdate from test")
            assertEquals(10, result.size)
            assertEquals(LocalDate.of(2016, 1, 1), result.first())
            assertEquals(LocalDate.of(2016, 1, 10), result.last())
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
                        "insert into test values(?, ?, null)",
                        arrayOf(
                                i,
                                LocalTime.of(12, 34, i)
                        )
                )
            }

            val result = session.query<LocalTime>("select col_localtime from test")
            assertEquals(10, result.size)
            assertEquals(LocalTime.of(12, 34, 1), result.first())
            assertEquals(LocalTime.of(12, 34, 10), result.last())
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
                        "insert into test values(?, ?, null)",
                        arrayOf(
                                i,
                                LocalDateTime.of(2016, 1, i, 12, 34, i, i)
                        )
                )
            }

            val result = session.query<LocalDateTime>("select col_localdatetime from test")
            assertEquals(10, result.size)
            assertEquals(LocalDateTime.of(2016, 1, 1, 12, 34, 1, 1), result.first())
            assertEquals(LocalDateTime.of(2016, 1, 10, 12, 34, 10, 10), result.last())
        }
    }

    fun createConnection(): Connection {
        return DriverManager.getConnection("jdbc:h2:mem:test", "u", "p")
    }

}
