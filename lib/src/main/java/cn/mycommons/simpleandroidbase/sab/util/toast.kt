@file:JvmName("ToastKit")

package cn.mycommons.simpleandroidbase.sab.util

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.support.v4.app.Fragment
import android.widget.Toast
import cn.mycommons.simpleandroidbase.sab.SabKit
import cn.mycommons.simpleandroidbase.sab.widget.checkPost


private val handler by lazy { Handler(Looper.getMainLooper()) }

private fun context(): Context = SabKit.context()

fun Context.showToast(msg: Int) {
    showToast(context().getString(msg))
}

fun Context.showToast(msg: String) {
    handler.checkPost {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}

fun Fragment.showToast(msg: Int) {
    showToast(context().getString(msg))
}

fun Fragment.showToast(msg: String) {
    handler.checkPost {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
    }
}

fun showToast(msg: String) {
    handler.checkPost {
        Toast.makeText(context(), msg, Toast.LENGTH_LONG).show()
    }
}