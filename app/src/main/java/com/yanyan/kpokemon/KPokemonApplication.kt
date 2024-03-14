package com.yanyan.kpokemon

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class KPokemonApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        // Init Timber
        Timber.plant(Timber.DebugTree());
    }
}