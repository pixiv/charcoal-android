package net.pixiv.charcoal.android.catalog.button

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.databinding.ViewHolderButtonNavigationMBinding

class ButtonNavigationMListItem(private val buttonState: ButtonState) : BindableItem<ViewHolderButtonNavigationMBinding>() {
    override fun bind(viewBinding: ViewHolderButtonNavigationMBinding, position: Int) {
        viewBinding.label.text = buttonState.label
        buttonState.applyState(viewBinding.button)
    }

    override fun getLayout(): Int = R.layout.view_holder_button_navigation_m

    override fun initializeViewBinding(view: View): ViewHolderButtonNavigationMBinding {
        return ViewHolderButtonNavigationMBinding.bind(view)
    }
}
