package cn.mycommons.simpleandroidbase.sab

import android.app.Application
import android.content.Context
import cn.mycommons.simpleandroidbase.sab.app.ActivityLog
import timber.log.Timber

object SabKit {

    lateinit var context: Context
    lateinit var config: SabConfig
    lateinit var factory: SabFactory

    private val activityLog = ActivityLog()

    fun init(context: Context, config: SabConfig = SabConfig(), factory: SabFactory = DefaultSabFactory()) {
        this.context = context
        this.config = config
        this.factory = factory

        Timber.plant(Timber.DebugTree())

        val application = context.applicationContext as Application
        // 防止重复初始化
        application.unregisterActivityLifecycleCallbacks(activityLog)
        application.registerActivityLifecycleCallbacks(activityLog)
    }

    fun context(): Context = context
}