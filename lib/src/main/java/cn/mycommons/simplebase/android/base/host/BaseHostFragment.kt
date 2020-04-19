package cn.mycommons.simplebase.android.base.host

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * BaseHostFragment <br/>
 * Created by xiaqiulei on 2020-03-25.
 */
abstract class BaseHostFragment<P : BaseHostParam> : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    @LayoutRes
    abstract fun layoutId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        doInit(savedInstanceState)
    }

    fun setActivityTitle(title: String) {
        activity?.title = title
    }

    abstract fun doInit(savedInstanceState: Bundle?)

    fun getParam(): P? {
        val serializable = arguments?.getSerializable(BaseHostActivity.EXTRA_PARAM)
        if (serializable != null) {
            return serializable as P?
        }
        return null
    }
}