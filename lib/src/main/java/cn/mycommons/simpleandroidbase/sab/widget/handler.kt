package cn.mycommons.simpleandroidbase.sab.widget

import android.os.Handler
import android.os.Looper

/**
 * handler <br/>
 * Created by xiaqiulei on 2020-04-26.
 */


fun Handler.checkPost(runnable: Runnable) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
        runnable.run()
    } else {
        post(runnable)
    }
}

fun Handler.checkPost(runnable: () -> Unit) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
        runnable.invoke()
    } else {
        post(runnable)
    }
}