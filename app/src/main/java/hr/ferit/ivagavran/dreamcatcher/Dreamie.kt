package hr.ferit.ivagavran.dreamcatcher

import android.app.Application

class Dreamie: Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        lateinit var application: Application
    }
}