//package cn.mycommons.simpleandroidbase.sab.base.mvp
//
//import cn.mycommons.simpleandroidbase.sab.util.logDebug
//import org.greenrobot.eventbus.EventBus
//
//abstract class BasePresenter<V : IBaseMvpView> {
//
//    var mvpView: V? = null
//
//    fun onCreate() {
//        logDebug("onCreate")
//
//        try {
//            EventBus.getDefault().register(this)
//        } catch (e: Exception) {
//        }
//    }
//
//    fun onDestroy() {
//        logDebug("onDestroy")
//
//        EventBus.getDefault().unregister(this)
//        mvpView = null
//    }
//}