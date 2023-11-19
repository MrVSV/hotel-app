package com.vsv.feature_rooms.presentation.adapter.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.vsv.feature_rooms.domain.model.Room

class RoomDiffUtil: DiffUtil.ItemCallback<Room>() {
    override fun areItemsTheSame(oldItem: Room, newItem: Room): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Room, newItem: Room): Boolean {
        return oldItem == newItem
    }
}