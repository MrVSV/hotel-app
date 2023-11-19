package com.vsv.core_ui.utils

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.vsv.core_ui.R

fun ImageView.loadImage(item: Any?) {
    Glide.with(this)
        .load(item)
        .error(R.drawable.baseline_broken_image_24)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .placeholder(R.drawable.baseline_image_24)
        .into(this)
}