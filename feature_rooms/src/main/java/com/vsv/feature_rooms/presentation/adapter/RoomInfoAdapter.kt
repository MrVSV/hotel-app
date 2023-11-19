package com.vsv.feature_rooms.presentation.adapter

import com.vsv.delegates.ListDelegateAdapter
import com.vsv.feature_rooms.domain.model.Room
import com.vsv.feature_rooms.presentation.adapter.delegates.roomInfoDelegate
import com.vsv.feature_rooms.presentation.adapter.diff_util.RoomDiffUtil

class RoomInfoAdapter(onClick:()-> Unit): ListDelegateAdapter<Room>(RoomDiffUtil()) {

    init {
        addDelegate(roomInfoDelegate(onClick))
    }
}