package cn.mycommons.simpleandroidbase.demo.util

import android.app.Activity
import android.content.Intent

fun Activity.gotoActivity(clazz: Class<out Activity>) {
    startActivity(Intent(this, clazz))
}