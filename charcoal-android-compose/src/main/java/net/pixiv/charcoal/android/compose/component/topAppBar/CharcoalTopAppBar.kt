package net.pixiv.charcoal.android.compose.component.topAppBar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import net.pixiv.charcoal.android.compose.theme.CharcoalContentAlpha
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

/**
 * Charcoal 向けの TopAppBar
 * actions 引数を設定する場合は、[createTopAppBarActions] 関数を利用すること。
 * TODO createTopAppBarActions を利用しない実装に変更したい
 */
@Composable
fun CharcoalTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    style: CharcoalTopAppBarStyle = CharcoalTopAppBarStyle.default(),
) {
    val titleInternal: @Composable () -> Unit = {
        CompositionLocalProvider(
            LocalContentColor provides style.getTitleContentColor(),
            LocalContentAlpha provides CharcoalContentAlpha.normal,
            LocalTextStyle provides CharcoalTheme.typography.regular20,
            content = title
        )
    }

    val navigationIconInternal: @Composable (() -> Unit)? = navigationIcon?.let {
        {
            CompositionLocalProvider(
                LocalContentAlpha provides CharcoalContentAlpha.normal,
                content = it
            )
        }
    }

    TopAppBar(
        title = titleInternal,
        modifier = modifier,
        navigationIcon = navigationIconInternal,
        actions = actions,
        backgroundColor = style.getBackgroundColor(),
        contentColor = style.getContentColor(),
        elevation = style.getElevation()
    )
}

@Composable
fun createTopAppBarActions(content: @Composable () -> Unit): @Composable RowScope.() -> Unit {
    val actions: (@Composable RowScope.() -> Unit) = {
        CompositionLocalProvider(LocalContentAlpha provides CharcoalContentAlpha.normal) {
            content()
        }
    }

    return actions
}
