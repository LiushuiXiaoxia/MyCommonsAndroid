package cn.mycommons.simpleandroidbase.sab.base.mvp

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