package net.pixiv.charcoal.android.compose.m3.theme

import androidx.compose.material3.Typography
import net.pixiv.charcoal.android.compose.theme.CharcoalTypography

/**
 * Charcoal のタイポグラフィを M3 の [Typography] ロールに割り当てる。
 *
 * display 系と headlineLarge / headlineMedium は Charcoal に対応サイズがないため M3 既定のまま。
 *
 * @param typography 元になる Charcoal のタイポグラフィ
 */
internal fun charcoalM3Typography(typography: CharcoalTypography): Typography {
    val default = Typography()
    return default.copy(
        headlineSmall = typography.bold20,
        titleLarge = typography.regular20,
        titleMedium = typography.regular16,
        titleSmall = typography.regular14,
        bodyLarge = typography.regular14,
        bodyMedium = typography.regular16,
        bodySmall = typography.regular12,
        labelLarge = typography.bold14,
        labelMedium = typography.regular12,
        labelSmall = typography.regular10,
    )
}
