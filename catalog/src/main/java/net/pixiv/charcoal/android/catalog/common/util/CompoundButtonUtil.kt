package net.pixiv.charcoal.android.catalog.common.util

import net.pixiv.charcoal.android.catalog.common.model.CompoundButtonState

object CompoundButtonUtil {
    fun createCompoundButtonState(): List<CompoundButtonState> {
        return listOf(
            CompoundButtonState(text = "enabled"),
            CompoundButtonState(text = "enabled, pressed", isPressed = true),
            CompoundButtonState(text = "enabled, checked", isChecked = true),
            CompoundButtonState(text = "enabled, checked, pressed", isChecked = true, isPressed = true),
            CompoundButtonState(text = "disabled", enabled = false),
            CompoundButtonState(text = "disabled, checked", isChecked = true, enabled = false),
        )
    }
}
