package net.pixiv.charcoal.android.catalog.compose.m3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import net.pixiv.charcoal.android.compose.m3.component.CharcoalAlertDialogDefaults
import net.pixiv.charcoal.android.compose.m3.component.CharcoalButton
import net.pixiv.charcoal.android.compose.m3.component.CharcoalButtonDefaults
import net.pixiv.charcoal.android.compose.m3.component.CharcoalTextButtonDefaults

/** AlertDialog の一覧。タイトル・本文の有無を切り替えて表示する。 */
class CatalogM3AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M3AlertDialogCatalog(onNavigationClick = { finish() })
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CatalogM3AlertDialogActivity::class.java)
        }
    }
}

private enum class DialogPattern(val label: String) {
    TitleAndText("タイトル + 本文"),
    TitleOnly("タイトルのみ"),
    TextOnly("本文のみ"),
}

@Composable
private fun M3AlertDialogCatalog(onNavigationClick: () -> Unit) {
    CatalogComposeM3Scaffold(
        title = "AlertDialog",
        onNavigationClick = onNavigationClick,
    ) {
        CatalogSectionLabel("AlertDialog")
        var shown by remember { mutableStateOf<DialogPattern?>(null) }
        DialogPattern.entries.forEach { pattern ->
            CharcoalButton(
                onClick = { shown = pattern },
                colors = CharcoalButtonDefaults.defaultButtonColors(),
            ) { Text(pattern.label) }
        }

        shown?.let { pattern ->
            AlertDialog(
                onDismissRequest = { shown = null },
                confirmButton = {
                    TextButton(
                        onClick = { shown = null },
                        colors = CharcoalTextButtonDefaults.linkColors(),
                    ) { Text("OK") }
                },
                dismissButton = {
                    TextButton(
                        onClick = { shown = null },
                        colors = CharcoalTextButtonDefaults.linkColors(),
                    ) { Text("キャンセル") }
                },
                title = if (pattern == DialogPattern.TextOnly) {
                    null
                } else {
                    { Text("タイトル") }
                },
                text = if (pattern == DialogPattern.TitleOnly) {
                    null
                } else {
                    { Text("本文のテキストです。bodyMedium（regular16）で描かれます。") }
                },
                containerColor = CharcoalAlertDialogDefaults.containerColor,
                titleContentColor = CharcoalAlertDialogDefaults.titleContentColor,
                textContentColor = CharcoalAlertDialogDefaults.textContentColor,
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun M3AlertDialogCatalogPreview() {
    M3AlertDialogCatalog(onNavigationClick = {})
}
