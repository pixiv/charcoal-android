package net.pixiv.charcoal.android.catalog.compose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import net.pixiv.charcoal.android.compose.component.dropdown.CharcoalDropdown1
import net.pixiv.charcoal.android.compose.component.dropdown.CharcoalDropdown2
import net.pixiv.charcoal.android.compose.component.textfield.CharcoalTextField
import net.pixiv.charcoal.android.compose.component.topAppBar.CharcoalTopAppBar
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

class CharcoalDropdownComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DropdownCatalog(
                onNavigationClick = { finish() },
            )
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CharcoalDropdownComposeActivity::class.java)
        }
    }
}

@Composable
private fun DropdownCatalog(
    onNavigationClick: (() -> Unit),
) {
    var selectedOption by remember { mutableStateOf("Apple") }
    var options by remember { mutableStateOf(mutableListOf("Apple", "Orange", "Banana")) }

    var text by remember { mutableStateOf("Hoge") }

    CharcoalTheme {
        Scaffold(
            topBar = {
                CharcoalTopAppBar(
                    title = { Text(text = "CharcoalDropdown") },
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
        ) {
            Column {
                CharcoalDropdown1(
                    selectedOption = selectedOption,
                    options = options,
                    onValueChange = { index ->
                        selectedOption = options[index]
                    }
                )
                CharcoalDropdown2(
                    selectedOption = selectedOption,
                    options = options,
                    onValueChange = { index ->
                        selectedOption = options[index]
                    }
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1.0f),
                    value = text,
                    onValueChange = { value -> text = value},
                    textStyle = CharcoalTheme.typography.regular14,
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = CharcoalTheme.colorToken.surface3)
                )
                CharcoalTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1.0f),
                    value = text,
                    onValueChange = { value -> text = value}
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    DropdownCatalog(onNavigationClick = {})
}
