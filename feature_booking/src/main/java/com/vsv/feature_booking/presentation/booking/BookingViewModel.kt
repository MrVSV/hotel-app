package com.vsv.feature_booking.presentation.booking

import android.content.ContentValues.TAG
import android.util.Log
import com.vsv.core.base.BaseViewModel
import com.vsv.core.wrapper.DispatcherWrapper
import com.vsv.feature_booking.domain.model.Tourist
import com.vsv.feature_booking.domain.use_case.GetBookingUseCase
import com.vsv.feature_booking.presentation.TextField
import com.vsv.feature_booking.presentation.booking.state.BookingState

class BookingViewModel(
    private val getBookingUseCase: GetBookingUseCase,
    private val dispatcherWrapper: DispatcherWrapper,
) : BaseViewModel<BookingState>(BookingState()) {

    init {
        getBooking()
    }

    private fun getBooking() {
        scopeLaunch(context = dispatcherWrapper.io, onError = ::onError) {
            viewState = viewState.copy(isLoading = true, isError = false)
            val items = getBookingUseCase()
            viewState = viewState.copy(
                isLoading = false,
                booking = items,
            )
        }
    }

    fun addTourist() {
        val newTouristList = viewState.touristList.toMutableList()
        newTouristList.add(
            Tourist(
                id = viewState.touristList.last().id + 1,
                name = "",
                nameError = false,
                lastName = "",
                lastNameError = false,
                birthday = "",
                birthdayError = false,
                country = "",
                countryError = false,
                foreignPassportNumber = "",
                foreignPassportNumberError = false,
                foreignPassportDate = "",
                foreignPassportDateError = false,
                hasEmptyProperty = true,
            )
        )
        viewState = viewState.copy(
            touristList = newTouristList,
        )
    }

    private fun onError(e: Exception) {
        viewState = viewState.copy(isLoading = false, isError = true)
    }

    fun onTextChange(textField: TextField, touristIndex: Int) {
        scopeLaunch(context = dispatcherWrapper.io) {
            val newTouristList = viewState.touristList.toMutableList()
            var newTourist = newTouristList[touristIndex]
            when (textField) {
                TextField.NAME -> {
                    newTourist = newTourist.copy(name = textField.property)
                }
                TextField.LAST_NAME -> {
                    newTourist = newTourist.copy(lastName = textField.property)
                }
                TextField.BIRTHDAY -> {
                    newTourist = newTourist.copy(birthday = textField.property)
                }
                TextField.COUNTRY -> {
                    newTourist = newTourist.copy(country = textField.property)
                }
                TextField.FOREIGN_PASSPORT_NUMBER -> {
                    newTourist = newTourist.copy(foreignPassportNumber = textField.property)
                }
                TextField.FOREIGN_PASSPORT_DATE -> {
                    newTourist = newTourist.copy(foreignPassportDate = textField.property)
                }
            }
            newTouristList[touristIndex] = newTourist
            viewState = viewState.copy(
                touristList = newTouristList
            )
        }
    }

    fun checkEmptyFields() {
        scopeLaunch(context = dispatcherWrapper.io) {
            val newTouristList = viewState.touristList.toMutableList()
            viewState.touristList.forEachIndexed { index, tourist ->
                var newTourist = tourist
                newTourist = newTourist.copy(nameError = newTourist.name.isEmpty())
                newTourist = newTourist.copy(lastNameError = newTourist.lastName.isEmpty())
                newTourist = newTourist.copy(birthdayError = newTourist.birthday.isEmpty())
                newTourist = newTourist.copy(countryError = newTourist.country.isEmpty())
                newTourist = newTourist.copy(foreignPassportNumberError = newTourist.foreignPassportNumber.isEmpty())
                newTourist = newTourist.copy(foreignPassportDateError = newTourist.foreignPassportDate.isEmpty())
                newTouristList[index] = newTourist

            }
            viewState = viewState.copy(
                touristList = newTouristList
            )
        }
    }
}