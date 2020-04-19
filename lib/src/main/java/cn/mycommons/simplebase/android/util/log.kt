package cn.mycommons.simplebase.android.util

import android.util.Log
import cn.mycommons.simplebase.android.app.BaseApp

interface Logback {

    fun d(tag: String, msg: String)

    fun i(tag: String, msg: String)

    fun w(tag: String, msg: String)

    fun e(tag: String, msg: String)

    fun e(tag: String, msg: String, t: Throwable)
}

class DefaultLogback : Logback {

    override fun d(tag: String, msg: String) {
        Log.d(tag, msg)
    }

    override fun i(tag: String, msg: String) {
        Log.i(tag, msg)
    }

    override fun w(tag: String, msg: String) {
        Log.w(tag, msg)
    }

    override fun e(tag: String, msg: String) {
        Log.e(tag, msg)
    }

    override fun e(tag: String, msg: String, t: Throwable) {
        Log.e(tag, msg, t)
    }
}


internal fun debug() = BaseApp.baseApp().config().debug

internal fun logback() = BaseApp.baseApp().config().logback

internal fun Any.tag(): String {
    var name = javaClass.simpleName
    if (name.isEmpty()) {
        name = javaClass.name
        if (name.isEmpty()) {
            name = "SimpleBase"
        } else if (name.contains(".")) {
            name = name.substring(name.lastIndexOf(".") + 1)
        }
    }
    return name
}

fun Any.logDebug(msg: String) {
    if (debug()) {
        logback().d(tag(), msg)
    }
}

fun Any.logInfo(msg: String) {
    if (debug()) {
        logback().i(tag(), msg)
    }
}

fun Any.logError(msg: String) {
    if (debug()) {
        logback().e(tag(), msg)
    }
}

fun Any.logError(msg: String, t: Throwable) {
    if (debug()) {
        logback().e(tag(), msg, t)
    }
}

fun Any.logThread() {
    if (debug()) {
        logback().e(tag(), "currentThread = ${Thread.currentThread()}")
    }
}