package cn.mycommons.simpleandroidbase.sab.app

import android.app.Application
import android.content.Context
import timber.log.Timber

object App {

    private lateinit var context: Context
    private lateinit var config: SabConfig
    private val activityLog = ActivityLog()

    fun init(base: Context, config: SabConfig = SabConfig()) {
        this.context = base
        this.config = config

        if (config.debug) {
            Timber.plant(Timber.DebugTree())
            val application = context.applicationContext as Application
            // 防止重复初始化
            application.unregisterActivityLifecycleCallbacks(activityLog)
            application.registerActivityLifecycleCallbacks(activityLog)
        }
    }

    fun context(): Context = context
    fun config(): SabConfig = config
}

class SabConfig(
    val debug: Boolean = false
)