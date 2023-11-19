package com.vsv.feature_booking.presentation.order_paid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.vsv.core.SetWindow
import com.vsv.core.base.BaseFragment
import com.vsv.core.R
import com.vsv.feature_booking.databinding.FragmentOrderPaidBinding

class OrderPaidFragment : BaseFragment<FragmentOrderPaidBinding>() {

    override fun initBinding(inflater: LayoutInflater): FragmentOrderPaidBinding {
        return FragmentOrderPaidBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.confirmation.text =
            getString(com.vsv.feature_booking.R.string.confirmation, (1..100000).random())
        (activity as SetWindow).setUpBottomButton("Супер!", true) {
            val request = NavDeepLinkRequest.Builder
                .fromUri(("android-app:/hotel").toUri())
                .build()
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.hotelFragment, true).build()
            findNavController().navigate(request, navOptions)
        }
    }
}