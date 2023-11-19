package com.vsv.feature_rooms.presentation.adapter.delegates

import android.view.LayoutInflater
import com.google.android.material.chip.Chip
import com.vsv.core.utils.decimal
import com.vsv.core_ui.R
import com.vsv.core_ui.view_pager.ViewPagerAdapter
import com.vsv.delegates.adapterDelegate
import com.vsv.feature_rooms.databinding.RoomInfoViewHolderBinding
import com.vsv.feature_rooms.domain.model.Room

fun roomInfoDelegate(onClick: () -> Unit) =
    adapterDelegate<Room, Room, RoomInfoViewHolderBinding>({ parent ->
        RoomInfoViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {
        bind {
            with(binding) {
                viewPagerLayout.binding.viewPager.adapter = ViewPagerAdapter(
                    item.imageUrls
                )
                viewPagerLayout.setupViewPager()
                roomName.text = item.name
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
                price.text =
                    root.context.getString(com.vsv.feature_rooms.R.string.room_price, item.price.decimal())
                pricePer.text = item.pricePer
                selectRoomButton.setOnClickListener { onClick() }

            }
        }
    }