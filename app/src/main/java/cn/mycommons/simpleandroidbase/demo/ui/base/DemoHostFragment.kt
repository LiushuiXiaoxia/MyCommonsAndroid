package cn.mycommons.simpleandroidbase.demo.ui.base

import android.os.Bundle
import cn.mycommons.simpleandroidbase.demo.R
import cn.mycommons.simpleandroidbase.sab.base.host.BaseHostFragment
import cn.mycommons.simpleandroidbase.sab.base.host.BaseHostParam
import cn.mycommons.simpleandroidbase.sab.util.showToast
import kotlinx.android.synthetic.main.fragment_demo_host.*

class DemoHostParam : BaseHostParam() {

    var msg: String? = null
}

class DemoHostFragment : BaseHostFragment<DemoHostParam>() {

    override fun layoutId(): Int = R.layout.fragment_demo_host

    override fun onCreateAfter(savedInstanceState: Bundle?) {
        setActivityTitle(this.javaClass.simpleName)

        btnToast.setOnClickListener {
            showToast(getParam()?.msg ?: "")
        }
    }
}