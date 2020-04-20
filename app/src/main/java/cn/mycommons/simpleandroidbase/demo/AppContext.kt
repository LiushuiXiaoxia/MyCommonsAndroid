package cn.mycommons.simpleandroidbase.demo

import android.app.Application

/**
 * AppContext <br/>
 * Created by xiaqiulei on 2020-04-19.
 */

class AppContext : Application() {

    override fun onCreate() {
        super.onCreate()

        // SabKit.init(this, SabConfig(BuildConfig.DEBUG))
    }
}