package cn.mycommons.simpleandroidbase.sab.util

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat


const val REQUEST_CODE_ASK_PERMISSIONS = 123

fun Activity.requestPermission(permissionList: List<String>): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val list = mutableListOf<String>()

        for (s in permissionList) {
            val permission = ActivityCompat.checkSelfPermission(this, s)
            if (permission != PackageManager.PERMISSION_GRANTED) {
                list.add(s)
            }
        }
        if (list.isNotEmpty()) {
            requestPermissions(list.toTypedArray(), REQUEST_CODE_ASK_PERMISSIONS)
            return false
        }
    }
    return true
}


fun Activity.resultPermission(grantResults: IntArray): Boolean {
    for ((_, it) in grantResults.withIndex()) {
        if (it != PackageManager.PERMISSION_GRANTED) {
            showToast("Get Permission Denied")
            finish()
            return false
        }
    }
    return true
}