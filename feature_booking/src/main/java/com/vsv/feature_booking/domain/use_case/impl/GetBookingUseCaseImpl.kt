package com.vsv.feature_booking.domain.use_case.impl

import android.content.ContentValues.TAG
import android.util.Log
import com.vsv.feature_booking.domain.model.Booking
import com.vsv.feature_booking.domain.repository.BookingRepository
import com.vsv.feature_booking.domain.use_case.GetBookingUseCase

class GetBookingUseCaseImpl(
    private val repository: BookingRepository
): GetBookingUseCase {

    override suspend fun invoke(): Booking {
        return repository.getBooking()
    }
}