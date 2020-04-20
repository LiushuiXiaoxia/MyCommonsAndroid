package cn.mycommons.simpleandroidbase.sab.base.mvp

import cn.mycommons.simpleandroidbase.sab.base.BaseFragment

abstract class BaseMvpFragment<P : BaseMvpPresenter<V>, V : IMvpView> : BaseFragment() {

    protected var presenter: P? = null

    override fun onCreateBefore() {
        super.onCreateBefore()

        val proxy: MvpKit<*, *> =
            MvpKit<P, V>(this)
        val instance = proxy.mvpInstance()
        presenter = instance[0] as P?
        presenter?.attach(this, instance[1] as V)
    }

    override fun onDestroy() {
        presenter?.detach()

        super.onDestroy()
    }
}