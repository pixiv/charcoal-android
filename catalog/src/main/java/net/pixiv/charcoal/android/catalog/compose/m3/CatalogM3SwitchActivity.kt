package net.pixiv.charcoal.android.catalog.compose.m3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import net.pixiv.charcoal.android.compose.m3.component.CharcoalSwitchDefaults

/** Switch の一覧。 */
class CatalogM3SwitchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M3SwitchCatalog(onNavigationClick = { finish() })
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CatalogM3SwitchActivity::class.java)
        }
    }
}

@Composable
private fun M3SwitchCatalog(onNavigationClick: () -> Unit) {
    CatalogComposeM3Scaffold(
        title = "Switch",
        onNavigationClick = onNavigationClick,
    ) {
        CatalogSectionLabel("Switch")
        CatalogControlRow {
            listOf(false, true).forEach { initial ->
                CatalogLabeledControl(if (initial) "enabled on" else "enabled off") {
                    var checked by remember { mutableStateOf(initial) }
                    Switch(
                        checked = checked,
                        onCheckedChange = { checked = it },
                        colors = CharcoalSwitchDefaults.colors(),
                    )
                }
            }
        }
        CatalogControlRow {
            listOf(false, true).forEach { checked ->
                CatalogLabeledControl(if (checked) "disabled on" else "disabled off") {
                    Switch(
                        checked = checked,
                        onCheckedChange = null,
                        enabled = false,
                        colors = CharcoalSwitchDefaults.colors(),
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun M3SwitchCatalogPreview() {
    M3SwitchCatalog(onNavigationClick = {})
}
