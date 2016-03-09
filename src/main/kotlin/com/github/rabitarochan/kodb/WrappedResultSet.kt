package com.github.rabitarochan.kodb

import java.sql.ResultSet
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1

/**
 * Wrapper of [ResultSet]
 *
 * @property resultSet ResultSet
 */
class WrappedResultSet(val resultSet: ResultSet) {

    fun next(): Boolean = resultSet.next()

    fun metadata(): java.sql.ResultSetMetaData = resultSet.metaData


    fun array(columnIndex: Int): java.sql.Array? = wasNullOf(resultSet.getArray(columnIndex))

    fun array(columnName: String): java.sql.Array? = wasNullOf(resultSet.getArray(columnName))

    fun array(prop: KProperty1<*, *>): java.sql.Array? = array(prop.name)

    fun asciiStream(columnIndex: Int): java.io.InputStream? = wasNullOf(resultSet.getAsciiStream(columnIndex))

    fun asciiStream(columnName: String): java.io.InputStream? = wasNullOf(resultSet.getAsciiStream(columnName))

    fun asciiStream(prop: KProperty1<*, *>): java.io.InputStream? = asciiStream(prop.name)

    fun bigDecimal(columnIndex: Int): java.math.BigDecimal? = wasNullOf(resultSet.getBigDecimal(columnIndex))

    fun bigDecimal(columnName: String): java.math.BigDecimal? = wasNullOf(resultSet.getBigDecimal(columnName))

    fun bigDecimal(prop: KProperty1<*, *>): java.math.BigDecimal? = bigDecimal(prop.name)

    fun binaryStream(columnIndex: Int): java.io.InputStream? = wasNullOf(resultSet.getBinaryStream(columnIndex))

    fun binaryStream(columnName: String): java.io.InputStream? = wasNullOf(resultSet.getBinaryStream(columnName))

    fun binaryStream(prop: KProperty1<*, *>): java.io.InputStream? = binaryStream(prop.name)

    fun blob(columnIndex: Int): java.sql.Blob? = wasNullOf(resultSet.getBlob(columnIndex))

    fun blob(columnName: String): java.sql.Blob? = wasNullOf(resultSet.getBlob(columnName))

    fun blob(prop: KProperty1<*, *>): java.sql.Blob? = blob(prop.name)

    fun byte(columnIndex: Int): Byte? = wasNullOf(resultSet.getByte(columnIndex))

    fun byte(columnName: String): Byte? = wasNullOf(resultSet.getByte(columnName))

    fun byte(prop: KProperty1<*, *>): Byte? = byte(prop.name)

    fun bytes(columnIndex: Int): ByteArray? = wasNullOf(resultSet.getBytes(columnIndex))

    fun bytes(columnName: String): ByteArray? = wasNullOf(resultSet.getBytes(columnName))

    fun bytes(prop: KProperty1<*, *>): ByteArray? = bytes(prop.name)

    fun characterStream(columnIndex: Int): java.io.Reader? = wasNullOf(resultSet.getCharacterStream(columnIndex))

    fun characterStream(columnName: String): java.io.Reader? = wasNullOf(resultSet.getCharacterStream(columnName))

    fun characterStream(prop: KProperty1<*, *>): java.io.Reader? = characterStream(prop.name)

    fun clob(columnIndex: Int): java.sql.Clob? = wasNullOf(resultSet.getClob(columnIndex))

    fun clob(columnName: String): java.sql.Clob? = wasNullOf(resultSet.getClob(columnName))

    fun clob(prop: KProperty1<*, *>): java.sql.Clob? = clob(prop.name)

    fun double(columnIndex: Int): Double? = wasNullOf(resultSet.getDouble(columnIndex))

    fun double(columnName: String): Double? = wasNullOf(resultSet.getDouble(columnName))

    fun double(prop: KProperty1<*, *>): Double? = double(prop.name)

    fun float(columnIndex: Int): Float? = wasNullOf(resultSet.getFloat(columnIndex))

    fun float(columnName: String): Float? = wasNullOf(resultSet.getFloat(columnName))

