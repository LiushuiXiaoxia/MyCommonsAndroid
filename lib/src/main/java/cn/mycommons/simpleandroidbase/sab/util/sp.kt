@file:JvmName("SpKit")

package cn.mycommons.simpleandroidbase.sab.util

import android.content.Context
import android.content.SharedPreferences
import android.support.v4.app.Fragment

const val SP_NAME = "sp"

interface SpPlus {

    fun putInt(key: String, value: Int)
    fun getInt(key: String, value: Int): Int

    fun putLong(key: String, value: Long)
    fun getLong(key: String, value: Long): Long

    fun putFloat(key: String, value: Float)
    fun getFloat(key: String, value: Float): Float

    fun putString(key: String, value: String?)
    fun getString(key: String, value: String?): String?

    fun removeAll()
    fun remove(key: String)

    fun contains(key: String): Boolean
}

class DefaultSp(private val sharedPreferences: SharedPreferences) : SpPlus {

    override fun putInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    override fun getInt(key: String, value: Int): Int {
        return sharedPreferences.getInt(key, value)
    }

    override fun putLong(key: String, value: Long) {
        sharedPreferences.edit().putLong(key, value).apply()
    }

    override fun getLong(key: String, value: Long): Long {
        return sharedPreferences.getLong(key, value)
    }

    override fun putFloat(key: String, value: Float) {
        sharedPreferences.edit().putFloat(key, value).apply()
    }

    override fun getFloat(key: String, value: Float): Float {
        return sharedPreferences.getFloat(key, value)
    }

    override fun putString(key: String, value: String?) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    override fun getString(key: String, value: String?): String? {
        return sharedPreferences.getString(key, value)
    }

    override fun removeAll() {
        sharedPreferences.edit().clear().apply()
    }

    override fun remove(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    override fun contains(key: String): Boolean {
        return sharedPreferences.contains(key)
    }
}

fun Context.sp(): SpPlus {
    return DefaultSp(getSharedPreferences(SP_NAME, Context.MODE_PRIVATE))
}

fun Context.sp(name: String): SpPlus {
    return DefaultSp(getSharedPreferences("${SP_NAME}_$name", Context.MODE_PRIVATE))
}

fun Fragment.sp(): SpPlus {
    return context!!.sp()
}

fun Fragment.sp(name: String): SpPlus {
    return context!!.sp(name)
}