package cn.mycommons.simpleandroidbase.demo.ui.base

import cn.mycommons.simpleandroidbase.sab.base.mvp.BaseMvpPresenter
import cn.mycommons.simpleandroidbase.sab.base.mvp.IMvpView

class DemoMvpPresenter : BaseMvpPresenter<IDemoMvpView>() {

    fun loadData() {
        showLoadView()
        uiHandler.postDelayed({
            dismissLoadView()
            mvpView?.loadDataSuccess("hello world")
        }, 2000L)
    }
}


interface IDemoMvpView : IMvpView {

    fun loadDataSuccess(data: String)
}