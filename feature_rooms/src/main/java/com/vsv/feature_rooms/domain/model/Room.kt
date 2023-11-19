package com.vsv.feature_rooms.domain.model

import com.vsv.remote_api.api.dto.RoomListDto

data class Room(
    val id: Int,
    val name: String,
    val price: Int,
    val pricePer: String,
    val peculiarities: List<String>,
    val imageUrls: List<String>
)

fun RoomListDto.RoomDto.toRoom() = Room(
    id = id,
    name = name,
    price = price,
    pricePer = pricePer,
    peculiarities = peculiarities,
    imageUrls = imageUrls
)
