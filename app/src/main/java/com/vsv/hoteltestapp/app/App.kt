package com.vsv.hoteltestapp.app

import android.app.Application
import com.vsv.core.di.coreModule
import com.vsv.feature_booking.di.featureBookingModule
import com.vsv.feature_hotel.di.featureHotelModule
import com.vsv.feature_rooms.di.featureRoomsModule
import com.vsv.remote_api.di.apiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(androidContext = this@App)
            androidLogger(level = Level.DEBUG)
            modules(
                featureHotelModule(),
                featureRoomsModule(),
                featureBookingModule(),
                apiModule(),
                coreModule()
            )
        }
    }
}