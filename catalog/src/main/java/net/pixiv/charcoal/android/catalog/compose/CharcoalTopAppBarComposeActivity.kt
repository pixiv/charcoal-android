package net.pixiv.charcoal.android.catalog.compose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.pixiv.charcoal.android.compose.component.topAppBar.CharcoalTopAppBar
import net.pixiv.charcoal.android.compose.component.topAppBar.CharcoalTopAppBarStyle
import net.pixiv.charcoal.android.compose.component.topAppBar.createTopAppBarActions
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

class CharcoalTopAppBarComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBarCatalog(
                onNavigationClick = { finish() },
            )
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CharcoalTopAppBarComposeActivity::class.java)
        }
    }
}

@Composable
private fun TopAppBarCatalog(
    onNavigationClick: (() -> Unit),
) {
    CharcoalTheme {
        Scaffold(
            topBar = {
                CharcoalTopAppBar(
                    title = { Text(text = "CharcoalTopAppBar") },
                    navigationIcon = {
                        IconButton(onClick = { onNavigationClick() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = null
                            )
                        }
                    }
                )
            },
            backgroundColor = CharcoalTheme.colorToken.background2
        ) { innerPadding ->
            val states = mutableListOf(
                TopAppBarSampleSetting(
                    titleText = "Default",
                    style = CharcoalTopAppBarStyle.default()
                ),
                TopAppBarSampleSetting(
                    titleText = "Overlay",
                    style = CharcoalTopAppBarStyle.overlay(),
                    background = CharcoalTheme.colorToken.surface3
                ),
            )
            TopAppBarList(
                modifier = Modifier.padding(innerPadding),
                topAppBarSettings = states
            )
        }
    }
}

@Composable
private fun TopAppBarList(
    modifier: Modifier = Modifier,
    topAppBarSettings: List<TopAppBarSampleSetting>
) {
    LazyColumn(modifier = modifier) {
        items(topAppBarSettings) {
            CharcoalTopAppBarSample(topAppBarSetting = it)
        }
    }
}

@Composable
private fun CharcoalTopAppBarSample(topAppBarSetting: TopAppBarSampleSetting) {
    val modifier = topAppBarSetting.background?.let {
        Modifier
            .background(color = it)
            .padding(16.dp)
    } ?: Modifier.padding(16.dp)

    Column(
        modifier = modifier,
    ) {
        CharcoalTopAppBar(
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            },
            title = {
                Text(text = topAppBarSetting.titleText)
            },
            actions = createTopAppBarActions {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.Edit, contentDescription = null)
                }
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.Share, contentDescription = null)
                }
            },
            style = topAppBarSetting.style
        )
    }
}

@Preview
@Composable
private fun CharcoalTopAppBarSamplePreview() {
    CharcoalTheme {
        Surface(
            color = CharcoalTheme.colorToken.background1
        ) {
            CharcoalTopAppBarSample(
                TopAppBarSampleSetting(
                    titleText = "Default",
                    style = CharcoalTopAppBarStyle.default()
                )
            )
        }
    }
}

@Immutable
private data class TopAppBarSampleSetting(
    val background: Color? = null,
    val titleText: String,
    val style: CharcoalTopAppBarStyle
)

@Preview
@Composable
private fun Preview() {
    TopAppBarCatalog(onNavigationClick = {})
}
