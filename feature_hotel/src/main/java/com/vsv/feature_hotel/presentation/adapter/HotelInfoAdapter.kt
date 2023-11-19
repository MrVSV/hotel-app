package com.vsv.feature_hotel.presentation.adapter

import com.vsv.delegates.ListDelegateAdapter
import com.vsv.feature_hotel.domain.model.Hotel
import com.vsv.feature_hotel.presentation.adapter.delegates.hotelInfoDelegate
import com.vsv.feature_hotel.presentation.adapter.diff_util.HotelDiffUtil

class HotelInfoAdapter: ListDelegateAdapter<Hotel>(HotelDiffUtil()){

    init {
        addDelegate(hotelInfoDelegate())
    }
}