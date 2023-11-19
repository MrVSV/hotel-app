package com.vsv.feature_rooms.di

import com.vsv.feature_rooms.data.repository.RoomsRepositoryImpl
import com.vsv.feature_rooms.domain.repository.RoomsRepository
import com.vsv.feature_rooms.domain.use_case.GetRoomsUseCase
import com.vsv.feature_rooms.domain.use_case.impl.GetRoomsUseCaseImpl
import com.vsv.feature_rooms.presentation.RoomsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun featureRoomsModule() = module {

    single<RoomsRepository> { RoomsRepositoryImpl(api = get()) }

    single<GetRoomsUseCase> { GetRoomsUseCaseImpl(repository = get()) }

    viewModel {
        RoomsViewModel(
            getRoomsUseCase = get(),
            dispatcherWrapper = get(),
        )
    }
}