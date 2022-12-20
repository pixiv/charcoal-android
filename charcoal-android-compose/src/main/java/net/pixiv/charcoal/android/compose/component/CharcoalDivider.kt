package net.pixiv.charcoal.android.compose.component

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

@Composable
fun CharcoalDivider(
    modifier: Modifier = Modifier,
    color: Color = CharcoalTheme.colorToken.border,
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp
) {
    Divider(
        modifier = modifier,
        color = color,
        thickness = thickness,
        startIndent = startIndent
    )
}
