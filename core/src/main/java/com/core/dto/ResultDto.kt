package com.core.dto

import androidx.annotation.Keep

@Keep
class ResultDto<T> {
    @Keep
    var status = ""

    @Keep
    var totalResults: String? = null

    @Keep
    var message: String? = null

    @Keep
    var articles: T? = null
}