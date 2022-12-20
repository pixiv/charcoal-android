package net.pixiv.charcoal.android.catalog.checkBox

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.common.model.CompoundButtonState
import net.pixiv.charcoal.android.catalog.databinding.ViewHolderCheckboxListItemBinding
import net.pixiv.charcoal.android.catalog.extension.applyState

class CheckBoxListItem(private val compoundButtonState: CompoundButtonState) : BindableItem<ViewHolderCheckboxListItemBinding>() {
    override fun bind(viewBinding: ViewHolderCheckboxListItemBinding, position: Int) {
        viewBinding.checkbox.applyState(compoundButtonState)
    }

    override fun getLayout(): Int = R.layout.view_holder_checkbox_list_item

    override fun initializeViewBinding(view: View): ViewHolderCheckboxListItemBinding {
        return ViewHolderCheckboxListItemBinding.bind(view)
    }
}
