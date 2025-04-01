package me.kristianconk.cooperachapp

import android.app.Application
import me.kristianconk.cooperachapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class CooperachApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CooperachApp)
            modules(appModule)
        }
    }
}