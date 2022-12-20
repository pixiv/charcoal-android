package net.pixiv.charcoal.android.catalog.checkBox

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

open class CheckBoxActivity : AppCompatActivity(R.layout.activity_catalog_common) {

    private val binding by viewBinding(ActivityCatalogCommonBinding::bind)

    private lateinit var adapter: GroupieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBarWithHomeButtonAndTitle(
            toolbar = binding.toolBar,
            title = "CheckBox"
        )

        adapter = GroupieAdapter()
        binding.list.adapter = adapter
        binding.list.layoutManager = GridLayoutManager(this, 2).also {
            it.spanSizeLookup = adapter.spanSizeLookup
        }

        val checkBoxStateList = CompoundButtonUtil.createCompoundButtonState()
        val section = Section().also {
            it.setHeader(ListHeaderItem("CheckBox, style = ?attr/checkboxStyle"))
            it.addAll(checkBoxStateList.map { state -> CheckBoxListItem(state) })
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
        fun createIntent(context: Context): Intent = Intent(context, CheckBoxActivity::class.java)
    }
}
