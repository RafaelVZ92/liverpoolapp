package com.rafaelvelazquez.usescases

import com.rafaelvelazquez.data.SearchProductsRepository
import com.rafaelvelazquez.domain.ProductsModel
import io.reactivex.Single


class GetAllProductsUseCase(
    private val characterRepository: SearchProductsRepository
) {

    fun invoke(searchString: String?, pageNumber: Int?): Single<ProductsModel>  =
        characterRepository.getAllProducts(searchString, pageNumber)
}