package com.rafaelvelazquez.liverpoolapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rafaelvelazquez.liverpoolapp.action.SearchProductsAction
import com.rafaelvelazquez.usescases.GetAllProductsUseCase
import javax.inject.Inject

class SearchProductsViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : AppBaseViewModel()  {

    private val _searchProductsAction = MutableLiveData<SearchProductsAction>()
    fun getSearchProductsAction(): LiveData<SearchProductsAction> = _searchProductsAction

    fun getAllProducts(searchString: String?, pageNumber: Int?) {
        disposable.add(
            getAllProductsUseCase.invoke(searchString, pageNumber)
                .doOnSubscribe { showProgress.value = true }
                .doFinally { showProgress.value = false }
                .subscribe(
                    {
                        _searchProductsAction.value = SearchProductsAction.ShowListProducts(it)
                    },
                    {
                        _searchProductsAction.value = SearchProductsAction.ShowListProductsError(it)
                    }
                )
        )
    }

}
