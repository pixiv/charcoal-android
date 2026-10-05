package net.pixiv.charcoal.android.catalog.compose.m3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import net.pixiv.charcoal.android.compose.m3.component.CharcoalButton
import net.pixiv.charcoal.android.compose.m3.component.CharcoalButtonDefaults
import net.pixiv.charcoal.android.compose.m3.component.CharcoalButtonSize
import net.pixiv.charcoal.android.compose.m3.component.CharcoalTextButtonDefaults

/**
 * Charcoal のボタン一覧。
 * 配色 4 種類 × サイズ M / S × enabled / disabled と、Link（M3 TextButton）を並べる。
 * 押下状態は固定で描いたものを並べる。
 */
class CatalogM3ButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M3ButtonCatalog(onNavigationClick = { finish() })
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CatalogM3ButtonActivity::class.java)
        }
    }
}

@Composable
private fun M3ButtonCatalog(onNavigationClick: () -> Unit) {
    CatalogComposeM3Scaffold(
        title = "Button",
        onNavigationClick = onNavigationClick,
    ) {
        ButtonColorSection(
            label = "primaryButtonColors",
            colors = { CharcoalButtonDefaults.primaryButtonColors() },
        )
        ButtonColorSection(
            label = "defaultButtonColors",
            colors = { CharcoalButtonDefaults.defaultButtonColors() },
        )
        ButtonColorSection(
            label = "defaultOverlayButtonColors",
            colors = { CharcoalButtonDefaults.defaultOverlayButtonColors() },
        )
        ButtonColorSection(
            label = "navigationButtonColors",
            colors = { CharcoalButtonDefaults.navigationButtonColors() },
            showDisabled = false,
        )

        CatalogSectionLabel("linkColors（M3 TextButton）")
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextButton(
                onClick = {},
                colors = CharcoalTextButtonDefaults.linkColors(),
            ) { Text("Enabled") }
            TextButton(
                onClick = {},
                colors = CharcoalTextButtonDefaults.linkColors(),
                interactionSource = catalogPressedInteractionSource(),
            ) { Text("Pressed") }
            TextButton(
                onClick = {},
                enabled = false,
                colors = CharcoalTextButtonDefaults.linkColors(),
            ) { Text("Disabled") }
        }
    }
}

/**
 * 1 配色分のサンプル。M / S の 2 行を並べる。
 *
 * Pressed は M の行にだけ置く。押下状態は配色で決まりサイズでは変わらないうえ、
 * Android の Compose Ripple は 1 つの ComposeView あたり最大 5 個 (RippleContainer.MaxRippleHosts)
 * しか同時に描けず、それを超えると古いものから描画が消えるため。
 */
@Composable
private fun ButtonColorSection(
    label: String,
    colors: @Composable () -> ButtonColors,
    showDisabled: Boolean = true,
) {
    CatalogSectionLabel(label)
    ButtonRow(colors = colors, buttonSize = null, showDisabled = showDisabled, showPressed = true)
    ButtonRow(
        colors = colors,
        buttonSize = CharcoalButtonDefaults.buttonSizeS(),
        showDisabled = showDisabled,
        showPressed = false,
    )
}

@Composable
private fun ButtonRow(
    colors: @Composable () -> ButtonColors,
    buttonSize: CharcoalButtonSize?,
    showDisabled: Boolean,
    showPressed: Boolean,
) {
    val size = buttonSize ?: CharcoalButtonDefaults.buttonSizeM()
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CharcoalButton(
            onClick = {},
            colors = colors(),
            buttonSize = size,
        ) { Text(if (buttonSize == null) "Enabled M" else "Enabled S") }
        if (showPressed) {
            CharcoalButton(
                onClick = {},
                colors = colors(),
                buttonSize = size,
                interactionSource = catalogPressedInteractionSource(),
            ) { Text("Pressed") }
        }
        if (showDisabled) {
            CharcoalButton(
                onClick = {},
                enabled = false,
                colors = colors(),
                buttonSize = size,
            ) { Text("Disabled") }
        }
    }
}

@PreviewLightDark
@Composable
private fun M3ButtonCatalogPreview() {
    M3ButtonCatalog(onNavigationClick = {})
}
