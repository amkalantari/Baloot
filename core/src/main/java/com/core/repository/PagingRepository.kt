package com.core.repository

import com.core.api.PagingApi
import com.core.base.BaseObserver
import com.core.base.Response
import com.core.dto.GetProductListRequest
import com.core.dto.ResultDto
import com.core.dto.response.ProductItem

/**
 * Created by aMiir on 5/23/2021 AD
 * Drunk, Fix Later
 */

abstract class PagingRepository : BaseObserver {

    abstract suspend fun getAllProduct(
        productListRequest: GetProductListRequest
    ): Response<List<ProductItem>?>

}

class PagingRepositoryImpl(private val pagingApi: PagingApi) : PagingRepository() {

    override suspend fun getAllProduct(
        productListRequest: GetProductListRequest
    ): Response<List<ProductItem>?> {
        val tag = "getAllProduct"
        val response = pagingApi.getAllProduct(productListRequest)
        val tempResult = ResultDto<List<ProductItem>>()
        tempResult.data = response.data?.getAllProductItemVM_API.orEmpty()
        tempResult.code = response.code
        tempResult.message = response.message
        return handlerResult(tag, tempResult)
    }

}