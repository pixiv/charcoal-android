package net.pixiv.charcoal.android.view.button

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.annotation.AttrRes
import com.google.android.material.button.MaterialButton
import com.google.android.material.color.MaterialColors
import net.pixiv.charcoal.android.R
import net.pixiv.charcoal.android.view.color.CharcoalColorToken
import net.pixiv.charcoal.android.view.constant.CharcoalColorConstant

/**
 * Charcoal の色設定が反映される Button です。
 *
 * [MaterialButton] をベースに実装しており、ボタンの状態によって textColor を変化させる実装を加えています。
 * `Widget.Charcoal.Button.*` を style として設定することを前提としています。
 */
class CharcoalButton : MaterialButton {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(
        context,
        attrs,
        R.attr.materialButtonStyle
    )

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        val buttonTextColor = buildTextColorStateList()
        this.setTextColor(buttonTextColor)
    }

    private fun buildTextColorStateList(): ColorStateList {
        val colorSurface = CharcoalColorToken.getSurface1(context)
        // android:textColor に設定された色を取得する
        val textColor = currentTextColor

        val buttonTextColorList = IntArray(ENABLED_STATES.size)
        buttonTextColorList[0] = MaterialColors.layer(colorSurface, textColor)
        // テキスト色を透過したときに、背景色に影響を受けないよう surface1 を重ねる
        buttonTextColorList[1] = MaterialColors.layer(
            colorSurface,
            textColor,
            CharcoalColorConstant.DISABLED_STATE_ALPHA
        )

        return ColorStateList(ENABLED_STATES, buttonTextColorList)
    }

    companion object {
        private val ENABLED_STATES = arrayOf(
            intArrayOf(android.R.attr.state_enabled),
            intArrayOf(-android.R.attr.state_enabled)
        )
    }
}
