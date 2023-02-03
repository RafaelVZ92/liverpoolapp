package com.rafaelvelazquez.liverpoolapp.ui.base

import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.rafaelvelazquez.liverpoolapp.R
import com.rafaelvelazquez.liverpoolapp.ui.views.LoadingView

open class BaseActivity: AppCompatActivity() {

    private val loadingView by lazy { LoadingView(this) }

    private fun showProgressDialog(message: String) {
        loadingView.setMessage(message)
        if (loadingView.parent == null) {
            addContentView(
                loadingView,
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }
    }

    fun showError(message: String) {
        dismissProgressDialog()
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showLoading(show: Boolean) {
        if (show) showProgressDialog(
            R.string.progress_text
        ) else dismissProgressDialog()
    }
    private fun showProgressDialog(@StringRes idMessage: Int) =
        showProgressDialog(getString(idMessage))

    private fun dismissProgressDialog() = loadingView.removeFromParent()
}

fun View.removeFromParent() {
    this.parent?.let {
        (it as ViewGroup).removeView(this)
    }
}