package cn.mycommons.simplebase.demo

import cn.mycommons.simplebase.android.app.BaseApp
import cn.mycommons.simplebase.android.app.BaseConfig

/**
 * App <br/>
 * Created by xiaqiulei on 2020-04-19.
 */

class App : BaseApp() {

    override fun config(): BaseConfig = BaseConfig(BuildConfig.DEBUG)
}