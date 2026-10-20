package net.pixiv.charcoal.android.compose.m3.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import net.pixiv.charcoal.android.compose.theme.CharcoalColorPalette
import net.pixiv.charcoal.android.compose.theme.CharcoalColorToken

/**
 * Charcoal のカラートークンから M3 [ColorScheme] を組み立てる
 *
 * `contentColorFor` は表のとおりの値を返す。
 * 表と違う文字色にしたい場合は、呼び出し側で contentColor / color を明示する。
 *
 * | 背景に使う Charcoal の色 | 既定の文字色 |
 * |---|---|
 * | brand | text5 |
 * | background1, surface1 | text2 |
 * | assertive | text5 |
 * | 上記以外 | 親の LocalContentColor を引き継ぐ |
 *
 * @param isDarkTheme true なら未割り当てロールの既定値に [darkColorScheme] を、false なら [lightColorScheme] を使う
 * @param colorToken 元になる Charcoal のカラートークン
 * @param adjustment Charcoal に無く M3 が要求する不透明色。既定は [isDarkTheme] に応じたもの
 */
internal fun charcoalM3ColorScheme(
    isDarkTheme: Boolean,
    colorToken: CharcoalColorToken,
    adjustment: CharcoalM3AdjustmentColor =
        if (isDarkTheme) darkCharcoalM3AdjustmentColor() else lightCharcoalM3AdjustmentColor(),
): ColorScheme {
    return if (isDarkTheme) {
        darkColorScheme(
            primary = colorToken.brand,
            onPrimary = colorToken.text5,
            primaryContainer = colorToken.surface1,
            onPrimaryContainer = colorToken.text1,
            inversePrimary = colorToken.brand,
            secondary = colorToken.brand,
            onSecondary = colorToken.text5,
            secondaryContainer = adjustment.surface3Solid,
            onSecondaryContainer = colorToken.text2,
            tertiary = colorToken.brand,
            onTertiary = colorToken.text5,
            tertiaryContainer = adjustment.surface3Solid,
            onTertiaryContainer = colorToken.text2,
            background = colorToken.background1,
            onBackground = colorToken.text2,
            surface = colorToken.surface1,
            onSurface = colorToken.text1,
            surfaceVariant = adjustment.surface3Solid,
            onSurfaceVariant = colorToken.text2,
            surfaceTint = Color.Transparent,
            inverseSurface = adjustment.surface6Solid,
            inverseOnSurface = colorToken.text5,
            surfaceContainerLowest = colorToken.surface1,
            surfaceContainerLow = colorToken.surface1,
            surfaceContainer = colorToken.surface1,
            surfaceContainerHigh = adjustment.surface3Solid,
            surfaceContainerHighest = adjustment.surface3Solid,
            error = colorToken.assertive,
            onError = colorToken.text5,
            errorContainer = adjustment.errorContainer,
            onErrorContainer = colorToken.assertive,
            outline = colorToken.text3,
            outlineVariant = colorToken.border,
            scrim = CharcoalColorPalette.black,
        )
    } else {
        lightColorScheme(
            primary = colorToken.brand,
            onPrimary = colorToken.text5,
            primaryContainer = colorToken.surface1,
            onPrimaryContainer = colorToken.text1,
            inversePrimary = colorToken.brand,
            secondary = colorToken.brand,
            onSecondary = colorToken.text5,
            secondaryContainer = adjustment.surface3Solid,
            onSecondaryContainer = colorToken.text2,
            tertiary = colorToken.brand,
            onTertiary = colorToken.text5,
            tertiaryContainer = adjustment.surface3Solid,
            onTertiaryContainer = colorToken.text2,
            background = colorToken.background1,
            onBackground = colorToken.text2,
            surface = colorToken.surface1,
            onSurface = colorToken.text1,
            surfaceVariant = adjustment.surface3Solid,
            onSurfaceVariant = colorToken.text2,
            surfaceTint = Color.Transparent,
            inverseSurface = adjustment.surface6Solid,
            inverseOnSurface = colorToken.text5,
            surfaceContainerLowest = colorToken.surface1,
            surfaceContainerLow = colorToken.surface1,
            surfaceContainer = colorToken.surface1,
            surfaceContainerHigh = adjustment.surface3Solid,
            surfaceContainerHighest = adjustment.surface3Solid,
            error = colorToken.assertive,
            onError = colorToken.text5,
            errorContainer = adjustment.errorContainer,
            onErrorContainer = colorToken.assertive,
            outline = colorToken.text3,
            outlineVariant = colorToken.border,
            scrim = CharcoalColorPalette.black,
        )
    }
}
