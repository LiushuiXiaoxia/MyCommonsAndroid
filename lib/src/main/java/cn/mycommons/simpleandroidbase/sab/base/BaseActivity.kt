package cn.mycommons.simpleandroidbase.sab.base

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import cn.mycommons.simpleandroidbase.sab.SabKit
import cn.mycommons.simpleandroidbase.sab.util.showToast

abstract class BaseActivity : AppCompatActivity(), IUiCreator, ILoadView {

    val uiHandler = Handler(Looper.getMainLooper())

    private lateinit var loadView: ILoadView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onCreateBefore()
        doCreate()
        onCreateAfter(savedInstanceState)
    }

    private fun doCreate() {
        initActionBar()

        try {
            SabKit.factory.eventBus().register(this)
        } catch (e: Exception) {
        }
        loadView = createLoadView()
    }

    open fun hasBackButton(): Boolean = false

    open fun initActionBar() {
        if (hasBackButton()) {
            supportActionBar?.let {
                it.setDisplayHomeAsUpEnabled(true)
                it.setDisplayShowHomeEnabled(true)
            }
        }
    }

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
        SabKit.factory.eventBus().unregister(this)
    }

    fun getActivity() = this

    fun getContext() = this

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// ILoadView
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 自定义加载视图
     */
    open fun createLoadView(): ILoadView = SabKit.factory.loadView(this, this)

    override fun showLoadView() {
        uiHandler.post {
            if (!isDestroyActivity()) {
                loadView.showLoadView()
            }
        }
    }

    override fun dismissLoadView() {
        uiHandler.post {
            if (!isDestroyActivity()) {
                loadView.dismissLoadView()
            }
        }
    }

    override fun showMessage(message: String) {
        showToast(message)
    }

    fun isDestroyActivity(): Boolean {
        return isFinishing || isDestroyed
    }
}