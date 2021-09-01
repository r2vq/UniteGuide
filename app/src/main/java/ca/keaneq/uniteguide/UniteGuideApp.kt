package ca.keaneq.uniteguide

import android.app.Application
import ca.keaneq.uniteguide.di.AppModule
import org.koin.core.context.startKoin

class UniteGuideApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(AppModule)
        }
    }
}