package net.pixiv.charcoal.android.view.color

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import net.pixiv.charcoal.android.R

/**
 * Charcoal の色トークンに関連する色を取得する実装をまとめた object
 *
 * Charcoal Theme を利用していないなど、属性に値が割り当てられていない場合は IllegalStateException が発生する
 */
object CharcoalColorToken {
    @ColorInt
    fun getBrand(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalBrand)
    }

    @ColorInt
    fun getBrandDark(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalBrandDark)
    }

    @ColorInt
    fun getAssertive(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalAssertive)
    }

    @ColorInt
    fun getWarning(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalWarning)
    }

    @ColorInt
    fun getSuccess(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalSuccess)
    }

    @ColorInt
    fun getLike(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalLike)
    }

    @ColorInt
    fun getPremium(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalPremium)
    }

    @ColorInt
    fun getMarker(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalMarker)
    }

    @ColorInt
    fun getBackground1(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalBackground1)
    }

    @ColorInt
    fun getBackground2(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalBackground2)
    }

    @ColorInt
    fun getSurface1(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalSurface1)
    }

    @ColorInt
    fun getSurface2(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalSurface2)
    }

    @ColorInt
    fun getSurface3(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalSurface3)
    }

    @ColorInt
    fun getSurface4(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalSurface4)
    }

    @ColorInt
    fun getSurface6(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalSurface6)
    }

    @ColorInt
    fun getSurface9(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalSurface9)
    }

    @ColorInt
    fun getLink1(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalLink1)
    }

    @ColorInt
    fun getText1(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalText1)
    }

    @ColorInt
    fun getText2(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalText2)
    }

    @ColorInt
    fun getText3(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalText3)
    }

    @ColorInt
    fun getText4(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalText4)
    }

    @ColorInt
    fun getText5(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalText5)
    }

    @ColorInt
    fun getIcon6(context: Context): Int {
        return resolveColorOrThrow(context, R.attr.colorCharcoalIcon6)
    }

    @ColorInt
    private fun resolveColorOrThrow(context: Context, @AttrRes colorAttributeResId: Int): Int {
        val typedValue = TypedValue()
        if (context.theme.resolveAttribute(colorAttributeResId, typedValue, true)) {
            return typedValue.data
        }

        throw IllegalStateException("Charcoal Theme, もしくは Charcoal Bridge Theme を利用してください")
    }
}