    fun float(prop: KProperty1<*, *>): Float? = float(prop.name)

    fun int(columnIndex: Int): Int? = wasNullOf(resultSet.getInt(columnIndex))

    fun int(columnName: String): Int? = wasNullOf(resultSet.getInt(columnName))

    fun int(prop: KProperty1<*, *>): Int? = int(prop.name)

    fun long(columnIndex: Int): Long? = wasNullOf(resultSet.getLong(columnIndex))

    fun long(columnName: String): Long? = wasNullOf(resultSet.getLong(columnName))

    fun long(prop: KProperty1<*, *>): Long? = long(prop.name)

    fun nCharacterStream(columnIndex: Int): java.io.Reader? = wasNullOf(resultSet.getNCharacterStream(columnIndex))

    fun nCharacterStream(columnName: String): java.io.Reader? = wasNullOf(resultSet.getNCharacterStream(columnName))

    fun nCharacterStream(prop: KProperty1<*, *>): java.io.Reader? = nCharacterStream(prop.name)

    fun nClob(columnIndex: Int): java.sql.Clob? = wasNullOf(resultSet.getNClob(columnIndex))

    fun nClob(columnName: String): java.sql.Clob? = wasNullOf(resultSet.getNClob(columnName))

    fun nClob(prop: KProperty1<*, *>): java.sql.Clob? = nClob(prop.name)

    fun nString(columnIndex: Int): String? = wasNullOf(resultSet.getNString(columnIndex))

    fun nString(columnName: String): String? = wasNullOf(resultSet.getNString(columnName))

    fun nString(prop: KProperty1<*, *>): String? = nString(prop.name)

    fun any(columnIndex: Int): Any? = wasNullOf(resultSet.getObject(columnIndex))

    fun any(columnName: String): Any? = wasNullOf(resultSet.getObject(columnName))

    fun any(prop: KProperty1<*, *>): Any? = any(prop.name)

    fun <T: Any> any(columnIndex: Int, kClass: KClass<T>): Any? = wasNullOf(resultSet.getObject(columnIndex, kClass.java))

    fun <T: Any> any(columnName: String, kClass: KClass<T>): Any? = wasNullOf(resultSet.getObject(columnName, kClass.java))

    fun <T: Any> any(prop: KProperty1<*, *>, kClass: KClass<T>): Any? = any(prop.name, kClass)

    fun ref(columnIndex: Int): java.sql.Ref? = wasNullOf(resultSet.getRef(columnIndex))

    fun ref(columnName: String): java.sql.Ref? = wasNullOf(resultSet.getRef(columnName))

    fun ref(prop: KProperty1<*, *>): java.sql.Ref? = ref(prop.name)

    fun rowId(columnIndex: Int): java.sql.RowId? = wasNullOf(resultSet.getRowId(columnIndex))

    fun rowId(columnName: String): java.sql.RowId? = wasNullOf(resultSet.getRowId(columnName))

    fun rowId(prop: KProperty1<*, *>): java.sql.RowId? = rowId(prop.name)

    fun short(columnIndex: Int): Short? = wasNullOf(resultSet.getShort(columnIndex))

    fun short(columnName: String): Short? = wasNullOf(resultSet.getShort(columnName))

    fun short(prop: KProperty1<*, *>): Short? = short(prop.name)

    fun sqlXml(columnIndex: Int): java.sql.SQLXML? = wasNullOf(resultSet.getSQLXML(columnIndex))

    fun sqlXml(columnName: String): java.sql.SQLXML? = wasNullOf(resultSet.getSQLXML(columnName))

    fun sqlXml(prop: KProperty1<*, *>): java.sql.SQLXML? = sqlXml(prop.name)

    fun string(columnIndex: Int): String? = wasNullOf(resultSet.getString(columnIndex))

    fun string(columnName: String): String? = wasNullOf(resultSet.getString(columnName))

    fun string(prop: KProperty1<*, *>): String? = string(prop.name)

    fun url(columnIndex: Int): java.net.URL? = wasNullOf(resultSet.getURL(columnIndex))

