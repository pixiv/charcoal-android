package net.pixiv.charcoal.android.catalog.compose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.pixiv.charcoal.android.compose.component.radioButton.CharcoalRadioButton
import net.pixiv.charcoal.android.compose.component.topAppBar.CharcoalTopAppBar
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

class CharcoalRadioButtonComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RadioButtonCatalog(
                onNavigationClick = { finish() },
            )
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CharcoalRadioButtonComposeActivity::class.java)
        }
    }
}

@Composable
private fun RadioButtonCatalog(
    onNavigationClick: (() -> Unit),
) {
    CharcoalTheme {
        Scaffold(
            topBar = {
                CharcoalTopAppBar(
                    title = { Text(text = "CharcoalRadioButton") },
                    navigationIcon = {
                        IconButton(onClick = { onNavigationClick() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = null
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            val states = mutableListOf(
                RadioButtonState(enabled = true, selected = false),
                RadioButtonState(enabled = true, selected = true),
                RadioButtonState(enabled = false, selected = false),
                RadioButtonState(enabled = false, selected = true),
            )

            RadioButtonGrid(
                modifier = Modifier.padding(innerPadding),
                radioButtonStates = states
            )
        }
    }
}

@Composable
private fun RadioButtonGrid(
    modifier: Modifier = Modifier,
    radioButtonStates: List<RadioButtonState>
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
    ) {
        items(radioButtonStates) {
            CharcoalRadioButtonSample(radioButtonState = it)
        }
    }
}

@Composable
private fun CharcoalRadioButtonSample(radioButtonState: RadioButtonState) {
    var selectedState by remember { mutableStateOf(radioButtonState.selected) }

    Row(
        modifier = Modifier
            .toggleable(
                value = selectedState,
                role = Role.RadioButton,
                enabled = radioButtonState.enabled,
                onValueChange = { selectedState = !selectedState }
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CharcoalRadioButton(
            selected = selectedState,
            enabled = radioButtonState.enabled,
            onClick = null
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = radioButtonState.displayString())
    }
}

private fun RadioButtonState.displayString(): String =
    "enabled = ${this.enabled}, checked = ${this.selected}"

@Preview
@Composable
private fun RadioButtonSamplePreview() {
    CharcoalTheme {
        Surface(
            color = CharcoalTheme.colorToken.background1
        ) {
            CharcoalRadioButtonSample(
                RadioButtonState(enabled = true, selected = false)
            )
        }
    }
}

@Immutable
private data class RadioButtonState(
    val enabled: Boolean,
    val selected: Boolean
)

@Preview
@Composable
private fun Preview() {
    RadioButtonCatalog(onNavigationClick = {})
}
