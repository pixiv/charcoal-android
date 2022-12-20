package net.pixiv.charcoal.android.catalog.button

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.databinding.ViewHolderButtonDefaultMBinding

class ButtonDefaultMListItem(private val buttonState: ButtonState) : BindableItem<ViewHolderButtonDefaultMBinding>() {
    override fun bind(viewBinding: ViewHolderButtonDefaultMBinding, position: Int) {
        viewBinding.label.text = buttonState.label
        buttonState.applyState(viewBinding.button)
    }

    override fun getLayout(): Int = R.layout.view_holder_button_default_m

    override fun initializeViewBinding(view: View): ViewHolderButtonDefaultMBinding {
        return ViewHolderButtonDefaultMBinding.bind(view)
    }
}
