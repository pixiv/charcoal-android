package net.pixiv.charcoal.android.catalog.tabLayout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.wada811.viewbinding.viewBinding
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.databinding.ActivityTabLayoutBinding
import net.pixiv.charcoal.android.catalog.extension.setSupportActionBarWithHomeButtonAndTitle

class TabLayoutActivity : AppCompatActivity(R.layout.activity_tab_layout) {

    private val binding by viewBinding(ActivityTabLayoutBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBarWithHomeButtonAndTitle(
            toolbar = binding.toolBar,
            title = "TabLayout"
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, TabLayoutActivity::class.java)
        }
    }
}
