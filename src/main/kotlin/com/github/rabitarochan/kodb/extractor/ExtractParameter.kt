package com.github.rabitarochan.kodb.extractor

import com.github.rabitarochan.kodb.handler.TypeHandler
import com.github.rabitarochan.kodb.util.toColumnName

class ExtractParameter(val name: String, val typeHandler: TypeHandler) {

    val columnName: String by lazy {
        toColumnName(name)
    }

}
