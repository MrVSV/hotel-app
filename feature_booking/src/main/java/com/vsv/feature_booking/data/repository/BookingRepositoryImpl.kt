package com.vsv.feature_booking.data.repository

import com.vsv.feature_booking.domain.model.Booking
import com.vsv.feature_booking.domain.model.toBooking
import com.vsv.feature_booking.domain.repository.BookingRepository
import com.vsv.remote_api.api.Api

class BookingRepositoryImpl(
    private val api: Api
): BookingRepository {

    override suspend fun getBooking(): Booking {
        return api.getBooking().toBooking()
    }
}