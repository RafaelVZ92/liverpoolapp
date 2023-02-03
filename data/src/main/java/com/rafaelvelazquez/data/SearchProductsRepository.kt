package com.rafaelvelazquez.data


import com.rafaelvelazquez.domain.ProductsModel
import io.reactivex.Single
import dagger.Reusable
import javax.inject.Inject

@Reusable
class SearchProductsRepository  @Inject constructor(
    private val remoteDataSource: SearchProductsRemoteDataSource
) {

    fun getAllProducts(searchString: String?, pageNumber: Int?): Single<ProductsModel> =
        remoteDataSource.getAllProducts(searchString, pageNumber)
}
