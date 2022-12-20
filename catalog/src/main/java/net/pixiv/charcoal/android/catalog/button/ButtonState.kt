package net.pixiv.charcoal.android.catalog.button

import android.widget.Button
import net.pixiv.charcoal.android.catalog.extension.applyPressedStateDelayed

data class ButtonState(
    val label: String = "",
    val isEnabled: Boolean = true,
    val isPressed: Boolean = false,
) {
    fun applyState(button: Button) {
        button.isEnabled = this.isEnabled
        button.applyPressedStateDelayed(this.isPressed)
    }
}
