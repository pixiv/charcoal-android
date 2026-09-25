package net.pixiv.charcoal.android.compose.m3.component

import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

/**
 * Charcoal デザイントークンを M3 TopAppBar の既定色として提供する。
 */
object CharcoalTopAppBarDefaults {
    /**
     * navigationIcon / actionIcon を text3 にした [TopAppBarColors] を返す。各色は引数で差し替えられる。
     */
    @Composable
    fun defaultColors(
        navigationIconContentColor: Color = CharcoalTheme.colorToken.text3,
        actionIconContentColor: Color = CharcoalTheme.colorToken.text3,
    ): TopAppBarColors = TopAppBarDefaults.topAppBarColors(
        navigationIconContentColor = navigationIconContentColor,
        actionIconContentColor = actionIconContentColor,
    )

    /**
     * 画像などの上に重ねて置く TopAppBar の [TopAppBarColors] を返す。各色は引数で差し替えられる。
     * 背景を透明にし、title / navigationIcon / actionIcon を text5 にする。
     */
    @Composable
    fun overlayColors(
        containerColor: Color = Color.Transparent,
        scrolledContainerColor: Color = Color.Transparent,
        titleContentColor: Color = CharcoalTheme.colorToken.text5,
        navigationIconContentColor: Color = CharcoalTheme.colorToken.text5,
        actionIconContentColor: Color = CharcoalTheme.colorToken.text5,
    ): TopAppBarColors = TopAppBarDefaults.topAppBarColors(
        containerColor = containerColor,
        scrolledContainerColor = scrolledContainerColor,
        titleContentColor = titleContentColor,
        navigationIconContentColor = navigationIconContentColor,
        actionIconContentColor = actionIconContentColor,
    )
}
