package net.pixiv.charcoal.android.catalog.compose.m3

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import net.pixiv.charcoal.android.compose.m3.component.CharcoalTopAppBarDefaults
import net.pixiv.charcoal.android.compose.m3.theme.CharcoalM3Theme
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

/**
 * M3 カタログの各画面で共通して使う枠。
 * CharcoalM3Theme を適用し、戻る操作を持つ TopAppBar と縦スクロールの本文を並べる。
 * 一覧のように横幅いっぱいに広げたい場合は [contentPadding] に 0 を渡す。
 */
@Composable
internal fun CatalogComposeM3Scaffold(
    title: String,
    onNavigationClick: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(16.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(16.dp),
    content: @Composable () -> Unit,
) {
    CharcoalM3Theme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = title) },
                    navigationIcon = {
                        IconButton(onClick = onNavigationClick) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null,
                            )
                        }
                    },
                    colors = CharcoalTopAppBarDefaults.defaultColors(),
                )
            },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
                    .padding(contentPadding),
                verticalArrangement = verticalArrangement,
            ) {
                content()
            }
        }
    }
}

private val CatalogControlWidth = 88.dp

/** 各節の見出し。 */
@Composable
internal fun CatalogSectionLabel(text: String) {
    Text(
        text = text,
        style = CharcoalTheme.typography.bold14,
        color = CharcoalTheme.colorToken.text1,
    )
}

/** 同じ種類のコントロールを横に並べる。 */
@Composable
internal fun CatalogControlRow(content: @Composable () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.Top,
    ) {
        content()
    }
}

/**
 * コントロールの下に状態の説明を添える。
 * 幅を固定することで、行をまたいでもコントロールの横位置が揃う。
 */
@Composable
internal fun CatalogLabeledControl(
    label: String,
    control: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.width(CatalogControlWidth),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        control()
        Text(
            text = label,
            style = CharcoalTheme.typography.regular10,
            color = CharcoalTheme.colorToken.text2,
            textAlign = TextAlign.Center,
        )
    }
}

/**
 * 押下状態を固定で描くための [MutableInteractionSource]。
 * 押下済みの [PressInteraction.Press] だけを流すため、触らなくてもリップルが出たままになる。
 * AndroidView 版カタログの `applyPressedStateDelayed` に相当する。
 */
internal fun catalogPressedInteractionSource(): MutableInteractionSource =
    object : MutableInteractionSource {
        override val interactions: Flow<Interaction> = flowOf(PressInteraction.Press(Offset.Zero))

        override suspend fun emit(interaction: Interaction) = Unit

        override fun tryEmit(interaction: Interaction): Boolean = true
    }
