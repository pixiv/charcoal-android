package net.pixiv.charcoal.android.compose.extension

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import net.pixiv.charcoal.android.compose.theme.CharcoalContentAlpha

/**
 * [Color] の alpha と引数の alpha を掛け合わせる。
 *
 * @param alpha Color に対して適用したい透過率 0.0-1.0
 * @return alpha を掛け合わせて生成した [Color]
 */
@Stable
fun Color.overlayAlpha(alpha: Float): Color {
    val computedAlpha = this.alpha * alpha
    return this.copy(alpha = computedAlpha)
}

/**
 * 操作できない状態（disabled）の表現として、この色を薄くしたものを返す。
 *
 * disabled は要素を 32% の濃さで見せる表現で、その値である [CharcoalContentAlpha.disabled] を
 * [overlayAlpha] で色そのものに掛ける。要素全体にレイヤの透過をかける方式は取らないため、
 * 文字色・枠線色など色ごとに適用する。
 *
 * 半透明のままでは背景が透けて見え方が変わる箇所（Button の disabled 文字など）では、
 * 続けて `compositeOver(CharcoalTheme.colorToken.surface1)` で不透明色にする。
 */
@Stable
fun Color.overlayDisabledAlpha(): Color = overlayAlpha(alpha = CharcoalContentAlpha.disabled)
