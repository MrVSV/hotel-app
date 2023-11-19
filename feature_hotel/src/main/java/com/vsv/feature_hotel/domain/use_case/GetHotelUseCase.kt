package com.vsv.feature_hotel.domain.use_case

import com.vsv.feature_hotel.domain.model.Hotel

interface GetHotelUseCase {

    suspend operator fun invoke(): List<Hotel>
}