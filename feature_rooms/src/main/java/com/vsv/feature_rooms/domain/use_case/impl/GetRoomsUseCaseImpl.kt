package com.vsv.feature_rooms.domain.use_case.impl

import com.vsv.feature_rooms.domain.model.Room
import com.vsv.feature_rooms.domain.repository.RoomsRepository
import com.vsv.feature_rooms.domain.use_case.GetRoomsUseCase

class GetRoomsUseCaseImpl(
    private val repository: RoomsRepository
): GetRoomsUseCase {

    override suspend fun invoke(): List<Room> {
        return repository.getRooms()
    }
}