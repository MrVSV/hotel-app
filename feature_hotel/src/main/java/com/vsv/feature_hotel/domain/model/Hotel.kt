package com.vsv.feature_hotel.domain.model

import com.vsv.remote_api.api.dto.HotelDto

data class Hotel(
    val id: Int,
    val name: String,
    val adress: String,
    val minimalPrice: Int,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String,
    val imageUrls: List<String>,
    val description: String,
    val peculiarities: List<String>
)

fun HotelDto.toHotel() = Hotel(
    id = id,
    name = name,
    adress = adress,
    minimalPrice = minimalPrice,
    priceForIt = priceForIt,
    rating = rating,
    ratingName = ratingName,
    imageUrls = imageUrls,
    description = aboutTheHotel.description,
    peculiarities = aboutTheHotel.peculiarities
)

