package net.pixiv.charcoal.android.catalog

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.wada811.viewbinding.viewBinding
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem
import net.pixiv.charcoal.android.catalog.button.ButtonActivity
import net.pixiv.charcoal.android.catalog.charcoalSwitch.CharcoalSwitchActivity
import net.pixiv.charcoal.android.catalog.checkBox.CheckBoxActivity
import net.pixiv.charcoal.android.catalog.compose.CatalogComposeActivity
import net.pixiv.charcoal.android.catalog.databinding.ActivityCatalogMainBinding
import net.pixiv.charcoal.android.catalog.databinding.ViewHolderCatalogPageListBinding
import net.pixiv.charcoal.android.catalog.dialog.DialogActivity
import net.pixiv.charcoal.android.catalog.radioButton.RadioButtonActivity
import net.pixiv.charcoal.android.catalog.tabLayout.TabLayoutActivity
import net.pixiv.charcoal.android.catalog.toolbar.ToolbarActivity
import net.pixiv.charcoal.android.catalog.typography.TypographyActivity

class CatalogMainActivity : AppCompatActivity(R.layout.activity_catalog_main) {

    private val binding by viewBinding(ActivityCatalogMainBinding::bind)
    private lateinit var adapter: GroupieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog_main)

        setSupportActionBar(binding.toolBar)
        supportActionBar?.let {
            it.title = getString(R.string.app_name)
        }

        initSwitcher()
        initList()
    }

    private fun initList() {
        adapter = GroupieAdapter()
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.list.addItemDecoration(dividerItemDecoration)

        adapter.update(
            listOf(
                CatalogPageListItem(CatalogPage.Button),
                CatalogPageListItem(CatalogPage.RadioButton),
                CatalogPageListItem(CatalogPage.CheckBox),
                CatalogPageListItem(CatalogPage.CharcoalSwitch),
                CatalogPageListItem(CatalogPage.Dialog),
                CatalogPageListItem(CatalogPage.Typography),
                CatalogPageListItem(CatalogPage.Toolbar),
                CatalogPageListItem(CatalogPage.TabLayout),
                CatalogPageListItem(CatalogPage.Compose),
            )
        )

        adapter.setOnItemClickListener { item, _ ->
            when ((item as CatalogPageListItem).catalogPage) {
                CatalogPage.Typography -> startActivity(TypographyActivity.createIntent(this))
                CatalogPage.RadioButton -> startActivity(RadioButtonActivity.createIntent(this))
                CatalogPage.CheckBox -> startActivity(CheckBoxActivity.createIntent(this))
                CatalogPage.CharcoalSwitch -> startActivity(CharcoalSwitchActivity.createIntent(this))
                CatalogPage.Button -> startActivity(ButtonActivity.createIntent(this))
                CatalogPage.Dialog -> startActivity(DialogActivity.createIntent(this))
                CatalogPage.Toolbar -> startActivity(ToolbarActivity.createIntent(this))
                CatalogPage.TabLayout -> startActivity(TabLayoutActivity.createIntent(this))
                CatalogPage.Compose -> {
                    startActivity(CatalogComposeActivity.createIntent(this))
                }
            }
        }
    }

    private fun initSwitcher() {
        binding.switcher.isChecked =
            AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
        binding.switcher.setOnCheckedChangeListener { _, isChecked ->
            val state = if (isChecked) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_NO
            }

            AppCompatDelegate.setDefaultNightMode(state)
        }
    }

    class CatalogPageListItem(val catalogPage: CatalogPage) :
        BindableItem<ViewHolderCatalogPageListBinding>() {
        override fun bind(viewBinding: ViewHolderCatalogPageListBinding, position: Int) {
            viewBinding.label.text = catalogPage.title
        }

        override fun getLayout(): Int = R.layout.view_holder_catalog_page_list
        override fun initializeViewBinding(view: View): ViewHolderCatalogPageListBinding {
            return ViewHolderCatalogPageListBinding.bind(view)
        }
    }

    sealed class CatalogPage(val title: String) {
        object Typography : CatalogPage("Typography")
        object RadioButton : CatalogPage("RadioButton")
        object CheckBox : CatalogPage("CheckBox")
        object CharcoalSwitch : CatalogPage("CharcoalSwitch")
        object Button : CatalogPage("Button")
        object Toolbar : CatalogPage("Toolbar")
        object Dialog : CatalogPage("Dialog")
        object TabLayout : CatalogPage("TabLayout")
        object Compose : CatalogPage("Jetpack Compose")
    }
}
