package com.rafaelvelazquez.data

import com.rafaelvelazquez.domain.ProductsModel
import io.reactivex.Single



interface SearchProductsRemoteDataSource {

    fun getAllProducts(searchString: String?, pageNumber: Int?) : Single<ProductsModel>

}

