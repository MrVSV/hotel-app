package com.vsv.feature_rooms.data.repository

import com.vsv.feature_rooms.domain.model.Room
import com.vsv.feature_rooms.domain.model.toRoom
import com.vsv.feature_rooms.domain.repository.RoomsRepository
import com.vsv.remote_api.api.Api

class RoomsRepositoryImpl(
    private val api: Api
): RoomsRepository {

    override suspend fun getRooms(): List<Room> {
        return api.getRooms().rooms.map { dto ->
            dto.toRoom()
        }
    }
}