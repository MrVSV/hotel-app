package com.vsv.feature_rooms.presentation

import com.vsv.core.base.BaseViewModel
import com.vsv.core.wrapper.DispatcherWrapper
import com.vsv.feature_rooms.domain.use_case.GetRoomsUseCase
import com.vsv.feature_rooms.presentation.state.RoomsState

class RoomsViewModel(
    private val getRoomsUseCase: GetRoomsUseCase,
    private val dispatcherWrapper: DispatcherWrapper
) : BaseViewModel<RoomsState>(RoomsState()) {

    init {
        getRooms()
    }

    private fun getRooms() {
        scopeLaunch(context = dispatcherWrapper.io, onError = ::onError) {
            viewState = viewState.copy(isLoading = true, isError = false)
            viewState = viewState.copy(isLoading = false, rooms = getRoomsUseCase())
        }
    }

    private fun onError(e: Exception) {
        viewState = viewState.copy(isLoading = false, isError = true)
    }
}