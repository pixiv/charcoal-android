package net.pixiv.charcoal.android.compose.extension

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

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
