package com.vsv.core

interface SetWindow {
    fun setUpTitle(title: String)
    fun setUpBottomButton(buttonText: String, isEnabled: Boolean, action: () -> Unit)
    fun setUpProgressBar(isVisible: Boolean = false)
}