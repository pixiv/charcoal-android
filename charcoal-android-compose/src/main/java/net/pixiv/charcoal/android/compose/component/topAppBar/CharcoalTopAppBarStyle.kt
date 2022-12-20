package net.pixiv.charcoal.android.compose.component.topAppBar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

/**
 * CharcoalTopAppBar に適用する色・elevation の設定をまとめる interface
 */
interface CharcoalTopAppBarStyle {
    @Composable
    fun getBackgroundColor(): Color

    @Composable
    fun getContentColor(): Color

    @Composable
    fun getTitleContentColor(): Color

    @Composable
    fun getElevation(): Dp

    companion object {
        fun default(): CharcoalTopAppBarStyle {
            return CharcoalTopAppBarDefaultStyle
        }

        fun overlay(): CharcoalTopAppBarStyle {
            return CharcoalTopAppBarOverlayStyle
        }
    }
}

object CharcoalTopAppBarDefaultStyle : CharcoalTopAppBarStyle {
    @Composable
    @ReadOnlyComposable
    override fun getBackgroundColor(): Color = CharcoalTheme.colorToken.surface1

    @Composable
    @ReadOnlyComposable
    override fun getContentColor(): Color = CharcoalTheme.colorToken.text3

    @Composable
    @ReadOnlyComposable
    override fun getTitleContentColor(): Color = CharcoalTheme.colorToken.text1

    @Composable
    override fun getElevation(): Dp = 0.dp
}

object CharcoalTopAppBarOverlayStyle : CharcoalTopAppBarStyle {
    @Composable
    @ReadOnlyComposable
    override fun getBackgroundColor(): Color = Color.Transparent

    @Composable
    @ReadOnlyComposable
    override fun getContentColor(): Color = CharcoalTheme.colorToken.text5

    @Composable
    @ReadOnlyComposable
    override fun getTitleContentColor(): Color = CharcoalTheme.colorToken.text5

    @Composable
    override fun getElevation(): Dp = 0.dp
}
