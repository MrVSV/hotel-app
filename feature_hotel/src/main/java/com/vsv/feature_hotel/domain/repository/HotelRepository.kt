package com.vsv.feature_hotel.domain.repository

import com.vsv.feature_hotel.domain.model.Hotel

interface HotelRepository {

    suspend fun getHotel(): List<Hotel>
}