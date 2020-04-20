package cn.mycommons.simpleandroidbase.sab.base.view

import android.app.ProgressDialog
import android.content.Context
import cn.mycommons.simpleandroidbase.sab.R
import cn.mycommons.simpleandroidbase.sab.base.ILoadView

class ProgressLoadView : ProgressDialog, ILoadView {
    
    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, theme: Int) : super(context, theme) {
        init()
    }

    private fun init() {
        setCancelable(false)
        setMessage(context.getString(R.string.sab_base_loading_message))
        setProgressStyle(STYLE_SPINNER)
    }

    override fun showLoadView() {
        show()
    }

    override fun dismissLoadView() {
        dismiss()
    }

    override fun showMessage(message: String) {}
}