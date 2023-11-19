package com.vsv.feature_booking.presentation.booking.adapter.delegates

import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.vsv.delegates.adapterDelegate
import com.vsv.feature_booking.R
import com.vsv.feature_booking.databinding.TouristViewHolderBinding
import com.vsv.feature_booking.domain.model.Tourist
import com.vsv.feature_booking.presentation.TextField

fun touristDelegate(onTextChange: (TextField, Int) -> Unit) =
    adapterDelegate<Tourist, Tourist, TouristViewHolderBinding>({ parent ->
        TouristViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {
        val defColor = binding.touristName.boxBackgroundColor
        bind {
            with(binding) {
                touristNumber.text =
                    root.context.resources.getStringArray(R.array.tourist_number)[item.id - 1]
                expandButton.isSelected = true
                inputs.isVisible = expandButton.isSelected
                expandButton.setOnClickListener {
                    expandButton.isSelected = !expandButton.isSelected
                    inputs.isVisible = expandButton.isSelected
                }
                touristName.apply {
                    if (item.nameError) setBoxBackgroundColorResource(com.vsv.core_ui.R.color.error)
                    editText?.setText(item.name)
                    editText?.doAfterTextChanged { text ->
                        if(text.toString().isNotEmpty())
                            boxBackgroundColor = defColor
                        TextField.NAME.property = text.toString()
                        onTextChange(TextField.NAME, bindingAdapterPosition)
                    }
                }
                lastName.apply {
                    if (item.lastNameError) setBoxBackgroundColorResource(com.vsv.core_ui.R.color.error)
                    editText?.setText(item.lastName)
                    editText?.doAfterTextChanged { text ->
                        if(text.toString().isNotEmpty())
                            boxBackgroundColor = defColor
                        TextField.LAST_NAME.property = text.toString()
                        onTextChange(TextField.LAST_NAME, bindingAdapterPosition)
                    }
                }
                birthday.apply {
                    if (item.birthdayError) setBoxBackgroundColorResource(com.vsv.core_ui.R.color.error)
                    editText?.setText(item.birthday)
                    editText?.doAfterTextChanged { text ->
                        if(text.toString().isNotEmpty())
                            boxBackgroundColor = defColor
                        TextField.BIRTHDAY.property = text.toString()
                        onTextChange(TextField.BIRTHDAY, bindingAdapterPosition)
                    }
                }
                country.apply {
                    if (item.countryError) setBoxBackgroundColorResource(com.vsv.core_ui.R.color.error)
                    editText?.setText(item.country)
                    editText?.doAfterTextChanged { text ->
                        if(text.toString().isNotEmpty())
                            boxBackgroundColor = defColor
                        TextField.COUNTRY.property = text.toString()
                        onTextChange(TextField.COUNTRY, bindingAdapterPosition)
                    }
                }
                foreignPassportNumber.apply {
                    if (item.foreignPassportNumberError) setBoxBackgroundColorResource(com.vsv.core_ui.R.color.error)
                    editText?.setText(item.foreignPassportNumber)
                    editText?.doAfterTextChanged { text ->
                        if(text.toString().isNotEmpty())
                            boxBackgroundColor = defColor
                        TextField.FOREIGN_PASSPORT_NUMBER.property = text.toString()
                        onTextChange(TextField.FOREIGN_PASSPORT_NUMBER, bindingAdapterPosition)
                    }
                }
                foreignPassportDate.apply {
                    if (item.foreignPassportDateError) setBoxBackgroundColorResource(com.vsv.core_ui.R.color.error)
                    editText?.setText(item.foreignPassportDate)
                    editText?.doAfterTextChanged { text ->
                        if(text.toString().isNotEmpty())
                            boxBackgroundColor = defColor
                        TextField.FOREIGN_PASSPORT_DATE.property = text.toString()
                        onTextChange(TextField.FOREIGN_PASSPORT_DATE, bindingAdapterPosition)
                    }
                }
            }
        }
    }