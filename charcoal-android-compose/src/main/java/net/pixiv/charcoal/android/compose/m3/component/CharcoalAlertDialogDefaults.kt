package net.pixiv.charcoal.android.compose.m3.component

import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

/**
 * Charcoal デザイントークンを M3 AlertDialog の既定色として提供する。
 */
object CharcoalAlertDialogDefaults {
    /** AlertDialog の背景のデフォルト色。 */
    val containerColor: Color @Composable @ReadOnlyComposable get() = CharcoalTheme.colorToken.surface1

    /** AlertDialog タイトルのデフォルト色。 */
    val titleContentColor: Color @Composable @ReadOnlyComposable get() = CharcoalTheme.colorToken.text1

    /** AlertDialog 本文のデフォルト色。 */
    val textContentColor: Color @Composable @ReadOnlyComposable get() = CharcoalTheme.colorToken.text1
}
