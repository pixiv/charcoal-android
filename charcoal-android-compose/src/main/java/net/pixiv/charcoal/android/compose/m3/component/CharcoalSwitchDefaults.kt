package net.pixiv.charcoal.android.compose.m3.component

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import net.pixiv.charcoal.android.compose.extension.overlayDisabledAlpha
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

/**
 * Charcoal デザイントークンを M3 Switch のデフォルト色として提供する。
 */
object CharcoalSwitchDefaults {

    /**
     * Charcoal トークンを既定値にした [SwitchColors] を返す。各色は引数で差し替えられる。
     * disabled 色の既定値は対応する有効時の色から算出する。
     */
    @Composable
    fun colors(
        checkedThumbColor: Color = CharcoalTheme.colorToken.text5,
        checkedTrackColor: Color = CharcoalTheme.colorToken.brand,
        checkedBorderColor: Color = CharcoalTheme.colorToken.brand,
        checkedIconColor: Color = Color.Transparent,
        uncheckedThumbColor: Color = CharcoalTheme.colorToken.text3,
        uncheckedTrackColor: Color = CharcoalTheme.colorToken.surface3
            .compositeOver(CharcoalTheme.colorToken.surface1),
        uncheckedBorderColor: Color = CharcoalTheme.colorToken.text3,
        uncheckedIconColor: Color = Color.Transparent,
        disabledCheckedThumbColor: Color = checkedThumbColor
            .overlayDisabledAlpha()
            .compositeOver(CharcoalTheme.colorToken.surface1),
        disabledCheckedTrackColor: Color = checkedTrackColor
            .overlayDisabledAlpha()
            .compositeOver(CharcoalTheme.colorToken.surface1),
        disabledCheckedBorderColor: Color = checkedBorderColor
            .overlayDisabledAlpha()
            .compositeOver(CharcoalTheme.colorToken.surface1),
        disabledCheckedIconColor: Color = checkedIconColor,
        disabledUncheckedThumbColor: Color = uncheckedThumbColor
            .overlayDisabledAlpha()
            .compositeOver(CharcoalTheme.colorToken.surface1),
        disabledUncheckedTrackColor: Color = uncheckedTrackColor
            .overlayDisabledAlpha()
            .compositeOver(CharcoalTheme.colorToken.surface1),
        disabledUncheckedBorderColor: Color = uncheckedBorderColor
            .overlayDisabledAlpha()
            .compositeOver(CharcoalTheme.colorToken.surface1),
        disabledUncheckedIconColor: Color = uncheckedIconColor,
    ): SwitchColors = SwitchDefaults.colors(
        checkedThumbColor = checkedThumbColor,
        checkedTrackColor = checkedTrackColor,
        checkedBorderColor = checkedBorderColor,
        checkedIconColor = checkedIconColor,
        uncheckedThumbColor = uncheckedThumbColor,
        uncheckedTrackColor = uncheckedTrackColor,
        uncheckedBorderColor = uncheckedBorderColor,
        uncheckedIconColor = uncheckedIconColor,
        disabledCheckedThumbColor = disabledCheckedThumbColor,
        disabledCheckedTrackColor = disabledCheckedTrackColor,
        disabledCheckedBorderColor = disabledCheckedBorderColor,
        disabledCheckedIconColor = disabledCheckedIconColor,
        disabledUncheckedThumbColor = disabledUncheckedThumbColor,
        disabledUncheckedTrackColor = disabledUncheckedTrackColor,
        disabledUncheckedBorderColor = disabledUncheckedBorderColor,
        disabledUncheckedIconColor = disabledUncheckedIconColor,
    )
}
