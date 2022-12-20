package net.pixiv.charcoal.android.catalog.button

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.databinding.ViewHolderButtonDefaultOverlayMBinding

class ButtonDefaultOverlayMListItem(private val buttonState: ButtonState) :
    BindableItem<ViewHolderButtonDefaultOverlayMBinding>() {
    override fun bind(viewBinding: ViewHolderButtonDefaultOverlayMBinding, position: Int) {
        viewBinding.label.text = buttonState.label
        buttonState.applyState(viewBinding.button)
    }

    override fun getLayout(): Int = R.layout.view_holder_button_default_overlay_m

    override fun initializeViewBinding(view: View): ViewHolderButtonDefaultOverlayMBinding {
        return ViewHolderButtonDefaultOverlayMBinding.bind(view)
    }
}
