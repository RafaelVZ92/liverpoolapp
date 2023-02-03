package com.rafaelvelazquez.liverpoolapp.action

import com.rafaelvelazquez.domain.ProductsModel

sealed class SearchProductsAction {
    data class ShowListProducts(val productsModel: ProductsModel): SearchProductsAction()
    data class ShowListProductsError(val error: Throwable): SearchProductsAction()
}