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
 * ## contentColorFor の解決結果は Charcoal の仕様として扱う
 *
 * Charcoal は M3 より色の段階が少ないため、複数の M3 ロールに同じ色を割り当てている
 * （例: background / surface / surfaceContainer 系はすべて surface1）。
 * M3 の `contentColorFor(color)` は色の値で照合し、先に一致したロールの on 色を返すため、
 * 同じ色を持つロール群では「照合順で最初のロールの on 色」だけが返る。
 * この結果を個別に調整することはせず、**「Charcoal のどの色を背景にしたら既定の文字色が何になるか」の対応表**
 * として仕様に固定する。表と違う文字色にしたい場合は、呼び出し側で contentColor / color を明示する。
 *
 * | 背景に使う Charcoal の色 | 一致する M3 ロール（照合順） | 既定の文字色 |
 * |---|---|---|
 * | brand | primary / secondary / tertiary | text5 |
 * | background1 = surface1 | background / primaryContainer / surface / surfaceContainer / surfaceContainerLow / surfaceContainerLowest | text2 |
 * | assertive | error | text5 |
 * | surface3Solid | secondaryContainer / tertiaryContainer / surfaceVariant / surfaceContainerHigh / surfaceContainerHighest（ダークは inverseSurface も同値） | text2 |
 * | errorContainer | errorContainer | assertive |
 * | surface6Solid（ライトのみ別値） | inverseSurface | text5（ダークは surface3Solid と同値のため text2） |
 * | 上記以外 | 一致なし | 親の LocalContentColor を引き継ぐ |
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
