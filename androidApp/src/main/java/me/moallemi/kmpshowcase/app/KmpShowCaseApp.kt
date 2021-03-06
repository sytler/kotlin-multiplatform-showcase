package me.moallemi.kmpshowcase.app

import android.app.Application
import me.moallemi.kmpshowcase.di.appModule
import me.moallemi.kmpshowcase.shared.di.initKoinAndroid
import org.koin.android.ext.koin.androidContext

class KmpShowCaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin()
    }

    private fun initializeKoin() {
        initKoinAndroid {
            androidContext(this@KmpShowCaseApp)
            modules(appModule)
        }
    }

}