package com.vsv.feature_booking.presentation.booking.adapter.diff_util

import android.content.ContentValues.TAG
import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.vsv.feature_booking.domain.model.Tourist

class TouristDiffUtil : DiffUtil.ItemCallback<Tourist>() {

    override fun areItemsTheSame(oldItem: Tourist, newItem: Tourist): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Tourist, newItem: Tourist): Boolean {
        return oldItem.id == newItem.id && oldItem.nameError == newItem.nameError && oldItem.lastNameError == newItem.lastNameError
                && oldItem.birthdayError == newItem.birthdayError && oldItem.countryError == newItem.countryError
                && oldItem.foreignPassportNumberError == newItem.foreignPassportNumberError
                && oldItem.foreignPassportDateError == newItem.foreignPassportDateError
    }
}