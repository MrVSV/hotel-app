package com.vsv.feature_hotel.presentation

import com.vsv.core.base.BaseViewModel
import com.vsv.core.wrapper.DispatcherWrapper
import com.vsv.feature_hotel.domain.model.Hotel
import com.vsv.feature_hotel.domain.use_case.GetHotelUseCase
import com.vsv.feature_hotel.presentation.state.HotelState

class HotelViewModel(
    private val getHotelUseCase: GetHotelUseCase,
    private val dispatcherWrapper: DispatcherWrapper,
) : BaseViewModel<HotelState>(HotelState()) {


    init {
        getHotel()
    }

    private fun getHotel() {
        scopeLaunch(context = dispatcherWrapper.io, onError = ::onError) {
            viewState = viewState.copy(isLoading = true, isError = false)
            viewState = viewState.copy(isLoading = false, hotel = getHotelUseCase())
        }
    }


    private fun onError(e: Exception) {
        viewState = viewState.copy(isLoading = false, isError = true)
    }
}