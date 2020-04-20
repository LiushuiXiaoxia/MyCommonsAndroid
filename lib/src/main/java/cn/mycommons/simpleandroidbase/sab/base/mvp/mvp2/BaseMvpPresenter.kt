package cn.mycommons.simpleandroidbase.sab.base.mvp.mvp2

import android.os.Handler
import android.os.Looper
import cn.mycommons.simpleandroidbase.sab.base.ILoadView
import timber.log.Timber

abstract class BaseMvpPresenter<V : IMvpView> : IMvpPresenter<V>, ILoadView {

    var mvpView: V? = null
    private var loadView: ILoadView? = null
    val uiHandler = Handler(Looper.getMainLooper())

    override fun attach(loadView: ILoadView, view: V) {
        Timber.d("attach")
        this.mvpView = view
        this.loadView = loadView
    }

    override fun detach() {
        Timber.d("detach")

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