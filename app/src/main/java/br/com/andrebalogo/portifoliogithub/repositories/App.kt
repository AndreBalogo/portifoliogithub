package br.com.andrebalogo.portifoliogithub.repositories

import android.app.Application
import br.com.andrebalogo.portifoliogithub.repositories.data.di.DataModule
import br.com.andrebalogo.portifoliogithub.repositories.domain.di.DomainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
    }
}