package com.rafaelvelazquez.requestmanager

import com.rafaelvelazquez.requestmanager.APIConstants.DEFAULT_PAGE
import com.rafaelvelazquez.requestmanager.APIConstants.SEARCH_DEFAULT
import com.rafaelvelazquez.requestmanager.data.api.ProductsResponse
import io.reactivex.Single
import retrofit2.http.*

interface RestServiceApi {

    @GET("plp")
    fun getAllProducts(
        @Query("search-string") searchString: String? = SEARCH_DEFAULT,
        @Query("page-number") pageNumber: Int? = DEFAULT_PAGE
    ): Single<ProductsResponse>

}