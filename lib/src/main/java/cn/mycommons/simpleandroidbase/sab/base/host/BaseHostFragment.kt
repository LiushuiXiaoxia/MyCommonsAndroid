package cn.mycommons.simpleandroidbase.sab.base.host

import cn.mycommons.simpleandroidbase.sab.base.BaseFragment

/**
 * BaseHostFragment <br/>
 * Created by xiaqiulei on 2020-03-25.
 */
abstract class BaseHostFragment<P : BaseHostParam> : BaseFragment() {

    fun getParam(): P? {
        val serializable = arguments?.getSerializable(BaseHostActivity.EXTRA_PARAM)
        if (serializable != null) {
            return serializable as P?
        }
        return null
    }
}