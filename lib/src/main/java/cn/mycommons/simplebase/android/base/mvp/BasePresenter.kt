package cn.mycommons.simplebase.android.base.mvp

import cn.mycommons.simplebase.android.util.logDebug
import org.greenrobot.eventbus.EventBus

abstract class BasePresenter<V : IBaseMvpView> {

    var mvpView: V? = null

    fun onCreate() {
        logDebug("onCreate")

        try {
            EventBus.getDefault().register(this)
        } catch (e: Exception) {
        }
    }

    fun onDestroy() {
        logDebug("onDestroy")

        EventBus.getDefault().unregister(this)
        mvpView = null
    }
}