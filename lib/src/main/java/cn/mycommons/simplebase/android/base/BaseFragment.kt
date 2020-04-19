package cn.mycommons.simplebase.android.base

import android.os.Handler
import android.os.Looper
import android.support.v4.app.Fragment

open class BaseFragment : Fragment() {

    val uiHandler = Handler(Looper.getMainLooper())

    fun launchOnUiThread(runnable: () -> Unit) {
        uiHandler.post(runnable)
    }

    fun launchOnUiThread(runnable: Runnable) {
        uiHandler.post(runnable)
    }
}