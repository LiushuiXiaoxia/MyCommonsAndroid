package cn.mycommons.simplebase.android.base.mvp.mvp2

import android.os.Handler
import android.os.Looper
import cn.mycommons.simplebase.android.base.ILoadView
import cn.mycommons.simplebase.android.util.logDebug

abstract class BaseMvpPresenter<V : IMvpView> : IMvpPresenter<V>, ILoadView {

    var mvpView: V? = null
    private var loadView: ILoadView? = null
    val uiHandler = Handler(Looper.getMainLooper())

    override fun attach(loadView: ILoadView, view: V) {
        logDebug("attach")
        this.mvpView = view
        this.loadView = loadView
    }


    override fun detach() {
        logDebug("detach")

        mvpView = null
        loadView = null
        uiHandler.removeCallbacksAndMessages(null)
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    override fun showLoadView() {
        loadView?.showLoadView()
    }

    override fun dismissLoadView() {
        loadView?.dismissLoadView()
    }

    override fun showMessage(message: String) {
        loadView?.showMessage(message)
    }
}