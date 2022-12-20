package net.pixiv.charcoal.android.view.viewInflater

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.theme.MaterialComponentsViewInflater
import net.pixiv.charcoal.android.view.button.CharcoalButton

/**
 * Charcoal Theme が利用されている場合に、 inflate 時に一部の View を Charcoal のコンポーネントを置き換えます。
 * MaterialComponentsViewInflater を拡張して実装しています。
 */
class CharcoalViewInflater : MaterialComponentsViewInflater() {

    override fun createButton(context: Context, attrs: AttributeSet): AppCompatButton {
        return CharcoalButton(context, attrs)
    }
}
