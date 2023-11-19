package com.vsv.core.di

import com.vsv.core.wrapper.DispatcherWrapper
import com.vsv.core.wrapper.DispatcherWrapperImpl
import org.koin.dsl.module

fun coreModule() = module {

    single<DispatcherWrapper> { DispatcherWrapperImpl() }

}