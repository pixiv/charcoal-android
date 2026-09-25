package net.pixiv.charcoal.android.compose.m3.component

import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import net.pixiv.charcoal.android.compose.extension.overlayDisabledAlpha
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

/**
 * Charcoal デザイントークンを M3 RadioButton のデフォルト色として提供する。
 */
object CharcoalRadioButtonDefaults {

    /**
     * Charcoal トークンを既定値にした [RadioButtonColors] を返す。各色は引数で差し替えられる。
     * disabled 色の既定値は対応する有効時の色から算出する。
     */
    @Composable
    fun colors(
        selectedColor: Color = CharcoalTheme.colorToken.brand,
        unselectedColor: Color = CharcoalTheme.colorToken.text3,
        disabledSelectedColor: Color = selectedColor.overlayDisabledAlpha(),
        disabledUnselectedColor: Color = unselectedColor.overlayDisabledAlpha(),
    ): RadioButtonColors = RadioButtonDefaults.colors(
        selectedColor = selectedColor,
        unselectedColor = unselectedColor,
        disabledSelectedColor = disabledSelectedColor,
        disabledUnselectedColor = disabledUnselectedColor,
    )
}
