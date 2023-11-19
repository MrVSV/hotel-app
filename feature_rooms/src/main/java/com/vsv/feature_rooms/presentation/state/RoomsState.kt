package com.vsv.feature_rooms.presentation.state

import com.vsv.feature_rooms.domain.model.Room

data class RoomsState(
    val rooms: List<Room> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)
