package com.vsv.feature_hotel.presentation.adapter.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.vsv.feature_hotel.domain.model.Hotel

class HotelDiffUtil: DiffUtil.ItemCallback<Hotel>() {

    override fun areItemsTheSame(oldItem: Hotel, newItem: Hotel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Hotel, newItem: Hotel): Boolean {
        return oldItem == newItem

    }
}