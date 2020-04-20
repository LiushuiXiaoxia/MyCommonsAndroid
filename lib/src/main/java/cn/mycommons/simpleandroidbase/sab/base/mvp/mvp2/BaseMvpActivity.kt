package cn.mycommons.simpleandroidbase.sab.base.mvp.mvp2

import cn.mycommons.simpleandroidbase.sab.base.BaseActivity

abstract class BaseMvpActivity<P : BaseMvpPresenter<V>, V : IMvpView> : BaseActivity() {

    var presenter: P? = null

    override fun onCreateBefore() {
        super.onCreateBefore()

        val proxy: MvpProxy<*, *> = MvpProxy<P, V>(this)
        val instance = proxy.mvpInstance()

        presenter = instance[0] as P
        presenter?.attach(this, instance[1] as V)
    }

    override fun onDestroy() {
        presenter?.detach()
        presenter = null

        super.onDestroy()
    }
}