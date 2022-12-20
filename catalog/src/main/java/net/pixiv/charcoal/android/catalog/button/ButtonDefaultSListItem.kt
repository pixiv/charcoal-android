package net.pixiv.charcoal.android.catalog.button

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.databinding.ViewHolderButtonDefaultSBinding

class ButtonDefaultSListItem(private val buttonState: ButtonState) : BindableItem<ViewHolderButtonDefaultSBinding>() {
    override fun bind(viewBinding: ViewHolderButtonDefaultSBinding, position: Int) {
        viewBinding.label.text = buttonState.label
        buttonState.applyState(viewBinding.button)
    }

    override fun getLayout(): Int = R.layout.view_holder_button_default_s

    override fun initializeViewBinding(view: View): ViewHolderButtonDefaultSBinding {
        return ViewHolderButtonDefaultSBinding.bind(view)
    }
}
