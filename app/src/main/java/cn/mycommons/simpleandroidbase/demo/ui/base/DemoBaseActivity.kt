package cn.mycommons.simpleandroidbase.demo.ui.base

import android.os.Bundle
import cn.mycommons.simpleandroidbase.demo.R
import cn.mycommons.simpleandroidbase.sab.base.BaseActivity
import kotlinx.android.synthetic.main.activity_demo_base.*

class DemoBaseActivity : BaseActivity() {

    override fun hasBackButton(): Boolean = true

    override fun onCreateAfter(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_demo_base)
        title = this.javaClass.simpleName

        btnToast.setOnClickListener { showMessage("Hello world!!!") }
        showLoadView()

        uiHandler.postDelayed({
            dismissLoadView()
        }, 2000L)
    }
}