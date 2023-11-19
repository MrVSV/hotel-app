package com.vsv.core.utils

import android.util.Patterns
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.annotation.ColorRes
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.setEmailValidationListener(
    @ColorRes onValidEmail: Int,
    @ColorRes onInvalidEmail: Int,
) {
    editText?.setOnFocusChangeListener { v, hasFocus ->
        if (!hasFocus) {
            setBoxBackgroundColorResource(
                if ((v as TextView).text.toString().isEmailValid()) onValidEmail
                else onInvalidEmail
            )
        }
    }
    editText?.setOnEditorActionListener { v, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            setBoxBackgroundColorResource(
                if (v.text.toString().isEmailValid()) onValidEmail
                else onInvalidEmail
            )
            v.clearFocus()
            return@setOnEditorActionListener false
        }
        return@setOnEditorActionListener false
    }
}

fun String.isEmailValid() =
    Patterns.EMAIL_ADDRESS.matcher(this).matches()