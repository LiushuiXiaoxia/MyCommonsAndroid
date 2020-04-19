package cn.mycommons.simplebase.android.base.mvp

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.mycommons.simplebase.android.base.BaseFragment
import cn.mycommons.simplebase.android.util.logDebug
import cn.mycommons.simplebase.android.util.logError
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

abstract class BaseFragment<P : BasePresenter<V>, V : IBaseMvpView> : BaseFragment() {

    var presenter: P? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, bundle: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        logDebug("onViewCreated")

        initPresenter()
        presenter?.onCreate()
        afterCreated(view, savedInstanceState)
    }

    private fun initPresenter() {
        val genType: Type = javaClass.genericSuperclass
        try {
            if (genType is ParameterizedType) {
                val presenterClazz = genType.actualTypeArguments[0]
                if (presenterClazz is Class<*>) {
                    presenter = presenterClazz.newInstance() as P
                }
                val viewClazz = genType.actualTypeArguments[1]

                if (viewClazz is Class<*>) {
                    if (viewClazz.isInstance(this)) {
                        presenter?.mvpView = this as V
                    }
                }
            }
        } catch (e: Exception) {
            logError("init mvp error", e)
        } finally {
            logDebug("presenter = $presenter, mvpView = ${presenter?.mvpView}")
        }
    }

    @LayoutRes
    abstract fun layoutId(): Int

    abstract fun afterCreated(view: View, bundle: Bundle?)

    override fun onDestroy() {
        super.onDestroy()

        logDebug("onDestroy")

        presenter?.onDestroy()
    }
}