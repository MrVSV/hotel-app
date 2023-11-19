package com.vsv.feature_hotel.di

import com.vsv.feature_hotel.data.repository.HotelRepositoryImpl
import com.vsv.feature_hotel.domain.repository.HotelRepository
import com.vsv.feature_hotel.domain.use_case.GetHotelUseCase
import com.vsv.feature_hotel.domain.use_case.impl.GetHotelUseCaseImpl
import com.vsv.feature_hotel.presentation.HotelViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

fun featureHotelModule() = module {

    single<HotelRepository> { HotelRepositoryImpl(api = get()) }

    single<GetHotelUseCase> { GetHotelUseCaseImpl(repository = get()) }

    viewModel {
        HotelViewModel(
            getHotelUseCase = get(),
            dispatcherWrapper = get(),
        )
    }
}