package net.pixiv.charcoal.android.compose.m3.component

import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

/**
 * Charcoal デザイントークンを M3 TextButton の既定色として提供する。
 */
object CharcoalTextButtonDefaults {

    /**
     * 透明背景・brand テキストの Link 配色を返す。各色は引数で差し替えられる。
     * disabled 色の既定値は対応する有効時の色から算出する。
     */
    @Composable
    fun linkColors(
        containerColor: Color = Color.Transparent,
        contentColor: Color = CharcoalTheme.colorToken.brand,
    ): ButtonColors {
        return CharcoalButtonDefaults.generateCharcoalButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
        )
    }
}
