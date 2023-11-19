package com.vsv.feature_rooms.domain.use_case

import com.vsv.feature_rooms.domain.model.Room

interface GetRoomsUseCase {

    suspend operator fun invoke(): List<Room>
}