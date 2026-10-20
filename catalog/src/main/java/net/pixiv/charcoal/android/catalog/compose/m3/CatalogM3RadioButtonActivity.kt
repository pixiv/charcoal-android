package net.pixiv.charcoal.android.catalog.compose.m3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import net.pixiv.charcoal.android.compose.m3.component.CharcoalRadioButtonDefaults

/** RadioButton の一覧。 */
class CatalogM3RadioButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M3RadioButtonCatalog(onNavigationClick = { finish() })
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CatalogM3RadioButtonActivity::class.java)
        }
    }
}

@Composable
private fun M3RadioButtonCatalog(onNavigationClick: () -> Unit) {
    CatalogComposeM3Scaffold(
        title = "RadioButton",
        onNavigationClick = onNavigationClick,
    ) {
        CatalogSectionLabel("RadioButton")
        CatalogControlRow {
            listOf(false, true).forEach { initial ->
                CatalogLabeledControl(if (initial) "enabled on" else "enabled off") {
                    var selected by remember { mutableStateOf(initial) }
                    RadioButton(
                        selected = selected,
                        onClick = { selected = !selected },
                        colors = CharcoalRadioButtonDefaults.colors(),
                    )
                }
            }
        }
        CatalogControlRow {
            listOf(false, true).forEach { isSelected ->
                CatalogLabeledControl(if (isSelected) "disabled on" else "disabled off") {
                    RadioButton(
                        selected = isSelected,
                        onClick = null,
                        enabled = false,
                        colors = CharcoalRadioButtonDefaults.colors(),
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun M3RadioButtonCatalogPreview() {
    M3RadioButtonCatalog(onNavigationClick = {})
}
