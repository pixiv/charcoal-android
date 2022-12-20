package net.pixiv.charcoal.android.catalog.radioButton

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.wada811.viewbinding.viewBinding
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Section
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.common.groupie.ListHeaderItem
import net.pixiv.charcoal.android.catalog.common.util.CompoundButtonUtil
import net.pixiv.charcoal.android.catalog.databinding.ActivityCatalogCommonBinding
import net.pixiv.charcoal.android.catalog.extension.setSupportActionBarWithHomeButtonAndTitle

open class RadioButtonActivity : AppCompatActivity(R.layout.activity_catalog_common) {

    private val binding by viewBinding(ActivityCatalogCommonBinding::bind)

    private lateinit var adapter: GroupieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBarWithHomeButtonAndTitle(
            toolbar = binding.toolBar,
            title = "RadioButton"
        )

        adapter = GroupieAdapter()
        binding.list.adapter = adapter
        binding.list.layoutManager = GridLayoutManager(this, 2).also {
            it.spanSizeLookup = adapter.spanSizeLookup
        }

        val radioButtonStateList = CompoundButtonUtil.createCompoundButtonState()
        val section = Section().also {
            it.setHeader(ListHeaderItem("RadioButton, style = ?attr/radioButtonStyle"))
            it.addAll(radioButtonStateList.map { state -> RadioButtonListItem(state) })
        }
        adapter.add(section)
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
        fun createIntent(context: Context): Intent = Intent(context, RadioButtonActivity::class.java)
    }
}
