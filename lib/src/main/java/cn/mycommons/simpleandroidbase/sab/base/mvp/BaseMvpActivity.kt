package cn.mycommons.simpleandroidbase.sab.base.mvp

import cn.mycommons.simpleandroidbase.sab.base.BaseActivity

abstract class BaseMvpActivity<P : BaseMvpPresenter<V>, V : IMvpView> : BaseActivity() {

    var presenter: P? = null

    override fun onCreateBefore() {
        super.onCreateBefore()

        val mvpKit: MvpKit<*, *> =
            MvpKit<P, V>(this)
        val instance = mvpKit.mvpInstance()

        presenter = instance[0] as P
        presenter?.attach(this, instance[1] as V)
    }

    override fun onDestroy() {
        presenter?.detach()
        presenter = null

        super.onDestroy()
    }
}