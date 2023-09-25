package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PicPayApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        configureKoin()
    }

    private fun configureKoin() {
        startKoin {
            androidContext(this@PicPayApplication)
            modules(AppModule.getModules())
        }
    }
}
