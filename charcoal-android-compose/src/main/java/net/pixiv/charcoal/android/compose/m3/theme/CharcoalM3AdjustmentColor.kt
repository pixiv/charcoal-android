package net.pixiv.charcoal.android.compose.m3.theme

import androidx.compose.ui.graphics.Color

// Light theme adjustment colors
private val Surface3SolidLight = Color(0xFFF5F5F5)
private val Surface6SolidLight = Color(0xFF1F1F1F)
private val ErrorContainerLight = Color(0xFFFFE5E0)

// Dark theme adjustment colors
private val Surface3SolidDark = Color(0xFF3A3A3A)
private val Surface6SolidDark = Color(0xFF3A3A3A)
private val ErrorContainerDark = Color(0xFF3A201B)

/**
 * Charcoal に未定義で、M3 ColorScheme を組み立てるために補完している調整用カラー
 *
 * いずれも既存トークンの合成（surface3 / surface6 / assertive 12% を surface1 に重ねた不透明色）で再現できる。
 *
 * Charcoal は Tonal Elevation を色で表現しない方針のため、M3 が elevation 計算で生成する
 * surface の段階色を、Charcoal トークンに無い不透明色として明示する必要がある。
 *
 * TODO これらの値は本来 @charcoal-ui/theme 側に定義され、foundation-gen によって
 *  自動生成されるべきもの。デザイン側との調整が済むまでの暫定として internal で持つ。
 */
internal data class CharcoalM3AdjustmentColor(
    val surface3Solid: Color,
    val surface6Solid: Color,
    val errorContainer: Color,
)

internal fun lightCharcoalM3AdjustmentColor(): CharcoalM3AdjustmentColor =
    CharcoalM3AdjustmentColor(
        surface3Solid = Surface3SolidLight,
        surface6Solid = Surface6SolidLight,
        errorContainer = ErrorContainerLight,
    )

internal fun darkCharcoalM3AdjustmentColor(): CharcoalM3AdjustmentColor =
    CharcoalM3AdjustmentColor(
        surface3Solid = Surface3SolidDark,
        surface6Solid = Surface6SolidDark,
        errorContainer = ErrorContainerDark,
    )
