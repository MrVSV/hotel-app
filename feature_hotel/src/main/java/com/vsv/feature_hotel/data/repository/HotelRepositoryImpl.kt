package com.vsv.feature_hotel.data.repository

import com.vsv.feature_hotel.domain.model.Hotel
import com.vsv.feature_hotel.domain.model.toHotel
import com.vsv.feature_hotel.domain.repository.HotelRepository
import com.vsv.remote_api.api.Api

class HotelRepositoryImpl(
    private val api: Api
): HotelRepository {

    override suspend fun getHotel(): List<Hotel> {
        return listOf(api.getHotel().toHotel())
    }


}