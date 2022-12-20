package net.pixiv.charcoal.android.catalog.common.groupie

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.databinding.ViewHolderListHeaderBinding

class ListHeaderItem(private val text: String) : BindableItem<ViewHolderListHeaderBinding>() {
    override fun bind(viewBinding: ViewHolderListHeaderBinding, position: Int) {
        viewBinding.headerText.text = text
    }

    override fun getSpanSize(spanCount: Int, position: Int): Int {
        return 2
    }

    override fun getLayout(): Int = R.layout.view_holder_list_header

    override fun initializeViewBinding(view: View): ViewHolderListHeaderBinding {
        return ViewHolderListHeaderBinding.bind(view)
    }
}
