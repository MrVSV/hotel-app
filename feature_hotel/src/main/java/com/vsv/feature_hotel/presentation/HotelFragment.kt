package com.vsv.feature_hotel.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.vsv.core.SetWindow
import com.vsv.core.base.BaseFragment
import com.vsv.feature_hotel.R
import com.vsv.feature_hotel.databinding.FragmentHotelBinding
import com.vsv.feature_hotel.presentation.adapter.HotelInfoAdapter
import com.vsv.feature_hotel.presentation.state.HotelState
import org.koin.androidx.viewmodel.ext.android.viewModel

class HotelFragment : BaseFragment<FragmentHotelBinding>() {

    private val adapter by lazy { HotelInfoAdapter() }
    private val viewModel by viewModel<HotelViewModel>()

    override fun initBinding(inflater: LayoutInflater): FragmentHotelBinding {
        return FragmentHotelBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.adapter = adapter
        flowObserver(viewModel.viewStates()) { state -> stateObserver(state) }
    }

    private fun stateObserver(state: HotelState) {
        (activity as SetWindow).setUpProgressBar(state.isLoading)
        if (!state.isLoading) {
            adapter.submitList(state.hotel)
            (activity as SetWindow).setUpBottomButton(getString(R.string.to_room), !state.isLoading){
                val request = NavDeepLinkRequest.Builder
                    .fromUri(("android-app:/rooms/${state.hotel.first().name}").toUri())
                    .build()
                findNavController().navigate(request)
            }
        }
    }
}