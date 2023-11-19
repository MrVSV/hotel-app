package com.vsv.feature_booking.domain.repository

import com.vsv.feature_booking.domain.model.Booking

interface BookingRepository {

    suspend fun getBooking(): Booking
}