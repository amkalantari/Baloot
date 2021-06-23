package com.core.api

import com.core.dto.GetProductListRequest
import com.core.dto.ResultDto
import com.core.dto.response.ProductListResponse
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by aMiir on 5/24/2021 AD
 * Drunk, Fix Later
 */
interface PagingApi {

    @POST("mono/api/Product/GetAllProduct")
    suspend fun getAllProduct(@Body getProductListRequest: GetProductListRequest): ResultDto<ProductListResponse>

}