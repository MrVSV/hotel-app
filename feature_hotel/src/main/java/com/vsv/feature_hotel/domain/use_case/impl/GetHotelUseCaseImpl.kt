package com.vsv.feature_hotel.domain.use_case.impl

import com.vsv.feature_hotel.domain.model.Hotel
import com.vsv.feature_hotel.domain.repository.HotelRepository
import com.vsv.feature_hotel.domain.use_case.GetHotelUseCase

class GetHotelUseCaseImpl(
    private val repository: HotelRepository
): GetHotelUseCase {

    override suspend fun invoke(): List<Hotel> {
        return repository.getHotel()
    }
}