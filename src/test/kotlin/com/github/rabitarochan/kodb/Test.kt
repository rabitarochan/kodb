package com.github.rabitarochan.kodb

import org.junit.Test
import java.io.Closeable
import java.sql.Connection
import java.sql.DriverManager
import java.time.LocalDateTime
import kotlin.system.measureTimeMillis
import kotlin.test.assertEquals

import kotlin.io.use

class Test {

    fun createConnection(): Connection {
        return DriverManager.getConnection("jdbc:h2:mem:kodbtest", "user", "password")
    }

    data class Account(val id: Long, val name: String, val createdat: String)

    @Test
    fun test01() {
        println("test01")
        createConnection().use { conn ->
            val session = Session(conn)

            session.execute("drop table account if exists")

            session.execute("""
                create table account (
                    id serial primary key,
                    name varchar not null,
                    createdat timestamp not null
                )
            """)

            for (i in 1..10000) {
                session.execute("""
                    insert into account values (
                        ${i}, 'User${i}', '${LocalDateTime.now()}'
                    )
                """)
            }

            val times = mutableListOf<Long>()
            for (i in 1..100) {
                measureTimeMillis {
                    session.query<Account>("select * from account")
                }.let { times.add(it) }
            }
            //println(times)
            println("[time Min: ${times.min()}ms, Max: ${times.max()}, Average: ${times.average()}]")
        }
    }

    @Test
    fun test02() {
        println("test02")
        createConnection().use { conn ->
            val session = Session(conn)

            session.execute("drop table account if exists")

            session.execute("""
                create table account (
                    id serial primary key,
                    name varchar not null,
                    createdat timestamp not null
                )
            """)

            for (i in 1..10000) {
                session.execute("""
                    insert into account values (
                        ${i}, 'User${i}', '${LocalDateTime.now()}'
                    )
                """)
            }

            val times = mutableListOf<Long>()
            for (i in 1..100) {
                measureTimeMillis {
                    session.query<Account>("select * from account")
                }.let { times.add(it) }
            }
            //println(times)
            println("[time Min: ${times.min()}ms, Max: ${times.max()}, Average: ${times.average()}]")
        }
    }

    @Test
    fun testQueryOne() {
        println("testQueryOne")
        createConnection().use { conn ->
            val session = Session(conn)

            session.execute("drop table account if exists")

            session.execute("""
                create table account (
                    id serial primary key,
                    name varchar not null,
                    createdat timestamp not null
                )
            """)

            for (i in 1..10000) {
                session.execute("""
                    insert into account values (
                        ${i}, 'User${i}', '${LocalDateTime.now()}'
                    )
                """)
            }

            val times = mutableListOf<Long>()
            for (i in 1..100) {
                measureTimeMillis {
                    session.queryOne<Account>("select * from account")
                }.let { times.add(it) }
            }
            //println(times)
            println("[time Min: ${times.min()}ms, Max: ${times.max()}, Average: ${times.average()}]")
        }
    }

    @Test
    fun testQueryWithParameter() {
        println("testQueryWithParameter")
        createConnection().use { conn ->
            val session = Session(conn)

            session.execute("drop table account if exists")

            session.execute("""
                create table account (
                    id serial primary key,
                    name varchar not null,
                    createdat timestamp not null
                )
            """)

            for (i in 1..10000) {
                session.execute("""
                    insert into account values (
                        ${i}, 'User${i}', '${LocalDateTime.now()}'
                    )
                """)
            }

            val times = mutableListOf<Long>()
            for (i in 1..100) {
                measureTimeMillis {
                    val res = session.query<Account>("select * from account where id <= ?", arrayOf(100))
                    assertEquals(100, res.size)
                    assertEquals(1, res.first().id)
                }.let { times.add(it) }
            }
            //println(times)
            println("[time Min: ${times.min()}ms, Max: ${times.max()}, Average: ${times.average()}]")
        }
    }

    @Test
    fun testHandcode() {
        println("testHandcode")
        createConnection().use { conn ->
            val session = Session(conn)

            session.execute("drop table account if exists")

            session.execute("""
                create table account (
                    id serial primary key,
                    name varchar not null,
                    createdat timestamp not null
                )
            """)

            for (i in 1..10000) {
                session.execute("""
                    insert into account values (
                        ${i}, 'User${i}', '${LocalDateTime.now()}'
                    )
                """)
            }

            val times = mutableListOf<Long>()
            for (i in 1..100) {
                measureTimeMillis {
                    val stmt = conn.prepareStatement("select * from account")
                    val rs = stmt.executeQuery()

                    val res = mutableListOf<Account>()
                    while(rs.next()) {
                        val acc = Account(rs.getLong("id"), rs.getString("name"), rs.getString("createdat"))
                        res.add(acc)
                    }
                }.let { times.add(it) }
            }
            //println(times)
            println("[time Min: ${times.min()}ms, Max: ${times.max()}, Average: ${times.average()}]")
        }
    }

}

inline fun <T : AutoCloseable, R> T.use(block: (T) -> R): R {
    var closed = false
    try {
        return block(this)
    } catch (e: Exception) {
        closed = true
        try {
            close()
        } catch (closeException: Exception) {
            // eat the closeException as we are already throwing the original cause
            // and we don't want to mask the real exception

            // TODO on Java 7 we should call
            // e.addSuppressed(closeException)
            // to work like try-with-resources
            // http://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html#suppressed-exceptions
        }
        throw e
    } finally {
        if (!closed) {
            close()
        }
    }

}

inline fun <T : Closeable, R> T.use(block: (T) -> R): R {
    var closed = false
    try {
        return block(this)
    } catch (e: Exception) {
        closed = true
        try {
            close()
        } catch (closeException: Exception) {
            // eat the closeException as we are already throwing the original cause
            // and we don't want to mask the real exception

            // TODO on Java 7 we should call
            // e.addSuppressed(closeException)
            // to work like try-with-resources
            // http://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html#suppressed-exceptions
        }
        throw e
    } finally {
        if (!closed) {
            close()
        }
    }

}