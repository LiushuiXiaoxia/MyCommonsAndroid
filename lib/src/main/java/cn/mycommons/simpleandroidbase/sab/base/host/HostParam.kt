package cn.mycommons.simpleandroidbase.sab.base.host

import android.content.Context
import android.content.Intent
import java.io.Serializable


abstract class BaseHostParam(val gotoBack: Boolean = true) : Serializable {
    var hostClass: Class<out BaseHostActivity> = BaseHostActivity::class.java
    var fragmentClass: Class<out BaseHostFragment<*>>? = null
}


fun startHostFragment(context: Context, param: BaseHostParam = EmptyParam()) {
    Intent(context, param.hostClass).apply {
        putExtra(BaseHostActivity.EXTRA_FRAGMENT, param.fragmentClass)
        putExtra(BaseHostActivity.EXTRA_PARAM, param)
        context.startActivity(this)
    }
}

fun BaseHostParam.startHostFragment(context: Context, clazz: Class<out BaseHostFragment<*>>? = null) {
    if (clazz != null) {
        this.fragmentClass = clazz
    }
    startHostFragment(context, this)
}

@Deprecated("", ReplaceWith("this.startHostFragment(context, clazz)"))
fun BaseHostParam.pageStart(context: Context, clazz: Class<out BaseHostFragment<*>>? = null) {
    this.startHostFragment(context, clazz)
}

class EmptyParam : BaseHostParam()