package cn.mycommons.simpleandroidbase.demo.ui.base

import android.os.Bundle
import cn.mycommons.simpleandroidbase.demo.R
import cn.mycommons.simpleandroidbase.sab.base.BaseActivity

class DemoMvp2Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_demo_mvp)

        supportFragmentManager.beginTransaction()
            .add(R.id.flRoot, DemoMvpFragment())
            .commit()
    }
}