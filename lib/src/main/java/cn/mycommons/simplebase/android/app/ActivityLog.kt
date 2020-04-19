package cn.mycommons.simplebase.android.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import cn.mycommons.simplebase.android.util.logDebug

class ActivityLog : Application.ActivityLifecycleCallbacks {

    companion object {
        const val LINE = "....."
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        logDebug("${activity}${LINE}onActivityCreated")
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        logDebug("$activity${LINE}onActivitySaveInstanceState")
    }

    override fun onActivityStarted(activity: Activity?) {
        logDebug("$activity${LINE}onActivityStarted")
    }

    override fun onActivityResumed(activity: Activity?) {
        logDebug("$activity${LINE}onActivityResumed")
    }

    override fun onActivityPaused(activity: Activity?) {
        logDebug("$activity${LINE}onActivityPaused")
    }

    override fun onActivityStopped(activity: Activity?) {
        logDebug("$activity${LINE}onActivityStopped")
    }

    override fun onActivityDestroyed(activity: Activity?) {
        logDebug("$activity${LINE}onActivityDestroyed")
    }
}