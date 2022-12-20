package net.pixiv.charcoal.android.catalog.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

fun AppCompatActivity.setSupportActionBarWithHomeButtonAndTitle(
    toolbar: Toolbar,
    title: CharSequence
) {
    this.setSupportActionBar(toolbar)

    checkNotNull(this.supportActionBar).let {
        it.setDisplayHomeAsUpEnabled(true)
        it.setDisplayShowHomeEnabled(true)
        it.title = title
    }
}
