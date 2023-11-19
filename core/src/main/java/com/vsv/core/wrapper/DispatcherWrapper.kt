package com.vsv.core.wrapper

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherWrapper {

    val io: CoroutineDispatcher
}