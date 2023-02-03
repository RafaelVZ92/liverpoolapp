package com.rafaelvelazquez.liverpoolapp.di

import com.rafaelvelazquez.liverpoolapp.viewmodel.SearchProductsViewModel

interface ViewModelProvider: MainViewModels

interface MainViewModels {
    val searchProductsViewModel: SearchProductsViewModel
}