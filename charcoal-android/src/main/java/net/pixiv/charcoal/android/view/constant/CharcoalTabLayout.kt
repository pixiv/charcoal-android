package net.pixiv.charcoal.android.view.constant

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.tabs.TabLayout
import net.pixiv.charcoal.android.R

class CharcoalTabLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : TabLayout(context, attrs) {

    override fun addTab(tab: Tab, position: Int, setSelected: Boolean) {
        val charcoalTab = tab.setCustomView(R.layout.view_charcoal_tab)
        super.addTab(charcoalTab, position, setSelected)
    }
}