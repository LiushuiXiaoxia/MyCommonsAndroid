package cn.mycommons.simpleandroidbase.demo.ui.base

import android.os.Bundle
import cn.mycommons.simpleandroidbase.demo.R
import cn.mycommons.simpleandroidbase.sab.base.mvp.BaseMvpFragment

class DemoMvpFragment : BaseMvpFragment<DemoMvpPresenter, IDemoMvpView>(), IDemoMvpView {

    override fun layoutId(): Int = R.layout.fragment_demo_mvp

    override fun onCreateAfter(savedInstanceState: Bundle?) {
        setActivityTitle(this.javaClass.simpleName)

        presenter?.loadData()
    }

    override fun loadDataSuccess(data: String) {
        showMessage(data)
    }
}