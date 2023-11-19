package com.vsv.feature_booking.di

import com.vsv.feature_booking.data.repository.BookingRepositoryImpl
import com.vsv.feature_booking.domain.repository.BookingRepository
import com.vsv.feature_booking.domain.use_case.GetBookingUseCase
import com.vsv.feature_booking.domain.use_case.impl.GetBookingUseCaseImpl
import com.vsv.feature_booking.presentation.booking.BookingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun featureBookingModule() = module {

    single<BookingRepository> { BookingRepositoryImpl(api = get()) }

    single<GetBookingUseCase> { GetBookingUseCaseImpl(repository = get()) }

    viewModel { BookingViewModel(
        getBookingUseCase = get(),
        dispatcherWrapper = get()
    ) }
}