package com.vsv.feature_booking.presentation.booking.state

import com.vsv.feature_booking.domain.model.Booking
import com.vsv.feature_booking.domain.model.Tourist

data class BookingState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val booking: Booking? = null,
    val touristList: List<Tourist> = listOf(Tourist()),
) {
}
