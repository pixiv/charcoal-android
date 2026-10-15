package net.pixiv.charcoal.android.compose.m3.component

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import net.pixiv.charcoal.android.compose.extension.overlayDisabledAlpha
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

/**
 * Charcoal デザイントークンを M3 Checkbox のデフォルト色として提供する。
 */
object CharcoalCheckboxDefaults {

    /**
     * Charcoal トークンを既定値にした [CheckboxColors] を返す。各色は引数で差し替えられる。
     * disabled 色の既定値は対応する有効時の色から算出する。
     */
    @Composable
    fun colors(
        checkedColor: Color = CharcoalTheme.colorToken.brand,
        uncheckedColor: Color = CharcoalTheme.colorToken.text3,
        checkmarkColor: Color = CharcoalTheme.colorToken.text5,
        disabledCheckedColor: Color = checkedColor
            .overlayDisabledAlpha()
            .compositeOver(CharcoalTheme.colorToken.surface1),
        disabledUncheckedColor: Color = uncheckedColor
            .overlayDisabledAlpha()
            .compositeOver(CharcoalTheme.colorToken.surface1),
        disabledIndeterminateColor: Color = checkedColor
            .overlayDisabledAlpha()
            .compositeOver(CharcoalTheme.colorToken.surface1),
    ): CheckboxColors = CheckboxDefaults.colors(
        checkedColor = checkedColor,
        uncheckedColor = uncheckedColor,
        checkmarkColor = checkmarkColor,
        disabledCheckedColor = disabledCheckedColor,
        disabledUncheckedColor = disabledUncheckedColor,
        disabledIndeterminateColor = disabledIndeterminateColor,
    )
}
