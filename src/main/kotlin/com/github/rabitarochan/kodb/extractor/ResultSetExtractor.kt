package com.github.rabitarochan.kodb.extractor

import java.sql.ResultSet

interface ResultSetExtractor<T: Any> {

    fun extract(rs: ResultSet): T

}
