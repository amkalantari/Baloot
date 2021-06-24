package com.core.dto

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

/**
 * Created by aMiir on 5/10/21
 * Drunk, Fix Later
 */

@Parcelize
@Keep
data class GetArticleListRequest(
    @Keep var page: Int,
    @Keep var pageSize: Int
) : Parcelable