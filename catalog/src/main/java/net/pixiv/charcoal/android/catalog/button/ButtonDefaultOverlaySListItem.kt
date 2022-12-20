package net.pixiv.charcoal.android.catalog.button

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.databinding.ViewHolderButtonDefaultOverlaySBinding

class ButtonDefaultOverlaySListItem(private val buttonState: ButtonState) :
    BindableItem<ViewHolderButtonDefaultOverlaySBinding>() {
    override fun bind(viewBinding: ViewHolderButtonDefaultOverlaySBinding, position: Int) {
        viewBinding.label.text = buttonState.label
        buttonState.applyState(viewBinding.button)
    }

    override fun getLayout(): Int = R.layout.view_holder_button_default_overlay_s

    override fun initializeViewBinding(view: View): ViewHolderButtonDefaultOverlaySBinding {
        return ViewHolderButtonDefaultOverlaySBinding.bind(view)
    }
}
