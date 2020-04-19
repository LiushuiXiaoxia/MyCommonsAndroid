package cn.mycommons.simplebase.android.base

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import cn.mycommons.simplebase.android.base.view.ProgressLoadView
import org.greenrobot.eventbus.EventBus

abstract class BaseActivity : AppCompatActivity(), IUiCreator, ILoadView {

    val uiHandler = Handler(Looper.getMainLooper())

    var loadView: ILoadView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onCreateBefore()

        if (hasBackButton()) {
            supportActionBar?.let {
                it.setDisplayHomeAsUpEnabled(true)
                it.setDisplayShowHomeEnabled(true)
            }
        }

        try {
            EventBus.getDefault().register(this)
        } catch (e: Exception) {
        }

        loadView = createLoadView()
        onCreateAfter(savedInstanceState)
    }

    open fun hasBackButton(): Boolean = false

    override fun onCreateBefore() {
    }

    override fun onCreateAfter(savedInstanceState: Bundle?) {
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    fun getActivity() = this

    fun getContext() = this

    /**
     * 自定义加载视图
     */
    open fun createLoadView(): ILoadView {
        return ProgressLoadView(getContext())
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// ILoadView
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    override fun showLoadView() {
        uiHandler.post {
            if (!isDestroyActivity()) {
                loadView?.showLoadView()
            }
        }
    }

    override fun dismissLoadView() {
        uiHandler.post {
            if (!isDestroyActivity()) {
                loadView?.dismissLoadView()
            }
        }
    }

    override fun showMessage(message: String) {
        showMessage(message)
    }

    fun isDestroyActivity(): Boolean {
        return isFinishing || isDestroyed
    }
}