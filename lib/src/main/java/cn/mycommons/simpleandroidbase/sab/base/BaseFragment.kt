package cn.mycommons.simpleandroidbase.sab.base

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.mycommons.simpleandroidbase.sab.SabKit
import cn.mycommons.simpleandroidbase.sab.util.showToast
import cn.mycommons.simpleandroidbase.sab.widget.checkPost
import timber.log.Timber

abstract class BaseFragment : Fragment(), IUiCreator, ILoadView {

    val uiHandler = Handler(Looper.getMainLooper())

    private lateinit var loadView: ILoadView

    @LayoutRes
    abstract fun layoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, bundle: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.d("onViewCreated")
        onCreateBefore()
        loadView = createLoadView()
        onCreateAfter(savedInstanceState)
    }

    override fun onCreateBefore() {
    }

    fun setActivityTitle(title: String) {
        activity?.title = title
    }

    /**
     * 自定义加载视图
     */
    open fun createLoadView(): ILoadView = SabKit.factory.loadView(this, context!!)

    override fun showLoadView() {
        launchOnUiThread {
            loadView.showLoadView()
        }
    }

    override fun dismissLoadView() {
        launchOnUiThread {
            loadView.dismissLoadView()
        }
    }

    override fun showMessage(message: String) {
        showToast(message)
    }

    fun launchOnUiThread(runnable: () -> Unit) {
        uiHandler.checkPost(runnable)
    }

    fun launchOnUiThread(runnable: Runnable) {
        uiHandler.checkPost(runnable)
    }
}