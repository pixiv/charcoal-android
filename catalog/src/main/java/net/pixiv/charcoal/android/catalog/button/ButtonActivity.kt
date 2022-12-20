package net.pixiv.charcoal.android.catalog.button

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
import net.pixiv.charcoal.android.catalog.databinding.ActivityCatalogCommonBinding
import net.pixiv.charcoal.android.catalog.extension.setSupportActionBarWithHomeButtonAndTitle

open class ButtonActivity : AppCompatActivity(R.layout.activity_catalog_common) {

    private val binding by viewBinding(ActivityCatalogCommonBinding::bind)

    private lateinit var adapter: GroupieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBarWithHomeButtonAndTitle(
            toolbar = binding.toolBar,
            title = "Button"
        )

        adapter = GroupieAdapter()
        binding.list.adapter = adapter
        binding.list.layoutManager = GridLayoutManager(this, 2).also {
            it.spanSizeLookup = adapter.spanSizeLookup
        }

        val section = Section().also {
            it.setHeader(ListHeaderItem("Button, style = Widget.Charcoal.Button.Primary.M"))
            it.add(ButtonPrimaryMListItem(ButtonState(label = "default")))
            it.add(ButtonPrimaryMListItem(ButtonState(label = "isPressed = true", isPressed = true)))
            it.add(ButtonPrimaryMListItem(ButtonState(label = "isEnabled = false", isEnabled = false)))
            it.add(ListHeaderItem("Button, style = Widget.Charcoal.Button.Primary.S"))
            it.add(ButtonPrimarySListItem(ButtonState(label = "default")))
            it.add(ButtonPrimarySListItem(ButtonState(label = "isPressed = true", isPressed = true)))
            it.add(ButtonPrimarySListItem(ButtonState(label = "isEnabled = false", isEnabled = false)))
            it.add(ListHeaderItem("Button, style = Widget.Charcoal.Button.Default.M"))
            it.add(ButtonDefaultMListItem(ButtonState(label = "default")))
            it.add(ButtonDefaultMListItem(ButtonState(label = "isPressed = true", isPressed = true)))
            it.add(ButtonDefaultMListItem(ButtonState(label = "isEnabled = false", isEnabled = false)))
            it.add(ListHeaderItem("Button, style = Widget.Charcoal.Button.Default.S"))
            it.add(ButtonDefaultSListItem(ButtonState(label = "default")))
            it.add(ButtonDefaultSListItem(ButtonState(label = "isPressed = true", isPressed = true)))
            it.add(ButtonDefaultSListItem(ButtonState(label = "isEnabled = false", isEnabled = false)))
            it.add(ListHeaderItem("Button, style = Widget.Charcoal.Button.DefaultOverlay.M"))
            it.add(ButtonDefaultOverlayMListItem(ButtonState(label = "default")))
            it.add(ButtonDefaultOverlayMListItem(ButtonState(label = "isPressed = true", isPressed = true)))
            it.add(ButtonDefaultOverlayMListItem(ButtonState(label = "isEnabled = false", isEnabled = false)))
            it.add(ListHeaderItem("Button, style = Widget.Charcoal.Button.DefaultOverlay.S"))
            it.add(ButtonDefaultOverlaySListItem(ButtonState(label = "default")))
            it.add(ButtonDefaultOverlaySListItem(ButtonState(label = "isPressed = true", isPressed = true)))
            it.add(ButtonDefaultOverlaySListItem(ButtonState(label = "isEnabled = false", isEnabled = false)))
            it.add(ListHeaderItem("Button, style = Widget.Charcoal.Button.Navigation.M"))
            it.add(ButtonNavigationMListItem(ButtonState(label = "default")))
            it.add(ButtonNavigationMListItem(ButtonState(label = "isPressed = true", isPressed = true)))
            it.add(ListHeaderItem("Button, style = Widget.Charcoal.Button.Navigation.S"))
            it.add(ButtonNavigationSListItem(ButtonState(label = "default")))
            it.add(ButtonNavigationSListItem(ButtonState(label = "isPressed = true", isPressed = true)))
            it.add(ListHeaderItem("Button, style = Widget.Charcoal.Button.Link"))
            it.add(ButtonLinkListItem(ButtonState(label = "default")))
            it.add(ButtonLinkListItem(ButtonState(label = "isPressed = true", isPressed = true)))
            it.add(ButtonLinkListItem(ButtonState(label = "isEnabled = false", isEnabled = false)))
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
        fun createIntent(context: Context): Intent = Intent(context, ButtonActivity::class.java)
    }
}
