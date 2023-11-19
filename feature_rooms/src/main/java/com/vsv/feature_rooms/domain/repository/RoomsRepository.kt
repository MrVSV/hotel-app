package com.vsv.feature_rooms.domain.repository

import com.vsv.feature_rooms.domain.model.Room

interface RoomsRepository {

    suspend fun getRooms(): List<Room>
}