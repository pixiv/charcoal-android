package net.pixiv.charcoal.android.compose.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val charcoalFontFamilyRobotoMono = FontFamily(
    Font(net.pixiv.charcoal.android.R.font.charcoal_roboto_mono),
    Font(net.pixiv.charcoal.android.R.font.charcoal_roboto_mono_bold, FontWeight.Bold)
)

private val charcoalTextStyle10FontSize = 10.sp
private val charcoalTextStyle10lineHeight = 18.sp

private val charcoalTextStyle12FontSize = 12.sp
private val charcoalTextStyle12lineHeight = 20.sp

private val charcoalTextStyle14FontSize = 14.sp
private val charcoalTextStyle14lineHeight = 22.sp

private val charcoalTextStyle16FontSize = 16.sp
private val charcoalTextStyle16lineHeight = 24.sp

private val charcoalTextStyle20FontSize = 20.sp
private val charcoalTextStyle20lineHeight = 28.sp

@Stable
data class CharcoalTypography(
    val regular10: TextStyle = TextStyle(
        fontSize = charcoalTextStyle10FontSize,
        fontFamily = FontFamily.SansSerif,
        lineHeight = charcoalTextStyle10lineHeight,
    ),
    val regular12: TextStyle = TextStyle(
        fontSize = charcoalTextStyle12FontSize,
        fontFamily = FontFamily.SansSerif,
        lineHeight = charcoalTextStyle12lineHeight,
    ),
    val regular14: TextStyle = TextStyle(
        fontSize = charcoalTextStyle14FontSize,
        fontFamily = FontFamily.SansSerif,
        lineHeight = charcoalTextStyle14lineHeight,
    ),
    val regular16: TextStyle = TextStyle(
        fontSize = charcoalTextStyle16FontSize,
        fontFamily = FontFamily.SansSerif,
        lineHeight = charcoalTextStyle16lineHeight,
    ),
    val regular20: TextStyle = TextStyle(
        fontSize = charcoalTextStyle20FontSize,
        fontFamily = FontFamily.SansSerif,
        lineHeight = charcoalTextStyle20lineHeight,
    ),
    val bold10: TextStyle = TextStyle(
        fontSize = charcoalTextStyle10FontSize,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        lineHeight = charcoalTextStyle10lineHeight,
    ),
    val bold12: TextStyle = TextStyle(
        fontSize = charcoalTextStyle12FontSize,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        lineHeight = charcoalTextStyle12lineHeight,
    ),
    val bold14: TextStyle = TextStyle(
        fontSize = charcoalTextStyle14FontSize,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        lineHeight = charcoalTextStyle14lineHeight,
    ),
    val bold16: TextStyle = TextStyle(
        fontSize = charcoalTextStyle16FontSize,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        lineHeight = charcoalTextStyle16lineHeight,
    ),
    val bold20: TextStyle = TextStyle(
        fontSize = charcoalTextStyle20FontSize,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        lineHeight = charcoalTextStyle20lineHeight,
    ),
    val mono10: TextStyle = TextStyle(
        fontSize = charcoalTextStyle10FontSize,
        fontFamily = charcoalFontFamilyRobotoMono,
        lineHeight = charcoalTextStyle10lineHeight,
    ),
    val mono12: TextStyle = TextStyle(
        fontSize = charcoalTextStyle12FontSize,
        fontFamily = charcoalFontFamilyRobotoMono,
        lineHeight = charcoalTextStyle12lineHeight,
    ),
    val mono14: TextStyle = TextStyle(
        fontSize = charcoalTextStyle14FontSize,
        fontFamily = charcoalFontFamilyRobotoMono,
        lineHeight = charcoalTextStyle14lineHeight,
    ),
    val mono16: TextStyle = TextStyle(
        fontSize = charcoalTextStyle16FontSize,
        fontFamily = charcoalFontFamilyRobotoMono,
        lineHeight = charcoalTextStyle16lineHeight,
    ),
    val mono20: TextStyle = TextStyle(
        fontSize = charcoalTextStyle20FontSize,
        fontFamily = charcoalFontFamilyRobotoMono,
        lineHeight = charcoalTextStyle20lineHeight,
    ),
    val boldMono10: TextStyle = TextStyle(
        fontSize = charcoalTextStyle10FontSize,
        fontFamily = charcoalFontFamilyRobotoMono,
        fontWeight = FontWeight.Bold,
        lineHeight = charcoalTextStyle10lineHeight,
    ),
    val boldMono12: TextStyle = TextStyle(
        fontSize = charcoalTextStyle12FontSize,
        fontFamily = charcoalFontFamilyRobotoMono,
        fontWeight = FontWeight.Bold,
        lineHeight = charcoalTextStyle12lineHeight,
    ),
    val boldMono14: TextStyle = TextStyle(
        fontSize = charcoalTextStyle14FontSize,
        fontFamily = charcoalFontFamilyRobotoMono,
        fontWeight = FontWeight.Bold,
        lineHeight = charcoalTextStyle14lineHeight,
    ),
    val boldMono16: TextStyle = TextStyle(
        fontSize = charcoalTextStyle16FontSize,
        fontFamily = charcoalFontFamilyRobotoMono,
        fontWeight = FontWeight.Bold,
        lineHeight = charcoalTextStyle16lineHeight,
    ),
    val boldMono20: TextStyle = TextStyle(
        fontSize = charcoalTextStyle20FontSize,
        fontFamily = charcoalFontFamilyRobotoMono,
        fontWeight = FontWeight.Bold,
        lineHeight = charcoalTextStyle20lineHeight,
    ),
)