    fun url(columnName: String): java.net.URL? = wasNullOf(resultSet.getURL(columnName))

    fun url(prop: KProperty1<*, *>): java.net.URL? = url(prop.name)

    fun sqlDate(columnIndex: Int): java.sql.Date? = wasNullOf(resultSet.getDate(columnIndex))

    fun sqlDate(columnIndex: Int, cal: Calendar): java.sql.Date? = wasNullOf(resultSet.getDate(columnIndex, cal))

    fun sqlDate(columnName: String): java.sql.Date? = wasNullOf(resultSet.getDate(columnName))

    fun sqlDate(columnName: String, cal:Calendar): java.sql.Date? = wasNullOf(resultSet.getDate(columnName, cal))

    fun sqlDate(prop: KProperty1<*, *>): java.sql.Date? = sqlDate(prop.name)

    fun sqlDate(prop: KProperty1<*, *>, cal: Calendar): java.sql.Date? = sqlDate(prop.name, cal)

    fun sqlTime(columnIndex: Int): java.sql.Time? = wasNullOf(resultSet.getTime(columnIndex))

    fun sqlTime(columnIndex: Int, cal: Calendar): java.sql.Time? = wasNullOf(resultSet.getTime(columnIndex, cal))

    fun sqlTime(columnName: String): java.sql.Time? = wasNullOf(resultSet.getTime(columnName))

    fun sqlTime(columnName: String, cal: Calendar): java.sql.Time? = wasNullOf(resultSet.getTime(columnName, cal))

    fun sqlTime(prop: KProperty1<*, *>): java.sql.Time? = sqlTime(prop.name)

    fun sqlTime(prop: KProperty1<*, *>, cal: Calendar): java.sql.Time? = sqlTime(prop.name, cal)

    fun sqlTimestamp(columnIndex: Int): java.sql.Timestamp? = wasNullOf(resultSet.getTimestamp(columnIndex))

    fun sqlTimestamp(columnIndex: Int, cal: Calendar): java.sql.Timestamp? = wasNullOf(resultSet.getTimestamp(columnIndex, cal))

    fun sqlTimestamp(columnName: String): java.sql.Timestamp? = wasNullOf(resultSet.getTimestamp(columnName))

    fun sqlTimestamp(columnName: String, cal: Calendar): java.sql.Timestamp? = wasNullOf(resultSet.getTimestamp(columnName, cal))

    fun sqlTimestamp(prop: KProperty1<*, *>): java.sql.Timestamp? = sqlTimestamp(prop.name)

    fun sqlTimestamp(prop: KProperty1<*, *>, cal: Calendar): java.sql.Timestamp? = sqlTimestamp(prop.name, cal)

    fun localDate(columnIndex: Int): java.time.LocalDate? = sqlDate(columnIndex)?.toLocalDate()

    fun localDate(columnName: String): java.time.LocalDate? = sqlDate(columnName)?.toLocalDate()

    fun localDate(prop: KProperty1<*, *>): java.time.LocalDate? = sqlDate(prop)?.toLocalDate()

    fun localTime(columnIndex: Int): java.time.LocalTime? = sqlTime(columnIndex)?.toLocalTime()

    fun localTime(columnName: String): java.time.LocalTime? = sqlTime(columnName)?.toLocalTime()

    fun localTime(prop: KProperty1<*, *>): java.time.LocalTime? = sqlTime(prop)?.toLocalTime()

    fun localDateTime(columnIndex: Int): java.time.LocalDateTime? = sqlTimestamp(columnIndex)?.toLocalDateTime()

    fun localDateTime(columnName: String): java.time.LocalDateTime? = sqlTimestamp(columnName)?.toLocalDateTime()

    fun localDateTime(prop: KProperty1<*, *>): java.time.LocalDateTime? = sqlTimestamp(prop)?.toLocalDateTime()

    private fun <T> wasNullOf(value: T?): T? {
        if (resultSet.wasNull()) {
            return null
        } else {
            return value
        }
    }

}
