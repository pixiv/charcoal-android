package net.pixiv.charcoal.android.catalog.compose.m3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Checkbox
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.PreviewLightDark
import net.pixiv.charcoal.android.compose.m3.component.CharcoalCheckboxDefaults

/**
 * Checkbox と TriStateCheckbox の一覧。
 * TriStateCheckbox は Checkbox の定義を流用するため同じ画面で扱う。
 */
class CatalogM3CheckboxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M3CheckboxCatalog(onNavigationClick = { finish() })
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CatalogM3CheckboxActivity::class.java)
        }
    }
}

@Composable
private fun M3CheckboxCatalog(onNavigationClick: () -> Unit) {
    CatalogComposeM3Scaffold(
        title = "Checkbox",
        onNavigationClick = onNavigationClick,
    ) {
        CatalogSectionLabel("Checkbox")
        CatalogControlRow {
            listOf(false, true).forEach { initial ->
                CatalogLabeledControl(if (initial) "enabled on" else "enabled off") {
                    var checked by remember { mutableStateOf(initial) }
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it },
                        colors = CharcoalCheckboxDefaults.colors(),
                    )
                }
            }
        }
        CatalogControlRow {
            listOf(false, true).forEach { checked ->
                CatalogLabeledControl(if (checked) "disabled on" else "disabled off") {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = null,
                        enabled = false,
                        colors = CharcoalCheckboxDefaults.colors(),
                    )
                }
            }
        }

        CatalogSectionLabel("TriStateCheckbox")
        CatalogControlRow {
            triStates.forEach { initial ->
                CatalogLabeledControl("enabled ${initial.label()}") {
                    var state by remember { mutableStateOf(initial) }
                    TriStateCheckbox(
                        state = state,
                        onClick = { state = state.next() },
                        colors = CharcoalCheckboxDefaults.colors(),
                    )
                }
            }
        }
        CatalogControlRow {
            triStates.forEach { state ->
                CatalogLabeledControl("disabled ${state.label()}") {
                    TriStateCheckbox(
                        state = state,
                        onClick = null,
                        enabled = false,
                        colors = CharcoalCheckboxDefaults.colors(),
                    )
                }
            }
        }
    }
}

private val triStates = listOf(
    ToggleableState.Off,
    ToggleableState.On,
    ToggleableState.Indeterminate,
)

private fun ToggleableState.next(): ToggleableState = when (this) {
    ToggleableState.Off -> ToggleableState.On
    ToggleableState.On -> ToggleableState.Indeterminate
    ToggleableState.Indeterminate -> ToggleableState.Off
}

private fun ToggleableState.label(): String = when (this) {
    ToggleableState.Off -> "off"
    ToggleableState.On -> "on"
    ToggleableState.Indeterminate -> "Indeterminate"
}

@PreviewLightDark
@Composable
private fun M3CheckboxCatalogPreview() {
    M3CheckboxCatalog(onNavigationClick = {})
}
