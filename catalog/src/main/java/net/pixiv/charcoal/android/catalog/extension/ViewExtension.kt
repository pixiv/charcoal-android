package net.pixiv.charcoal.android.catalog.extension

import android.view.View

/**
 * isPressed の状態が
 */
fun View.applyPressedStateDelayed(isPressed: Boolean = true, delay: Long = 100) {
    this.postDelayed(
        {
            this.isPressed = isPressed
        },
        delay
    )
}
