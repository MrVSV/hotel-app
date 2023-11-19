package com.vsv.core_ui.utils

import androidx.annotation.ColorRes
import com.vsv.core_ui.R

sealed class TextInputBoxColor(@ColorRes open val color: Int) {
    data object Default : TextInputBoxColor(color = R.color.background)
    data object Error : TextInputBoxColor(color = R.color.error)
}

