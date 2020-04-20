package cn.mycommons.simpleandroidbase.sab

import android.content.Context
import cn.mycommons.simpleandroidbase.sab.base.ILoadView
import cn.mycommons.simpleandroidbase.sab.base.view.ProgressLoadView
import org.greenrobot.eventbus.EventBus

interface SabFactory {

    /**
     * container activity or fragment
     */
    fun loadView(container: Any, context: Context): ILoadView

    fun eventBus(): EventBus
}

class DefaultSabFactory : SabFactory {

    override fun loadView(container: Any, context: Context): ILoadView {
        return ProgressLoadView(context)
    }

    override fun eventBus(): EventBus {
        return EventBus.getDefault()
    }
}