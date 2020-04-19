package cn.mycommons.simplebase.android.app

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import cn.mycommons.simplebase.android.util.DefaultLogback
import cn.mycommons.simplebase.android.util.Logback
import timber.log.Timber

abstract class BaseApp : Application() {

    companion object {

        private lateinit var instance: BaseApp

        fun baseApp(): BaseApp = instance
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

        instance = this
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

        if (config().debug) {
            Timber.plant(Timber.DebugTree())
            registerActivityLifecycleCallbacks(ActivityLog())
        }
    }

    abstract fun config(): BaseConfig
}

class BaseConfig(
    val debug: Boolean,
    val logback: Logback = DefaultLogback()
)