package cn.mycommons.simplebase.android.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import org.greenrobot.eventbus.EventBus

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
    }

    open fun hasBackButton(): Boolean = false

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun getActivity() = this

    fun getContext() = this

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}