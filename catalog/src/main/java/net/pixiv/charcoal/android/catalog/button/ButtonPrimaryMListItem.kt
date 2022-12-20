package net.pixiv.charcoal.android.catalog.button

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.databinding.ViewHolderButtonPrimaryMBinding

class ButtonPrimaryMListItem(private val buttonState: ButtonState) : BindableItem<ViewHolderButtonPrimaryMBinding>() {
    override fun bind(viewBinding: ViewHolderButtonPrimaryMBinding, position: Int) {
        viewBinding.label.text = buttonState.label
        buttonState.applyState(viewBinding.button)
    }

    override fun getLayout(): Int = R.layout.view_holder_button_primary_m

    override fun initializeViewBinding(view: View): ViewHolderButtonPrimaryMBinding {
        return ViewHolderButtonPrimaryMBinding.bind(view)
    }
}
