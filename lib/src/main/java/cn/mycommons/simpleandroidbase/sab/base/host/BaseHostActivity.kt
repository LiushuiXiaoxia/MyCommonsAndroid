package cn.mycommons.simpleandroidbase.sab.base.host

import android.os.Bundle
import cn.mycommons.simpleandroidbase.sab.R
import cn.mycommons.simpleandroidbase.sab.base.BaseActivity

class BaseHostActivity : BaseActivity() {

    companion object {

        const val EXTRA_FRAGMENT = "fragment"

        const val EXTRA_PARAM = "param"
    }

    private var param: BaseHostParam? = null

    override fun onCreateBefore() {
        super.onCreateBefore()

        param = intent.getSerializableExtra(EXTRA_PARAM) as BaseHostParam?
    }

    override fun onCreateAfter(savedInstanceState: Bundle?) {
        val clazz = intent.getSerializableExtra(EXTRA_FRAGMENT) as Class<out BaseHostFragment<*>>?
        if (clazz == null) {
            finish()
            return
        }

        setContentView(R.layout.sab_activity_host)

        val args = Bundle().apply { putSerializable(EXTRA_PARAM, param) }
        val fragment = clazz.newInstance().apply { arguments = args }

        supportFragmentManager.beginTransaction().add(R.id.flRoot, fragment).commit()
    }

    override fun hasBackButton(): Boolean = param?.gotoBack ?: super.hasBackButton()
}