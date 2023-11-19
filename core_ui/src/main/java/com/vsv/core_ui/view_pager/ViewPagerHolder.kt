package com.vsv.core_ui.view_pager

import android.content.ContentValues.TAG
import android.util.Log
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.vsv.core_ui.databinding.ViewPagerItemBinding
import com.vsv.core_ui.utils.loadImage

class ViewPagerHolder(
    private val binding: ViewPagerItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(imageUrl: String){
        binding.image.loadImage(imageUrl)
    }
}