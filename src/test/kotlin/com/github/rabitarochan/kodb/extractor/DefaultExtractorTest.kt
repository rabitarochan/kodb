package com.github.rabitarochan.kodb.extractor

import com.github.rabitarochan.kodb.Session
import com.github.rabitarochan.kodb.use
import org.junit.Test
import java.math.BigDecimal
import java.sql.Connection
import java.sql.DriverManager
import java.util.*
import kotlin.test.assertEquals

class DefaultExtractorTest {

    @Test
    fun intExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val xs = session.query<Int>("select col_int from test")

            assertEquals(10, xs.size)
            assertEquals(1, xs.first())
            assertEquals(10, xs.last())
        }
    }

    @Test
    fun shortExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val xs = session.query<Short>("select col_short from test")

            assertEquals(10, xs.size)
            assertEquals(1, xs.first())
            assertEquals(10, xs.last())
        }
    }

    @Test
    fun longExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val longs = session.query<Long>("select col_long from test")

            assertEquals(10, longs.size)
            assertEquals(1000000000001L, longs.first())
            assertEquals(1000000000010L, longs.last())
        }

    }

    @Test
    fun bigdecimalExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val bigDecimals = session.query<BigDecimal>("select col_bigdecimal from test")

            assertEquals(10, bigDecimals.size)
            assertEquals(BigDecimal("10000000000000000001.12"), bigDecimals.first())
            assertEquals(BigDecimal("10000000000000000010.12"), bigDecimals.last())
        }
    }

    @Test
    fun doubleExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val xs = session.query<Double>("select col_double from test")

            assertEquals(10, xs.size)
            assertEquals(101.123, xs.first())
            assertEquals(110.123, xs.last())
        }

    }

    @Test
    fun floatExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val xs = session.query<Float>("select col_float from test")

            assertEquals(10, xs.size)
            assertEquals(101.123F, xs.first())
            assertEquals(110.123F, xs.last())
        }

    }

    @Test
    fun byteExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val bytes = session.query<Byte>("select col_byte from test")

            assertEquals(10, bytes.size)
            assertEquals(1.toByte(), bytes.first())
            assertEquals(10.toByte(), bytes.last())
        }
    }

    @Test
    fun bytesExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val bytes = session.query<Array<Byte>>("select col_bytes from test")

            assertEquals(10, bytes.size)

            val first = bytes.first()
            assertEquals(4, first.size)
            assertEquals(1, first[0])
            assertEquals(1, first[3])

            val last = bytes.last()
            assertEquals(4, last.size)
            assertEquals(10, last[0])
            assertEquals(10, last[3])
        }
    }

    @Test
    fun byteArrayExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val bytes = session.query<ByteArray>("select col_bytes from test")

            assertEquals(10, bytes.size)

            val first = bytes.first()
            assertEquals(4, first.size)
            assertEquals(1, first[0])
            assertEquals(1, first[3])

            val last = bytes.last()
            assertEquals(4, last.size)
            assertEquals(10, last[0])
            assertEquals(10, last[3])
        }
    }

    @Test
    fun stringExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val strings = session.query<String>("select col_string from test")

            assertEquals(10, strings.size)
            assertEquals("Title1", strings.first())
            assertEquals("Title10", strings.last())
        }

    }

    @Test
    fun booleanExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val booleans = session.query<Boolean>("select col_boolean from test")

            assertEquals(10, booleans.size)
            assertEquals(false, booleans.first())
            assertEquals(true, booleans.last())
        }
    }

    @Test
    fun sqlDateExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val xs = session.query<java.sql.Date>("select col_date from test")

            assertEquals(10, xs.size)
            assertEquals(dateOf(1970, 1, 1, 0, 0, 0, 0).time, xs.first().time)
            assertEquals(dateOf(1970, 1, 10, 0, 0, 0, 0).time, xs.last().time)
        }
    }

    @Test
    fun sqlTimeExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val xs = session.query<java.sql.Time>("select col_time from test")

            assertEquals(10, xs.size)
            assertEquals(dateOf(1970, 1, 1, 12, 34, 1, 0).time, xs.first().time)
            assertEquals(dateOf(1970, 1, 1, 12, 34, 10, 0).time, xs.last().time)
        }

    }

    @Test
    fun sqlTimestampExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val xs = session.query<java.sql.Timestamp>("select col_timestamp from test")

            assertEquals(10, xs.size)
            assertEquals(sqlTimestampOf(1970, 1, 1, 12, 34, 1, 1).time, xs.first().time)
            assertEquals(sqlTimestampOf(1970, 1, 10, 12, 34, 10, 10).time, xs.last().time)
        }

    }

    @Test
    fun dateExtractor() {
        createConnection().use { conn ->
            val session = Session(conn)

            init(conn)

            val xs = session.query<java.util.Date>("select col_timestamp from test")

            assertEquals(10, xs.size)
            assertEquals(dateOf(1970, 1, 1, 12, 34, 1, 1).time, xs.first().time)
            assertEquals(dateOf(1970, 1, 10, 12, 34, 10, 10).time, xs.last().time)
        }

    }


    private fun createConnection(): Connection {
        return DriverManager.getConnection("jdbc:h2:mem:kodb", "u", "p")
    }

    private fun init(conn: Connection) {
        val session = Session(conn)

        session.execute("drop table todo if exists")

        session.execute("""
            create table test (
              col_int int not null,
              col_short smallint not null,
              col_long bigint not null,
              col_bigdecimal decimal(22, 2) not null,
              col_double double not null,
              col_float real not null,
              col_byte tinyint not null,
              col_bytes binary(4) not null,
              col_string varchar not null,
              col_boolean boolean not null,
              col_date date not null,
              col_time time not null,
              col_timestamp timestamp not null
            )
        """)

        for (i in 1..10) {
            session.execute(
                    "insert into test values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    arrayOf(
                            i,
                            i,
                            1000000000000 + i,
                            BigDecimal("10000000000000000000.12") + BigDecimal(i),
                            100.123 + i,
                            100.123F + i,
                            i.toByte(),
                            i.toByte().let { byteArrayOf(it, it, it, it) },
                            "Title$i",
                            (i % 2 == 0),
                            sqlDateOf(1970, 1, i),
                            sqlTimeOf(12, 34, i),
                            sqlTimestampOf(1970, 1, i, 12, 34, i, i)
                    )
            )
        }
    }

    private fun sqlDateOf(year: Int, month: Int, date: Int): java.sql.Date {
        dateOf(year, month, date, 0, 0, 0, 0).let {
            return java.sql.Date(it.time)
        }
    }

    private fun sqlTimeOf(hour: Int, minute: Int, second: Int): java.sql.Time {
        dateOf(1970, Calendar.JANUARY, 1, hour, minute, second, 0).let {
            return java.sql.Time(it.time)
        }
    }

    private fun sqlTimestampOf(year: Int, month: Int, date: Int, hour: Int, minute: Int, second: Int, milliSecond: Int): java.sql.Timestamp {
        dateOf(year, month, date, hour, minute, second, milliSecond).let {
            return java.sql.Timestamp(it.time)
        }
    }

    private fun dateOf(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int, milliSecond: Int = 0): java.util.Date {
        Calendar.getInstance().let {
            it.time = java.util.Date()
            it.set(Calendar.YEAR, year)
            it.set(Calendar.MONTH, month - 1)
            it.set(Calendar.DATE, day)
            it.set(Calendar.HOUR_OF_DAY, hour)
            it.set(Calendar.MINUTE, minute)
            it.set(Calendar.SECOND, second)
            it.set(Calendar.MILLISECOND, milliSecond)
            return it.time
        }
    }

}