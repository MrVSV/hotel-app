package com.vsv.feature_booking.presentation.booking.adapter

import android.content.ContentValues.TAG
import android.util.Log
import com.vsv.delegates.ListDelegateAdapter
import com.vsv.feature_booking.domain.model.Tourist
import com.vsv.feature_booking.presentation.TextField
import com.vsv.feature_booking.presentation.booking.adapter.delegates.touristDelegate
import com.vsv.feature_booking.presentation.booking.adapter.diff_util.TouristDiffUtil

class TouristAdapter(onTextChange: (TextField, Int) -> Unit): ListDelegateAdapter<Tourist>(TouristDiffUtil()) {

    init {
        addDelegate(touristDelegate(onTextChange))
    }
}