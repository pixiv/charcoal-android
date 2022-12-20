package net.pixiv.charcoal.android.catalog.button

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.databinding.ViewHolderButtonLinkBinding

class ButtonLinkListItem(private val buttonState: ButtonState) :
    BindableItem<ViewHolderButtonLinkBinding>() {
    override fun bind(viewBinding: ViewHolderButtonLinkBinding, position: Int) {
        viewBinding.label.text = buttonState.label
        buttonState.applyState(viewBinding.button)
    }

    override fun getLayout(): Int = R.layout.view_holder_button_link

    override fun initializeViewBinding(view: View): ViewHolderButtonLinkBinding {
        return ViewHolderButtonLinkBinding.bind(view)
    }
}
