package net.pixiv.charcoal.android.compose.component.radioButton

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.RadioButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import net.pixiv.charcoal.android.compose.extension.overlayAlpha
import net.pixiv.charcoal.android.compose.theme.CharcoalContentAlpha
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

@Stable
internal class CharcoalRadioButtonColors(
    private val selectedColor: Color,
    private val unselectedColor: Color,
    private val disabledSelectedColor: Color,
    private val disabledUnselectedColor: Color,
) : RadioButtonColors {

    @Composable
    override fun radioColor(enabled: Boolean, selected: Boolean): State<Color> {
        val target = if (enabled) {
            if (selected) {
                selectedColor
            } else {
                unselectedColor
            }
        } else {
            if (selected) {
                disabledSelectedColor
            } else {
                disabledUnselectedColor
            }
        }

        return if (enabled) {
            animateColorAsState(target, tween(durationMillis = RadioAnimationDuration))
        } else {
            rememberUpdatedState(target)
        }
    }

    companion object {
        @Composable
        fun createInstance(): RadioButtonColors {
            val selectedColor = CharcoalTheme.colorToken.brand
            val unselectedColor = CharcoalTheme.colorToken.text3
            val disabledSelectedColor = selectedColor.overlayAlpha(CharcoalContentAlpha.disabled)
            val disabledUnselectedColor =
                unselectedColor.overlayAlpha(CharcoalContentAlpha.disabled)

            return CharcoalRadioButtonColors(
                selectedColor,
                unselectedColor,
                disabledSelectedColor,
                disabledUnselectedColor
            )
        }
    }
}

private const val RadioAnimationDuration = 100
