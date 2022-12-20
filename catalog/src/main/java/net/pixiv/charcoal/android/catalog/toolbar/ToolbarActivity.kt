package net.pixiv.charcoal.android.catalog.toolbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.wada811.viewbinding.viewBinding
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.databinding.ActivityToolbarBinding
import net.pixiv.charcoal.android.catalog.extension.setSupportActionBarWithHomeButtonAndTitle

class ToolbarActivity : AppCompatActivity(R.layout.activity_toolbar) {
    private val binding by viewBinding(ActivityToolbarBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBarWithHomeButtonAndTitle(binding.toolBar, "Toolbar")

        binding.toolBarDefault.let {
            it.title = "Default"
            it.subtitle = "subtitle"
            it.navigationIcon = AppCompatResources.getDrawable(it.context, R.drawable.abc_ic_ab_back_material)
            it.setNavigationOnClickListener { }
            it.inflateMenu(R.menu.topappbar_catalog_menu_default)
        }

        binding.toolBarOverlay.let {
            it.title = "Overlay"
            it.subtitle = "subtitle"
            it.navigationIcon = AppCompatResources.getDrawable(it.context, R.drawable.abc_ic_ab_back_material)
            it.setNavigationOnClickListener { }
            it.inflateMenu(R.menu.topappbar_catalog_menu_overlay)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, ToolbarActivity::class.java)
        }
    }
}
