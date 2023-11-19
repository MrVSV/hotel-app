package com.vsv.feature_booking.presentation.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.vsv.core.SetWindow
import com.vsv.core.base.BaseFragment
import com.vsv.core.utils.decimal
import com.vsv.core.utils.setEmailValidationListener
import com.vsv.core_ui.utils.TextInputBoxColor
import com.vsv.feature_booking.R
import com.vsv.feature_booking.databinding.FragmentBookingBinding
import com.vsv.feature_booking.presentation.TextField
import com.vsv.feature_booking.presentation.booking.adapter.TouristAdapter
import com.vsv.feature_booking.presentation.booking.state.BookingState
import org.koin.androidx.viewmodel.ext.android.viewModel


class BookingFragment : BaseFragment<FragmentBookingBinding>() {

    private val adapter by lazy { TouristAdapter(::onTextChange) }

    private fun onTextChange(textField: TextField, touristIndex: Int) {
        viewModel.onTextChange(textField, touristIndex)
    }

    private val viewModel by viewModel<BookingViewModel>()
    override fun initBinding(inflater: LayoutInflater): FragmentBookingBinding {
        return FragmentBookingBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.adapter = adapter
        flowObserver(viewModel.viewStates()) { state -> stateObserver(state) }

    }

    private fun stateObserver(state: BookingState) {
        (activity as SetWindow).setUpProgressBar(state.isLoading)
        if (!state.isLoading) {
            binding.root.isVisible
            setupViews(state)
        }
    }

    private fun setupViews(state: BookingState) {
        with(binding) {
            hotelName.text = state.booking?.hotelName
            hotelAdress.text = state.booking?.hotelAdress
            hotelRating.text = root.context.getString(
                R.string.hotel_rating,
                state.booking?.horating,
                state.booking?.ratingName
            )
            departure.text = state.booking?.departure
            arrivalCountry.text = state.booking?.arrivalCountry
            dates.text = getString(
                R.string.booking_dates,
                state.booking?.tourDateStart,
                state.booking?.tourDateStop
            )
            numberOfNights.text = state.booking?.numberOfNights.toString()
            hotel.text = state.booking?.hotelName
            room.text = state.booking?.room
            nutrition.text = state.booking?.nutrition
            emailTextField.setEmailValidationListener(
                TextInputBoxColor.Default.color,
                TextInputBoxColor.Error.color
            )
            tourPrice.text =
                getString(R.string.tour_price, state.booking?.tourPrice?.decimal() ?: "")
            fuelCharge.text =
                getString(R.string.fuel_charge, state.booking?.fuelCharge?.decimal() ?: "")
            serviceCharge.text =
                getString(R.string.service_charge, state.booking?.serviceCharge?.decimal() ?: "")
            totalPrice.text =
                getString(R.string.total_price, state.booking?.totalPrice?.decimal() ?: "")
            adapter.submitList(state.touristList)
            addTouristText.text =
                if (state.touristList.size == 4) getString(R.string.max_tourist)
                else getString(R.string.add_tourist)
            addTouristButton.isEnabled = state.touristList.size < 4
            addTouristButton.setOnClickListener {
                if (state.touristList.any { it.hasEmptyProperty })
                    viewModel.checkEmptyFields()
                else viewModel.addTourist()
            }
        }
        (activity as SetWindow).setUpBottomButton(
            getString(R.string.big_blue_button_text, state.booking?.totalPrice?.decimal() ?: ""),
            true
        ) {
            if (state.touristList.any { it.hasEmptyProperty })
                viewModel.checkEmptyFields()
            else findNavController().navigate(R.id.action_bookingFragment_to_orderPaidFragment)
        }
    }


}