package com.vsv.feature_hotel.presentation.adapter.delegates

import android.view.LayoutInflater
import com.google.android.material.chip.Chip
import com.vsv.core.utils.decimal
import com.vsv.core_ui.R
import com.vsv.core_ui.view_pager.ViewPagerAdapter
import com.vsv.delegates.adapterDelegate
import com.vsv.feature_hotel.databinding.HotelInfoViewHolderBinding
import com.vsv.feature_hotel.domain.model.Hotel


fun hotelInfoDelegate() =
    adapterDelegate<Hotel, Hotel, HotelInfoViewHolderBinding>({ parent ->
        HotelInfoViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {
        bind {
            with(binding) {
                viewPagerLayout.binding.viewPager.adapter = ViewPagerAdapter(
                    item.imageUrls
                )
                viewPagerLayout.setupViewPager()
                hotelRating.text = root.context.getString(
                    com.vsv.feature_hotel.R.string.hotel_rating,
                    item.rating,
                    item.ratingName
                )
                hotelName.text = item.name
                hotelAdress.text = item.adress
                price.text =
                    root.context.getString(
                        com.vsv.feature_hotel.R.string.hotel_price,
                        item.minimalPrice.decimal()
                    )
                priceForIt.text = item.priceForIt

                item.peculiarities.forEach {
                    val chip = Chip(binding.chipGroup.context).apply {
                        setTextAppearance(R.style.BodyGreyText)
                        chipBackgroundColor =
                            binding.chipGroup.context.getColorStateList(R.color.chip_group_item_color)
                        chipStrokeWidth = 0f
                        closeIcon = null
                        isClickable = false
                        setEnsureMinTouchTargetSize(false)
                        text = it
                    }
                    chipGroup.addView(chip)
                }
                hotelDescription.text = item.description
            }
        }
    }