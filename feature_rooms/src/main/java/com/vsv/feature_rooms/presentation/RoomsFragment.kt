package com.vsv.feature_rooms.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.vsv.core.SetWindow
import com.vsv.core.base.BaseFragment
import com.vsv.feature_rooms.databinding.FragmentRoomsBinding
import com.vsv.feature_rooms.presentation.adapter.RoomInfoAdapter
import com.vsv.feature_rooms.presentation.state.RoomsState
import org.koin.androidx.viewmodel.ext.android.viewModel

class RoomsFragment : BaseFragment<FragmentRoomsBinding>() {

    private val viewModel by viewModel<RoomsViewModel>()
    private val adapter by lazy { RoomInfoAdapter(onClick = ::onClick) }

    private fun onClick() {
        val request = NavDeepLinkRequest.Builder
            .fromUri(("android-app:/booking").toUri())
            .build()
        findNavController().navigate(request)
    }

    override fun initBinding(inflater: LayoutInflater): FragmentRoomsBinding {
        return FragmentRoomsBinding.inflate(inflater)
    }
    private val args by navArgs<RoomsFragmentArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.adapter = adapter
        flowObserver(viewModel.viewStates()) { state -> stateObserver(state) }
    }

    private fun stateObserver(state: RoomsState) {
        (activity as SetWindow).setUpProgressBar(state.isLoading)
        if (!state.isLoading) {
            (activity as SetWindow).setUpTitle(args.hotelName)
            adapter.submitList(state.rooms)
        }
    }

}