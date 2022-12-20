package net.pixiv.charcoal.android.compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.LocalElevationOverlay
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun CharcoalTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    colorToken: CharcoalColorToken = if (isDarkTheme) darkColorToken() else lightColorToken(),
    content: @Composable () -> Unit
) {
    val materialColors = if (isDarkTheme) {
        darkMaterialColors(colorToken = colorToken)
    } else {
        lightMaterialColors(colorToken = colorToken)
    }

    MaterialTheme(
        colors = materialColors
    ) {
        CompositionLocalProvider(
            LocalCharcoalColorToken provides colorToken,
            LocalCharcoalTypography provides CharcoalTypography(),
            LocalElevationOverlay provides null
        ) {
            content()
        }
    }
}

/**
 * CharcoalTheme 内で利用可能な CompositionLocal への参照をまとめた object
 */
object CharcoalTheme {
    val colorToken: CharcoalColorToken
        @Composable
        @ReadOnlyComposable
        get() = LocalCharcoalColorToken.current

    val typography: CharcoalTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCharcoalTypography.current
}

private fun lightColorToken(): CharcoalColorToken {
    return CharcoalColorToken(
        brand = CharcoalColorPalette.pixivBrand,
        brandDark = CharcoalColorPalette.pixivBrandDark,
        assertive = CharcoalColorPalette.assertive,
        warning = CharcoalColorPalette.warning,
        success = CharcoalColorPalette.success,
        like = CharcoalColorPalette.like,
        premium = CharcoalColorPalette.premium,
        marker = CharcoalColorPalette.marker,
        background1 = CharcoalColorPalette.white,
        background2 = CharcoalColorPalette.gray10,
        surface1 = CharcoalColorPalette.white,
        surface2 = CharcoalColorPalette.blackFade00,
        surface3 = CharcoalColorPalette.blackFade10,
        surface4 = CharcoalColorPalette.blackFade40,
        surface6 = CharcoalColorPalette.blackFade90,
        surface9 = CharcoalColorPalette.white,
        surface10 = CharcoalColorPalette.blackFade30,
        link1 = CharcoalColorPalette.linkEnabled,
        text1 = CharcoalColorPalette.gray90,
        text2 = CharcoalColorPalette.gray70,
        text3 = CharcoalColorPalette.gray50,
        text4 = CharcoalColorPalette.gray40,
        text5 = CharcoalColorPalette.white,
        border = CharcoalColorPalette.blackFade20
    )
}

private fun darkColorToken(): CharcoalColorToken {
    return CharcoalColorToken(
        brand = CharcoalColorPalette.pixivBrand,
        brandDark = CharcoalColorPalette.pixivBrandDark,
        assertive = CharcoalColorPalette.assertive,
        warning = CharcoalColorPalette.warning,
        success = CharcoalColorPalette.success,
        like = CharcoalColorPalette.like,
        premium = CharcoalColorPalette.premium,
        marker = CharcoalColorPalette.marker,
        background1 = CharcoalColorPalette.gray90,
        background2 = CharcoalColorPalette.black,
        surface1 = CharcoalColorPalette.gray90,
        surface2 = CharcoalColorPalette.blackFade30,
        surface3 = CharcoalColorPalette.whiteFade00,
        surface4 = CharcoalColorPalette.blackFade40,
        surface6 = CharcoalColorPalette.whiteFade00,
        surface9 = CharcoalColorPalette.gray80,
        surface10 = CharcoalColorPalette.whiteFade10,
        link1 = CharcoalColorPalette.linkEnabledDark,
        text1 = CharcoalColorPalette.gray10,
        text2 = CharcoalColorPalette.gray30,
        text3 = CharcoalColorPalette.gray50,
        text4 = CharcoalColorPalette.gray60,
        text5 = CharcoalColorPalette.gray10,
        border = CharcoalColorPalette.whiteFade00
    )
}

private fun lightMaterialColors(colorToken: CharcoalColorToken): Colors {
    return lightColors(
        primary = colorToken.brand,
        primaryVariant = colorToken.brandDark,
        secondary = colorToken.brand,
        background = colorToken.background1,
        surface = colorToken.surface1,
        error = colorToken.assertive,
        onPrimary = colorToken.text5,
        onSecondary = colorToken.text5,
        onBackground = colorToken.text2,
        onSurface = colorToken.text2,
        onError = colorToken.text5
    )
}

private fun darkMaterialColors(colorToken: CharcoalColorToken): Colors {
    return darkColors(
        primary = colorToken.brand,
        primaryVariant = colorToken.brandDark,
        secondary = colorToken.brand,
        background = colorToken.background1,
        surface = colorToken.surface1,
        error = colorToken.assertive,
        onPrimary = colorToken.text5,
        onSecondary = colorToken.text5,
        onBackground = colorToken.text2,
        onSurface = colorToken.text2,
        onError = colorToken.text5
    )
}

internal val LocalCharcoalColorToken = staticCompositionLocalOf { lightColorToken() }
internal val LocalCharcoalTypography = staticCompositionLocalOf { CharcoalTypography() }
