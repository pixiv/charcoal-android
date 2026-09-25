package net.pixiv.charcoal.android.compose.m3.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

/**
 * Charcoal デザイントークンを M3 Divider の既定値として提供する。
 */
object CharcoalDividerDefaults {
    /** Divider の既定色。 */
    val color: Color @Composable @ReadOnlyComposable get() = CharcoalTheme.colorToken.border
}
