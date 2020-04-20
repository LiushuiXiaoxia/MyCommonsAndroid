package cn.mycommons.simpleandroidbase.sab.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import timber.log.Timber

class ActivityLog : Application.ActivityLifecycleCallbacks {

    companion object {
        const val LINE = "....."
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        Timber.d("${activity}${LINE}onActivityCreated")
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        Timber.d("$activity${LINE}onActivitySaveInstanceState")
    }

    override fun onActivityStarted(activity: Activity?) {
        Timber.d("$activity${LINE}onActivityStarted")
    }

    override fun onActivityResumed(activity: Activity?) {
        Timber.d("$activity${LINE}onActivityResumed")
    }

    override fun onActivityPaused(activity: Activity?) {
        Timber.d("$activity${LINE}onActivityPaused")
    }

    override fun onActivityStopped(activity: Activity?) {
        Timber.d("$activity${LINE}onActivityStopped")
    }

    override fun onActivityDestroyed(activity: Activity?) {
        Timber.d("$activity${LINE}onActivityDestroyed")
    }
}