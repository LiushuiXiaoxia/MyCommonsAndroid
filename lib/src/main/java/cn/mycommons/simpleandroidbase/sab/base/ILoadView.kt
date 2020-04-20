package cn.mycommons.simpleandroidbase.sab.base

interface ILoadView {
    /**
     * show dialog
     */
    fun showLoadView()

    /**
     * dismiss dialog
     */
    fun dismissLoadView()

    /**
     * show message, such as show toast
     */
    fun showMessage(message: String)
}