package net.pixiv.charcoal.android.catalog.compose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.pixiv.charcoal.android.compose.component.CharcoalDivider
import net.pixiv.charcoal.android.compose.component.topAppBar.CharcoalTopAppBar
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

class CharcoalTypographyComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TypographyCatalog(
                onNavigationClick = { finish() },
            )
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CharcoalTypographyComposeActivity::class.java)
        }
    }
}

@Composable
private fun TypographyCatalog(
    onNavigationClick: (() -> Unit),
) {
    CharcoalTheme {
        Scaffold(
            topBar = {
                CharcoalTopAppBar(
                    title = { Text(text = "Compose Typography") },
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
            )
        }
    }
}

@Composable
private fun BodyContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {
        TypographyDisplay(label = "Regular 20", textStyle = CharcoalTheme.typography.regular20)
        CharcoalDivider()
        TypographyDisplay(label = "Bold 20", textStyle = CharcoalTheme.typography.bold20)
        CharcoalDivider()
        TypographyDisplay(label = "Mono 20", textStyle = CharcoalTheme.typography.mono20)
        CharcoalDivider()
        TypographyDisplay(label = "Mono Bold 20", textStyle = CharcoalTheme.typography.boldMono20)
        CharcoalDivider()

        TypographyDisplay(label = "Regular 16", textStyle = CharcoalTheme.typography.regular16)
        CharcoalDivider()
        TypographyDisplay(label = "Bold 16", textStyle = CharcoalTheme.typography.bold16)
        CharcoalDivider()
        TypographyDisplay(label = "Mono 16", textStyle = CharcoalTheme.typography.mono16)
        CharcoalDivider()
        TypographyDisplay(label = "Mono Bold 16", textStyle = CharcoalTheme.typography.boldMono16)
        CharcoalDivider()

        TypographyDisplay(label = "Regular 14", textStyle = CharcoalTheme.typography.regular14)
        CharcoalDivider()
        TypographyDisplay(label = "Bold 14", textStyle = CharcoalTheme.typography.bold14)
        CharcoalDivider()
        TypographyDisplay(label = "Mono 14", textStyle = CharcoalTheme.typography.mono14)
        CharcoalDivider()
        TypographyDisplay(label = "Mono Bold 14", textStyle = CharcoalTheme.typography.boldMono14)
        CharcoalDivider()

        TypographyDisplay(label = "Regular 12", textStyle = CharcoalTheme.typography.regular12)
        CharcoalDivider()
        TypographyDisplay(label = "Bold 12", textStyle = CharcoalTheme.typography.bold12)
        CharcoalDivider()
        TypographyDisplay(label = "Mono 12", textStyle = CharcoalTheme.typography.mono12)
        CharcoalDivider()
        TypographyDisplay(label = "Mono Bold 12", textStyle = CharcoalTheme.typography.boldMono12)
        CharcoalDivider()

        TypographyDisplay(label = "Regular 10", textStyle = CharcoalTheme.typography.regular10)
        CharcoalDivider()
        TypographyDisplay(label = "Bold 10", textStyle = CharcoalTheme.typography.bold10)
        CharcoalDivider()
        TypographyDisplay(label = "Mono 10", textStyle = CharcoalTheme.typography.mono10)
        CharcoalDivider()
        TypographyDisplay(label = "Mono Bold 10", textStyle = CharcoalTheme.typography.boldMono10)
        CharcoalDivider()
    }
}

@Composable
private fun TypographyDisplay(
    label: String,
    textStyle: TextStyle
) {
    Column {
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = label,
            style = textStyle,
            color = CharcoalTheme.colorToken.text2
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "$label multi line Lorem ipsum dolor sit amet, consectetur adipisicing elit," +
                " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            style = textStyle,
            color = CharcoalTheme.colorToken.text2
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "$label 日本語 親譲りの無鉄砲で小供の時から損ばかりしている。" +
                "小学校に居る時分学校の二階から飛び降りて一週間ほど腰を抜かした事がある。",
            style = textStyle,
            color = CharcoalTheme.colorToken.text2
        )
        Spacer(modifier = Modifier.size(16.dp))
    }
}

@Preview
@Composable
private fun Preview() {
    TypographyCatalog(onNavigationClick = {})
}
