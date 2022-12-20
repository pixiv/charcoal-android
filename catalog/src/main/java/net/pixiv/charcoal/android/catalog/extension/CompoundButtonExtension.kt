package net.pixiv.charcoal.android.catalog.extension

import android.widget.CompoundButton
import net.pixiv.charcoal.android.catalog.common.model.CompoundButtonState

fun CompoundButton.applyState(compoundButtonState: CompoundButtonState) {
    this.text = compoundButtonState.text
    this.isEnabled = compoundButtonState.enabled
    this.isChecked = compoundButtonState.isChecked
    this.applyPressedStateDelayed(compoundButtonState.isPressed)
}
