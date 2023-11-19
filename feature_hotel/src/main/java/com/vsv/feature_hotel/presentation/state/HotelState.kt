package com.vsv.feature_hotel.presentation.state

import com.vsv.feature_hotel.domain.model.Hotel

data class HotelState(
    val hotel: List<Hotel> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false

    )
