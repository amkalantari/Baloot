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
data class GetProductListRequest(
    @Keep var pageNumber: Int,
    @Keep var searchText: String?,
    @Keep var categoryIds: List<String>?,
    @Keep var minAmount: String?,
    @Keep var maxAmount: String?,
    @Keep var isAvailable: Boolean?,
    @Keep var sortType: String?,
) : Parcelable

fun GetProductListRequest.hasFilter(): Boolean {
    return this.isAvailable != null ||
            this.minAmount != null ||
            this.maxAmount != null ||
            !this.categoryIds.isNullOrEmpty()
}

fun GetProductListRequest.hasSort(): Boolean {
    return this.sortType != null
}

@Parcelize
@Keep
data class CreateProductRequest(
    @Keep var id: String?,
    @Keep var title: String,
    @Keep var price: String,
    @Keep var description: String,
    @Keep var qty: String,
    @Keep var categoryId: String,
    @Keep var files: List<String>?,
) : Parcelable

@Parcelize
@Keep
data class AvailableProductRequest(
    @Keep var id: String?,
    @Keep var isAvailable: Boolean
) : Parcelable

@Parcelize
@Keep
data class GetProductRequest(
    @Keep var id: String
) : Parcelable