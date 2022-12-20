package net.pixiv.charcoal.android.catalog

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class CatalogApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}
