package net.pixiv.charcoal.android.catalog.radioButton

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.common.model.CompoundButtonState
import net.pixiv.charcoal.android.catalog.databinding.ViewHolderRadioButtonListItemBinding
import net.pixiv.charcoal.android.catalog.extension.applyState

class RadioButtonListItem(private val compoundButtonState: CompoundButtonState) : BindableItem<ViewHolderRadioButtonListItemBinding>() {
    override fun bind(viewBinding: ViewHolderRadioButtonListItemBinding, position: Int) {
        viewBinding.radiobutton.applyState(compoundButtonState)
    }

    override fun getLayout(): Int = R.layout.view_holder_radio_button_list_item

    override fun initializeViewBinding(view: View): ViewHolderRadioButtonListItemBinding {
        return ViewHolderRadioButtonListItemBinding.bind(view)
    }
}
