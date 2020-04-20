package cn.mycommons.simpleandroidbase.sab.util

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.support.v4.app.Fragment
import android.widget.Toast
import cn.mycommons.simpleandroidbase.sab.app.App


private val handler by lazy { Handler(Looper.getMainLooper()) }

fun Context.showToast(msg: Int) {
    showToast(App.context().getString(msg))
}

fun Context.showToast(msg: String) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    } else {
        handler.post {
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
    }
}

fun Fragment.showToast(msg: Int) {
    showToast(App.context().getString(msg))
}

fun Fragment.showToast(msg: String) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
    } else {
        handler.post {
            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
        }
    }
}

fun showToast(msg: String) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
        Toast.makeText(App.context(), msg, Toast.LENGTH_LONG).show()
    } else {
        handler.post {
            Toast.makeText(App.context(), msg, Toast.LENGTH_LONG).show()
        }
    }
}