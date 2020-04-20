package cn.mycommons.simpleandroidbase.sab.base.host

import android.content.Context
import java.io.Serializable


abstract class BaseHostParam(val gotoBack: Boolean = true) : Serializable

fun <T : BaseHostFragment<*>> BaseHostParam.pageStart(context: Context, clazz: Class<T>) {
    BaseHostActivity.startFragment(context, clazz, this)
}

class EmptyParam : BaseHostParam()