package com.github.rabitarochan.kotlimapper.extractor

import com.github.rabitarochan.kotlimapper.handler.TypeHandler
import com.github.rabitarochan.kotlimapper.util.toColumnName

class ExtractParameter(val name: String, val typeHandler: TypeHandler) {

    val columnName: String by lazy {
        toColumnName(name)
    }

}
