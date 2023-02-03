package com.rafaelvelazquez.requestmanager

import com.rafaelvelazquez.data.SearchProductsRemoteDataSource
import com.rafaelvelazquez.domain.ProductsModel
import io.reactivex.Single
import com.rafaelvelazquez.requestmanager.data.mappers.ProductsModelMapper
import com.rafaelvelazquez.requestmanager.utils.applySchedulers
import dagger.Reusable
import javax.inject.Inject

@Reusable
class SearchProductsRetrofitDataSource @Inject constructor(
    private val restServiceApi: RestServiceApi,
    private val productsModelMapper: ProductsModelMapper
): SearchProductsRemoteDataSource {

    override fun getAllProducts(searchString: String?, pageNumber: Int?): Single<ProductsModel> {
        return restServiceApi.getAllProducts(searchString, pageNumber).map { products ->
            productsModelMapper.map(products)
        }.applySchedulers()
    }

}