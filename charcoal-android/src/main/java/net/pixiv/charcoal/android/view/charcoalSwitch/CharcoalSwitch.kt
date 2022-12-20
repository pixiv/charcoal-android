package net.pixiv.charcoal.android.view.charcoalSwitch

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.annotation.AttrRes
import com.google.android.material.color.MaterialColors
import com.google.android.material.switchmaterial.SwitchMaterial
import net.pixiv.charcoal.android.R
import net.pixiv.charcoal.android.view.color.CharcoalColorToken
import net.pixiv.charcoal.android.view.constant.CharcoalColorConstant

/**
 * Charcoal の色設定が反映される Switch です。
 * [SwitchMaterial] をベースに実装していますが、 Material Theming での色設定を無効化し、 Charcoal の色設定が適用されるよう実装をしています。
 * このクラスを利用するためには、 Theme に `?attr/colorCharcoalBrand`, `?attr/colorCharcoalSurface1`, `?attr/colorCharcoalIcon5` の設定が必要です。
 */
class CharcoalSwitch : SwitchMaterial {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, R.attr.switchStyle)
    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr,
    )

    init {
        // Material Theming の配色が適用される前に設定する
        thumbTintList = buildCharcoalSwitchThumbTintList()
        trackTintList = buildCharcoalSwitchTrackTintList()
    }

    override fun setUseMaterialThemeColors(isEnable: Boolean) {
        // あえて Material Theming の配色を適用させないようにするため何もしない
    }

    private fun buildCharcoalSwitchThumbTintList(): ColorStateList {
        val colorSurface = CharcoalColorToken.getSurface1(context)
        val colorOnSurface = CharcoalColorToken.getText5(context)
        val colorControlActivated = CharcoalColorToken.getBrand(context)

        val switchThumbColorsList = IntArray(ENABLED_CHECKED_STATES.size)
        switchThumbColorsList[0] = MaterialColors.layer(colorSurface, colorControlActivated)
        switchThumbColorsList[1] = MaterialColors.layer(colorSurface, colorOnSurface)
        switchThumbColorsList[2] = MaterialColors.layer(
            colorSurface,
            colorControlActivated,
            CharcoalColorConstant.DISABLED_STATE_ALPHA
        )
        switchThumbColorsList[3] =
            MaterialColors.layer(
                colorSurface,
                colorOnSurface,
                CharcoalColorConstant.DISABLED_STATE_ALPHA
            )
        return ColorStateList(ENABLED_CHECKED_STATES, switchThumbColorsList)
    }

    private fun buildCharcoalSwitchTrackTintList(): ColorStateList {
        val colorSurface = CharcoalColorToken.getSurface1(context)
        val colorOnSurface = CharcoalColorToken.getText3(context)
        val colorControlActivated = CharcoalColorToken.getBrand(context)

        val switchTrackColorsList = IntArray(ENABLED_CHECKED_STATES.size)
        switchTrackColorsList[0] = MaterialColors.layer(
            colorSurface,
            colorControlActivated,
            CharcoalColorConstant.DISABLED_STATE_ALPHA
        )
        switchTrackColorsList[1] = MaterialColors.layer(colorSurface, colorOnSurface)
        switchTrackColorsList[2] =
            MaterialColors.layer(
                colorSurface,
                switchTrackColorsList[0],
                CharcoalColorConstant.DISABLED_STATE_ALPHA
            )
        switchTrackColorsList[3] =
            MaterialColors.layer(
                colorSurface,
                switchTrackColorsList[1],
                CharcoalColorConstant.DISABLED_STATE_ALPHA
            )
        return ColorStateList(ENABLED_CHECKED_STATES, switchTrackColorsList)
    }

    companion object {
        private val ENABLED_CHECKED_STATES = arrayOf(
            intArrayOf(android.R.attr.state_enabled, android.R.attr.state_checked),
            intArrayOf(android.R.attr.state_enabled, -android.R.attr.state_checked),
            intArrayOf(-android.R.attr.state_enabled, android.R.attr.state_checked),
            intArrayOf(-android.R.attr.state_enabled, -android.R.attr.state_checked)
        )
    }
}
