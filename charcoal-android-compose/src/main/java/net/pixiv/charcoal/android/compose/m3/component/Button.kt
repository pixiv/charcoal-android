package net.pixiv.charcoal.android.compose.m3.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import net.pixiv.charcoal.android.compose.extension.overlayDisabledAlpha
import net.pixiv.charcoal.android.compose.theme.CharcoalContentAlpha
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

/**
 * Charcoal デザイントークンで配色・形状・サイズを統一した Surface ベースのボタン。
 * 配色パターン (primary/default) は [colors] 引数で選択し、
 * サイズ種別 (M/S) は [buttonSize] 引数で切り替える。
 * テキストボタン（Charcoal の Link）は M3 の [androidx.compose.material3.TextButton] に
 * [CharcoalTextButtonDefaults.linkColors] を渡して作る。
 */
@Composable
fun CharcoalButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = CharcoalButtonDefaults.shape,
    colors: ButtonColors = CharcoalButtonDefaults.defaultButtonColors(),
    border: BorderStroke? = null,
    buttonSize: CharcoalButtonSize = CharcoalButtonDefaults.buttonSizeM(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    val containerColor = if (enabled) colors.containerColor else colors.disabledContainerColor
    val contentColor = if (enabled) colors.contentColor else colors.disabledContentColor

    androidx.compose.material3.Surface(
        onClick = onClick,
        modifier = modifier.semantics { role = Role.Button },
        enabled = enabled,
        shape = shape,
        color = containerColor,
        contentColor = contentColor,
        tonalElevation = 0.dp,
        shadowElevation = 0.dp,
        border = border,
        interactionSource = interactionSource,
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            ProvideTextStyle(value = CharcoalTheme.typography.bold14) {
                Row(
                    Modifier
                        .defaultMinSize(minHeight = buttonSize.minHeight)
                        .padding(buttonSize.contentPadding),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    content = content,
                )
            }
        }
    }
}

/**
 * ボタンの最小高さとコンテンツパディングを保持するサイズ種別クラス。
 * [CharcoalButtonDefaults.buttonSizeM] / [CharcoalButtonDefaults.buttonSizeS] で取得する。
 */
@Immutable
class CharcoalButtonSize internal constructor(
    val minHeight: Dp,
    val contentPadding: PaddingValues,
)

/**
 * Charcoal のボタンの既定値・ファクトリをまとめたオブジェクト。
 *
 * テキストボタン（Charcoal の Link）の配色は [CharcoalTextButtonDefaults] にある。
 */
object CharcoalButtonDefaults {
    /** 通常ボタン (CharcoalButton) のデフォルト形状。CircleShape を使用する。 */
    val shape: Shape @Composable get() = CircleShape

    /** M サイズの最小高さ。 */
    val MinHeight: Dp = 40.dp

    /** S サイズの最小高さ。M3 の [ButtonDefaults.MinHeight]（40dp）より低い Charcoal 固有の値。 */
    val SmallMinHeight: Dp = 32.dp

    /** M サイズのコンテンツパディング。 */
    val ContentPadding: PaddingValues = PaddingValues(horizontal = 24.dp)

    /** S サイズのコンテンツパディング。 */
    val SmallContentPadding: PaddingValues = PaddingValues(horizontal = 16.dp)

    /**
     * brand 背景・text5 テキストの Primary ボタン配色を生成する。
     * CTA など最重要アクションに使用する。
     */
    @Composable
    fun primaryButtonColors(
        containerColor: Color = CharcoalTheme.colorToken.brand,
        contentColor: Color = CharcoalTheme.colorToken.text5,
    ): ButtonColors {
        return generateCharcoalButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
        )
    }

    /**
     * surface3 背景・text2 テキストの Default ボタン配色を生成する。
     * Secondary アクション（tonal 相当を含む）に使用する。
     */
    @Composable
    fun defaultButtonColors(
        containerColor: Color = CharcoalTheme.colorToken.surface3,
        contentColor: Color = CharcoalTheme.colorToken.text2,
    ): ButtonColors {
        return generateCharcoalButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
        )
    }

    /**
     * surface4 背景・text5 テキストの DefaultOverlay ボタン配色を生成する。
     * 画像などの上に重ねて置くボタンに使用する。背景の surface4 は半透明（黒 32%）。
     */
    @Composable
    fun defaultOverlayButtonColors(
        containerColor: Color = CharcoalTheme.colorToken.surface4,
        contentColor: Color = CharcoalTheme.colorToken.text5,
    ): ButtonColors {
        return generateCharcoalButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
        )
    }

    /**
     * surface6 背景・text5 テキストの Navigation ボタン配色を生成する。
     * 画面遷移を促す導線に使用する。
     */
    @Composable
    fun navigationButtonColors(
        containerColor: Color = CharcoalTheme.colorToken.surface6,
        contentColor: Color = CharcoalTheme.colorToken.text5,
    ): ButtonColors {
        return generateCharcoalButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor,
        )
    }

    /**
     * 高さ 40dp・水平パディング 24dp の M サイズを生成する。
     * 標準的なボタンサイズ。
     */
    @Composable
    fun buttonSizeM(
        minHeight: Dp = MinHeight,
        contentPadding: PaddingValues = ContentPadding,
    ): CharcoalButtonSize {
        return CharcoalButtonSize(
            minHeight = minHeight,
            contentPadding = contentPadding,
        )
    }

    /**
     * 高さ 32dp・水平パディング 16dp の S サイズを生成する。
     * スペースが限られた場所や補助的なボタンに使用する。
     */
    @Composable
    fun buttonSizeS(
        minHeight: Dp = SmallMinHeight,
        contentPadding: PaddingValues = SmallContentPadding,
    ): CharcoalButtonSize {
        return CharcoalButtonSize(
            minHeight = minHeight,
            contentPadding = contentPadding,
        )
    }

    /**
     * disabled 色を [CharcoalContentAlpha.disabled] で算出した M3 [ButtonColors] を生成する。
     * disabled コンテンツ色は surface1 に compositeOver することで読み取り可能なコントラストを維持する。
     */
    @Composable
    internal fun generateCharcoalButtonColors(
        containerColor: Color,
        contentColor: Color,
        disabledContainerColor: Color = containerColor.overlayDisabledAlpha(),
    ): ButtonColors {
        return ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = contentColor.overlayDisabledAlpha()
                .compositeOver(CharcoalTheme.colorToken.surface1),
        )
    }

    /**
     * M3 [ButtonDefaults.buttonElevation] から生成した [ButtonElevation]。
     * Charcoal Button は通常 Elevation を使わないため全段階 0dp を既定とする。
     */
    @Composable
    fun buttonElevation(
        defaultElevation: Dp = 0.dp,
        pressedElevation: Dp = 0.dp,
        focusedElevation: Dp = 0.dp,
        hoveredElevation: Dp = 0.dp,
        disabledElevation: Dp = 0.dp,
    ): ButtonElevation = ButtonDefaults.buttonElevation(
        defaultElevation = defaultElevation,
        pressedElevation = pressedElevation,
        focusedElevation = focusedElevation,
        hoveredElevation = hoveredElevation,
        disabledElevation = disabledElevation,
    )
}
