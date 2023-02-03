package com.rafaelvelazquez.liverpoolapp.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelvelazquez.liverpoolapp.R
import com.rafaelvelazquez.liverpoolapp.databinding.ActivitySearchProductsBinding
import com.rafaelvelazquez.liverpoolapp.di.injector
import com.rafaelvelazquez.liverpoolapp.ui.base.BaseActivity
import com.rafaelvelazquez.liverpoolapp.utils.viewModel
import com.rafaelvelazquez.liverpoolapp.viewmodel.SearchProductsViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import androidx.lifecycle.Observer
import com.rafaelvelazquez.domain.ProductsModel
import com.rafaelvelazquez.liverpoolapp.action.SearchProductsAction
import com.rafaelvelazquez.liverpoolapp.ui.views.ItemGridProducts

class SearchProductsActivity : BaseActivity() {

    private val searchProductsViewModel: SearchProductsViewModel by viewModel {
        injector.searchProductsViewModel
    }

    private val binding by lazy {
        ActivitySearchProductsBinding.inflate(layoutInflater)
    }

    private val mAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = resources.getString(R.string.empty_string)
        searchProductsViewModel.getAllProducts(
            resources.getString(R.string.empty_string),
            1)
        setupRecyclerView()
        bindViewModel()
    }


    private fun setupRecyclerView() {
        binding.recyclerViewProducts.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }
    }

    private fun bindViewModel() {
        searchProductsViewModel.run {
            getSearchProductsAction().observe(this@SearchProductsActivity, Observer(::handleSearchProductsAction))
            getShowProgress().observe(this@SearchProductsActivity, Observer(this@SearchProductsActivity::showLoading))
            getShowError().observe(this@SearchProductsActivity, Observer(this@SearchProductsActivity::showError))
        }
    }

    private fun handleSearchProductsAction(searchProductsAction: SearchProductsAction) {
        when(searchProductsAction){
            is SearchProductsAction.ShowListProducts -> configureSuccessView(searchProductsAction.productsModel)
            is SearchProductsAction.ShowListProductsError -> configureErrorView()
        }
    }

    private fun configureSuccessView(productsModel: ProductsModel) {
        binding.apply {
            layoutSuccess.visibility = View.VISIBLE
            textError.visibility = View.GONE
        }
        configureRecyclerView(productsModel)
    }

    private fun configureRecyclerView(productsModel: ProductsModel) {
        productsModel.plpResults?.records?.map { record ->
            ItemGridProducts(
                mImageProduct = record.lgImage,
                mProductName = record.productDisplayName,
                mProductPrice = record.minimumListPrice.toString(),
                mProductDiscount = record.promoPrice.toString()
            )
        }?.let(mAdapter::update)
    }

    private fun configureErrorView() {
        binding.apply {
            layoutSuccess.visibility = View.GONE
            textError.visibility = View.VISIBLE
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        val search = menu?.findItem(R.id.nav_search)
        val searchView = search?.actionView as SearchView

        searchView.queryHint = "Search something"

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchProductsViewModel.getAllProducts(newText, 1)
                return true
            }

        })

        return super.onCreateOptionsMenu(menu)
    }
}