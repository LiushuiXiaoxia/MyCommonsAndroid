package cn.mycommons.simpleandroidbase.demo.ui.base

import android.os.Bundle
import cn.mycommons.simpleandroidbase.demo.R
import cn.mycommons.simpleandroidbase.sab.base.mvp.BaseMvpActivity

class DemoMvpActivity : BaseMvpActivity<DemoMvpPresenter, IDemoMvpView>(), IDemoMvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_demo_mvp)

        presenter?.loadData()
    }

    override fun loadDataSuccess(data: String) {
        showMessage(data)
    }
}