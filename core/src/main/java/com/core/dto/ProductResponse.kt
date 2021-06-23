package com.core.dto.response

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

/**
 * Created by aMiir on 5/10/2021 AD
 * Drunk, Fix Later
 */
@Keep
data class StatusProductResponse(
    @Keep var status: Boolean
)

@Keep
data class CountProductResponse(
    @Keep var count: String,
    @Keep var userHasProduct: Boolean
)

@Keep
@Parcelize
data class ProductListResponse(
    @Keep var userHasProduct: Boolean,
    @Keep var getAllProductItemVM_API: List<ProductItem>
) : Parcelable

@Keep
@Parcelize
data class ProductItem(
    @Keep var id: String,
    @Keep var title: String,
    @Keep var price: String,
    @Keep var description: String,
    @Keep var tzCode: String,
    @Keep var imageUrl: String,
    @Keep var isAvailable: Boolean,
    @Keep var categoryTitle: String,
) : Parcelable

@Keep
@Parcelize
data class ProductDetail(
    @Keep var id: String = "",
    @Keep var tzCode: String = "",
    @Keep var title: String = "",
    @Keep var price: String = "",
    @Keep var amount: String = "",
    @Keep var description: String = "",
    @Keep var businessTitle: String = "",
    @Keep var categoryTitle: String = "",
    @Keep var categoryId: String = "",
    @Keep var categoryChain: List<String> = mutableListOf(),
    @Keep var qty: String = "",
    @Keep var productImagesUrl: MutableList<String> = mutableListOf(),
    var removingFiles: List<String> = listOf(),
    @Keep var isAvailable: Boolean = false,
) : Parcelable

@Keep
@Parcelize
data class FilterInfo(
    @Keep var minValue: String,
    @Keep var maxValue: String,
    @Keep var sortType: List<SortType>,
    @Keep var categories: List<CategoryType>,
) : Parcelable

@Keep
@Parcelize
data class SortType(
    @Keep var key: String,
    @Keep var title: String,
) : Parcelable

@Keep
@Parcelize
data class CategoryType(
    @Keep var key: String,
    @Keep var title: String,
) : Parcelable