package cn.mycommons.simpleandroidbase.sab.base.mvp.mvp2

import cn.mycommons.simpleandroidbase.sab.base.ILoadView

internal interface IMvpPresenter<V : IMvpView> {

    /**
     * 创建
     */
    fun attach(loadView: ILoadView, view: V)

    /**
     * 销毁
     */
    fun detach()
}