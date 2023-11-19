package com.vsv.core.utils

import android.icu.text.DecimalFormat

fun Int.decimal(): String {
    val f = DecimalFormat.getInstance()
    f.maximumFractionDigits = 3
    return f.format(this)
}