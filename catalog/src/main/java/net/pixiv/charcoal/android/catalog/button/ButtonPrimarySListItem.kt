package net.pixiv.charcoal.android.catalog.button

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.databinding.ViewHolderButtonPrimarySBinding

class ButtonPrimarySListItem(private val buttonState: ButtonState) : BindableItem<ViewHolderButtonPrimarySBinding>() {
    override fun bind(viewBinding: ViewHolderButtonPrimarySBinding, position: Int) {
        viewBinding.label.text = buttonState.label
        buttonState.applyState(viewBinding.button)
    }

    override fun getLayout(): Int = R.layout.view_holder_button_primary_s

    override fun initializeViewBinding(view: View): ViewHolderButtonPrimarySBinding {
        return ViewHolderButtonPrimarySBinding.bind(view)
    }
}
