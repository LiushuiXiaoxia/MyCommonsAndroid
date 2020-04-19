package cn.mycommons.simplebase.android.base

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.mycommons.simplebase.android.util.logDebug

abstract class BaseFragment : Fragment(), IUiCreator, ILoadView {

    val uiHandler = Handler(Looper.getMainLooper())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, bundle: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        logDebug("onViewCreated")
        onCreateBefore()

        onCreateAfter(savedInstanceState)
    }

    @LayoutRes
    abstract fun layoutId(): Int

    override fun onCreateBefore() {
    }

    fun launchOnUiThread(runnable: () -> Unit) {
        uiHandler.post(runnable)
    }

    fun launchOnUiThread(runnable: Runnable) {
        uiHandler.post(runnable)
    }
}