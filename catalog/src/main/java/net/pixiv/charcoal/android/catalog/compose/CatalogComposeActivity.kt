package net.pixiv.charcoal.android.catalog.compose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.pixiv.charcoal.android.compose.component.topAppBar.CharcoalTopAppBar
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

class CatalogComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatalogCompose(
                onNavigationClick = { finish() },
                onRedirect = { redirect(it) }
            )
        }
    }

    private fun redirect(pattern: RedirectPattern) {
        when (pattern) {
            RedirectPattern.TopAppBar -> startActivity(
                CharcoalTopAppBarComposeActivity.createIntent(
                    this
                )
            )
            RedirectPattern.RadioButton -> startActivity(
                CharcoalRadioButtonComposeActivity.createIntent(this)
            )
            RedirectPattern.Typography -> startActivity(
                CharcoalTypographyComposeActivity.createIntent(this)
            )
            RedirectPattern.Dropdown -> startActivity(
                CharcoalDropdownComposeActivity.createIntent(this)
            )
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CatalogComposeActivity::class.java)
        }
    }
}

private sealed class RedirectPattern {
    object TopAppBar : RedirectPattern()
    object RadioButton : RedirectPattern()
    object Typography : RedirectPattern()
    object Dropdown : RedirectPattern()
}

@Composable
private fun CatalogCompose(
    onNavigationClick: (() -> Unit),
    onRedirect: ((RedirectPattern) -> Unit)
) {
    CharcoalTheme {
        Scaffold(
            topBar = {
                CharcoalTopAppBar(
                    title = { Text(text = "Compose Catalog") },
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
            BodyContent(
                modifier = Modifier.padding(innerPadding),
                onRedirect = onRedirect
            )
        }
    }
}

@Composable
private fun BodyContent(
    modifier: Modifier = Modifier,
    onRedirect: (RedirectPattern) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {
        ContentColumn(text = "TopAppBar", onClick = { onRedirect(RedirectPattern.TopAppBar) })
        ContentColumn(text = "RadioButton", onClick = { onRedirect(RedirectPattern.RadioButton) })
        ContentColumn(text = "Typography", onClick = { onRedirect(RedirectPattern.Typography) })
        ContentColumn(text = "Dropdown", onClick = { onRedirect(RedirectPattern.Dropdown) })
    }
}

@Composable
private fun ContentColumn(
    text: String,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .height(56.dp)
            .padding(start = 16.dp)
    ) {
        Text(
            text = text,
            color = CharcoalTheme.colorToken.text1
        )
    }
}

@Preview
@Composable
private fun PreviewContent() {
    CatalogCompose(onNavigationClick = {}, onRedirect = {})
}
