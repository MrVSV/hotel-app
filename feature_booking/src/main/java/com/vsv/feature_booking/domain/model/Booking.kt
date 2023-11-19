package com.vsv.feature_booking.domain.model

import android.content.ContentValues.TAG
import android.util.Log
import com.vsv.remote_api.api.dto.BookingDto

data class Booking(
    val id: Int,
    val hotelName: String,
    val hotelAdress: String,
    val horating: Int,
    val ratingName: String,
    val departure: String,
    val arrivalCountry: String,
    val tourDateStart: String,
    val tourDateStop: String,
    val numberOfNights: Int,
    val room: String,
    val nutrition: String,
    val tourPrice: Int,
    val fuelCharge: Int,
    val serviceCharge: Int,
    var totalPrice: Int = 0
){
    init {
        totalPrice = tourPrice + fuelCharge + serviceCharge
    }
}

fun BookingDto.toBooking() = Booking(
    id = id,
    hotelName = hotelName,
    hotelAdress = hotelAdress,
    horating = horating,
    ratingName = ratingName,
    departure = departure,
    arrivalCountry = arrivalCountry,
    tourDateStart = tourDateStart,
    tourDateStop = tourDateStop,
    numberOfNights = numberOfNights,
    room = room,
    nutrition = nutrition,
    tourPrice = tourPrice,
    fuelCharge = fuelCharge,
    serviceCharge = serviceCharge,
)
