package com.vsv.core_ui.view_pager

import android.content.ContentValues.TAG
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.vsv.core_ui.databinding.ViewPagerLayoutBinding

class ViewPagerLayout
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    val binding = ViewPagerLayoutBinding.inflate(LayoutInflater.from(context))
    private val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

    init {
        addView(binding.root, params)
    }

    fun setupViewPager() {
        val mediator = TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }
        mediator.attach()

    }
}

