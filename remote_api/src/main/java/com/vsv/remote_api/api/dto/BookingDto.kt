package com.vsv.remote_api.api.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookingDto(
    val id: Int,
    @Json(name = "hotel_name")
    val hotelName: String,
    @Json(name = "hotel_adress")
    val hotelAdress: String,
    val horating: Int,
    @Json(name = "rating_name")
    val ratingName: String,
    val departure: String,
    @Json(name = "arrival_country")
    val arrivalCountry: String,
    @Json(name = "tour_date_start")
    val tourDateStart: String,
    @Json(name = "tour_date_stop")
    val tourDateStop: String,
    @Json(name = "number_of_nights")
    val numberOfNights: Int,
    val room: String,
    val nutrition: String,
    @Json(name = "tour_price")
    val tourPrice: Int,
    @Json(name = "fuel_charge")
    val fuelCharge: Int,
    @Json(name = "service_charge")
    val serviceCharge: Int
)