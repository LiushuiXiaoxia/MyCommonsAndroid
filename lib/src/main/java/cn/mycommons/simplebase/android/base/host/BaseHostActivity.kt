package cn.mycommons.simplebase.android.base.host

import android.content.Context
import android.content.Intent
import android.os.Bundle
import cn.mycommons.simplebase.android.R
import cn.mycommons.simplebase.android.base.BaseActivity

class BaseHostActivity : BaseActivity() {

    companion object {

        private const val EXTRA_FRAGMENT = "fragment"
        const val EXTRA_PARAM = "param"

        fun <T : BaseHostFragment<*>> startFragment(
            context: Context,
            clazz: Class<T>,
            param: BaseHostParam = EmptyParam()
        ) {
            Intent(context, BaseHostActivity::class.java).apply {
                putExtra(EXTRA_FRAGMENT, clazz)
                putExtra(EXTRA_PARAM, param)
                context.startActivity(this)
            }
        }
    }

    private var param: BaseHostParam? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        val clazz = intent.getSerializableExtra(EXTRA_FRAGMENT) as Class<out BaseHostFragment<*>>?
        param = intent.getSerializableExtra(EXTRA_PARAM) as BaseHostParam?
        if (clazz == null) {
            finish()
            return
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)

        if (param?.title?.isNotBlank() == true) {
            title = param?.title
        }

        val args = Bundle().apply { putSerializable(EXTRA_PARAM, param) }
        val fragment = clazz.newInstance().apply { arguments = args }

        supportFragmentManager.beginTransaction()
            .add(R.id.flRoot, fragment)
            .commit()
    }

    override fun hasBackButton(): Boolean = param?.gotoBack ?: super.hasBackButton()
}