package cn.mycommons.simpleandroidbase.demo.ui

import android.os.Bundle
import cn.mycommons.simpleandroidbase.demo.R
import cn.mycommons.simpleandroidbase.demo.ui.base.DemoBaseActivity
import cn.mycommons.simpleandroidbase.demo.ui.base.DemoHostParam
import cn.mycommons.simpleandroidbase.demo.ui.base.DemoMvp2Activity
import cn.mycommons.simpleandroidbase.demo.ui.base.DemoMvpActivity
import cn.mycommons.simpleandroidbase.demo.util.gotoActivity
import cn.mycommons.simpleandroidbase.sab.base.BaseActivity
import cn.mycommons.simpleandroidbase.sab.base.host.pageStart
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBase.setOnClickListener {
            gotoActivity(DemoBaseActivity::class.java)
        }
        btnParam.setOnClickListener {
            val param = DemoHostParam().apply {
                msg = "Hello world"
            }
            param.pageStart(this)
        }

        btnMvpActivity.setOnClickListener {
            gotoActivity(DemoMvpActivity::class.java)
        }

        btnMvpFragment.setOnClickListener {
            gotoActivity(DemoMvp2Activity::class.java)
        }
    }
}