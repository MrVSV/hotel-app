package com.vsv.remote_api.api.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RoomListDto(
    val rooms: List<RoomDto>
) {
    @JsonClass(generateAdapter = true)
    data class RoomDto(
        val id: Int,
        val name: String,
        val price: Int,
        @Json(name = "price_per")
        val pricePer: String,
        val peculiarities: List<String>,
        @Json(name = "image_urls")
        val imageUrls: List<String>
    )
}