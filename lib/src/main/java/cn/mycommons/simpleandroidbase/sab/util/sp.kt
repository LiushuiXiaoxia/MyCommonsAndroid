@file:JvmName("SpKit")

package cn.mycommons.simpleandroidbase.sab.util

import android.content.Context
import android.content.SharedPreferences
import android.support.v4.app.Fragment
import com.google.gson.GsonBuilder
import java.lang.reflect.Type

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

    fun putObject(key: String, value: Any?)
    fun <T> getObject(key: String, clazz: Type): T?

    fun getAll(): Map<String, *>

    fun removeAll()
    fun remove(key: String)

    fun contains(key: String): Boolean
}

internal class DefaultSp(private val preferences: SharedPreferences) : SpPlus {

    private val gson = GsonBuilder().disableHtmlEscaping().create()

    override fun putInt(key: String, value: Int) {
        preferences.edit().putInt(key, value).apply()
    }

    override fun getInt(key: String, value: Int): Int {
        return preferences.getInt(key, value)
    }

    override fun putLong(key: String, value: Long) {
        preferences.edit().putLong(key, value).apply()
    }

    override fun getLong(key: String, value: Long): Long {
        return preferences.getLong(key, value)
    }

    override fun putFloat(key: String, value: Float) {
        preferences.edit().putFloat(key, value).apply()
    }

    override fun getFloat(key: String, value: Float): Float {
        return preferences.getFloat(key, value)
    }

    override fun putString(key: String, value: String?) {
        preferences.edit().putString(key, value).apply()
    }

    override fun getString(key: String, value: String?): String? {
        return preferences.getString(key, value)
    }

    override fun removeAll() {
        preferences.edit().clear().apply()
    }

    override fun remove(key: String) {
        preferences.edit().remove(key).apply()
    }

    override fun contains(key: String): Boolean {
        return preferences.contains(key)
    }

    override fun putObject(key: String, value: Any?) {
        putString(key, gson.toJson(value))
    }

    override fun <T> getObject(key: String, clazz: Type): T? {
        try {
            val json = getString(key, null)
            if (json != null) {
                return gson.fromJson(json, clazz)
            }
        } catch (e: Exception) {
        }
        return null
    }

    override fun getAll(): Map<String, *> {
        return preferences.all
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