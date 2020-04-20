package cn.mycommons.simpleandroidbase.sab.base.mvp

import timber.log.Timber
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

internal class MvpKit<P : BaseMvpPresenter<V>, V : IMvpView>(private val target: Any) {

    companion object {
        private const val TOTAL_TYPE_SIZE = 2
    }

    /**
     * p v
     * p v databinding
     */
    fun mvpInstance(): Array<Any?> {
        val obj = arrayOfNulls<Any>(3)
        do {
            val genType: Type = target.javaClass.genericSuperclass
            if (genType !is ParameterizedType) {
                break
            }
            val params = genType.actualTypeArguments
            if (params.size < TOTAL_TYPE_SIZE) {
                break
            }
            try {
                if (isGetType(0, params)) {
                    val pClass = params[0] as Class<P>
                    obj[0] = pClass.newInstance()
                }
            } catch (e: Exception) {
                Timber.d("create presenter error : $e")
            }
            try {
                if (isGetType(1, params)) {
                    val v = target as V
                    obj[1] = v
                }
            } catch (e: Exception) {
                Timber.d("create view error : $e")
            }
        } while (false)
        return obj
    }

    private fun isGetType(position: Int, params: Array<Type?>): Boolean {
        return params[position] != null && params[position] is Class<*>
    }
}