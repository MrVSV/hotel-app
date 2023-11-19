package com.vsv.feature_booking.domain.use_case

import com.vsv.feature_booking.domain.model.Booking

interface GetBookingUseCase {

    suspend operator fun invoke(): Booking
}