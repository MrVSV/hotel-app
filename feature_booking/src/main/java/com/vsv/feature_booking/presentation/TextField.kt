package com.vsv.feature_booking.presentation

enum class TextField(var property: String = "", var error: Boolean = false) {
    NAME, LAST_NAME, BIRTHDAY, COUNTRY, FOREIGN_PASSPORT_NUMBER, FOREIGN_PASSPORT_DATE
}