package com.vsv.remote_api.api

import com.vsv.remote_api.api.dto.BookingDto
import com.vsv.remote_api.api.dto.HotelDto
import com.vsv.remote_api.api.dto.RoomListDto
import retrofit2.http.GET

interface Api {

    @GET(HOTEL)
    suspend fun getHotel(): HotelDto

    @GET(ROOMS)
    suspend fun getRooms(): RoomListDto

    @GET(BOOKING)
    suspend fun getBooking(): BookingDto

    companion object{
        const val HOTEL = "d144777c-a67f-4e35-867a-cacc3b827473"
        const val ROOMS = "8b532701-709e-4194-a41c-1a903af00195"
        const val BOOKING = "63866c74-d593-432c-af8e-f279d1a8d2ff"
    }
}