package net.pixiv.charcoal.android.catalog.button

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.databinding.ViewHolderButtonNavigationSBinding

class ButtonNavigationSListItem(private val buttonState: ButtonState) : BindableItem<ViewHolderButtonNavigationSBinding>() {
    override fun bind(viewBinding: ViewHolderButtonNavigationSBinding, position: Int) {
        viewBinding.label.text = buttonState.label
        buttonState.applyState(viewBinding.button)
    }

    override fun getLayout(): Int = R.layout.view_holder_button_navigation_s

    override fun initializeViewBinding(view: View): ViewHolderButtonNavigationSBinding {
        return ViewHolderButtonNavigationSBinding.bind(view)
    }
}
