package net.pixiv.charcoal.android.compose.m3.component

import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

/**
 * Charcoal デザイントークンを M3 Tab / SecondaryTabRow の既定値として提供する。
 *
 * ```
 * SecondaryTabRow(
 *     selectedTabIndex = index,
 *     indicator = { CharcoalTabDefaults.Indicator(Modifier.tabIndicatorOffset(index)) },
 * ) {
 *     Tab(
 *         selected = ..., onClick = ...,
 *         selectedContentColor = CharcoalTabDefaults.selectedContentColor,
 *         unselectedContentColor = CharcoalTabDefaults.unselectedContentColor,
 *         text = { Text("...") },
 *     )
 * }
 * ```
 */
object CharcoalTabDefaults {
    /** 選択中 Tab のコンテンツ色。 */
    val selectedContentColor: Color @Composable @ReadOnlyComposable get() = CharcoalTheme.colorToken.text1

    /** 非選択 Tab のコンテンツ色。 */
    val unselectedContentColor: Color @Composable @ReadOnlyComposable get() = CharcoalTheme.colorToken.text3

    /** 選択中 Tab のインジケータ色。 */
    val indicatorColor: Color @Composable @ReadOnlyComposable get() = CharcoalTheme.colorToken.brand

    /** 選択中 Tab のインジケータの高さ。 */
    val IndicatorHeight: Dp = 2.dp

    /**
     * Charcoal の色・高さを当てた Tab のインジケータ。
     * SecondaryTabRow の `indicator` で `Modifier.tabIndicatorOffset(selectedTabIndex)` を渡して使う。
     */
    @Composable
    fun Indicator(
        modifier: Modifier = Modifier,
        color: Color = indicatorColor,
    ) {
        TabRowDefaults.SecondaryIndicator(
            modifier = modifier,
            height = IndicatorHeight,
            color = color,
        )
    }
}
