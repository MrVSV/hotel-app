package com.vsv.feature_booking.domain.model

data class Tourist(
    val id: Int = 1,
    val name: String = "",
    val nameError: Boolean = false,
    val lastName: String = "",
    val lastNameError: Boolean = false,
    val birthday: String = "",
    val birthdayError: Boolean = false,
    val country: String = "",
    val countryError: Boolean = false,
    val foreignPassportNumber: String = "",
    val foreignPassportNumberError: Boolean = false,
    val foreignPassportDate: String = "",
    val foreignPassportDateError: Boolean = false,
    var hasEmptyProperty: Boolean = true,
) {
    init {
        hasEmptyProperty = listOf(
            name,
            lastName,
            birthday,
            country,
            foreignPassportNumber,
            foreignPassportDate
        ).contains("")
    }
}
