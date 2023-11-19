package com.vsv.remote_api.api.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HotelDto(
    val id: Int,
    val name: String,
    val adress: String,
    @Json(name = "minimal_price")
    val minimalPrice: Int,
    @Json(name = "price_for_it")
    val priceForIt: String,
    val rating: Int,
    @Json(name = "rating_name")
    val ratingName: String,
    @Json(name = "image_urls")
    val imageUrls: List<String>,
    @Json(name = "about_the_hotel")
    val aboutTheHotel: AboutTheHotel
) {
    @JsonClass(generateAdapter = true)
    data class AboutTheHotel(
        val description: String,
        val peculiarities: List<String>
    )
}