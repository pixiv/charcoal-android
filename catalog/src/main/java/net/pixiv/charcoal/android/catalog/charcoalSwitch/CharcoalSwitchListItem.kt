package net.pixiv.charcoal.android.catalog.charcoalSwitch

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.common.model.CompoundButtonState
import net.pixiv.charcoal.android.catalog.databinding.ViewHolderCharcoalSwitchListItemBinding
import net.pixiv.charcoal.android.catalog.extension.applyState

class CharcoalSwitchListItem(
    private val compoundButtonState: CompoundButtonState
) : BindableItem<ViewHolderCharcoalSwitchListItemBinding>() {
    override fun bind(viewBinding: ViewHolderCharcoalSwitchListItemBinding, position: Int) {
        viewBinding.switcher.applyState(compoundButtonState)
    }

    override fun getLayout(): Int = R.layout.view_holder_charcoal_switch_list_item

    override fun initializeViewBinding(view: View): ViewHolderCharcoalSwitchListItemBinding {
        return ViewHolderCharcoalSwitchListItemBinding.bind(view)
    }
}
