package com.core.dto

import androidx.annotation.Keep

@Keep
class ResultDto<T> {
    @Keep
    var code = 0

    @Keep
    var message: String? = null

    @Keep
    var data: T? = null
}