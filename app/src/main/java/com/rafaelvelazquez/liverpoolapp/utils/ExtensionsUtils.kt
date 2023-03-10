package com.rafaelvelazquez.liverpoolapp.utils

import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.annotation.LayoutRes


fun Editable.passwordValidation(): String? {
    if (this.length < 6) {
        return "Minimum 6 Character Password"
    }
    if (!this.matches(".*[A-Z].*".toRegex())) {
        return "Must Contain 1 Upper-case Character"
    }
    if (!this.matches(".*[a-z].*".toRegex())) {
        return "Must Contain 1 Lower-case Character"
    }
    return null
}

fun Editable.emailValidation(): String? {
    if (!Patterns.EMAIL_ADDRESS.matcher(this).matches()) {
        return "Invalid Email Address"
    }
    return null
}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}
