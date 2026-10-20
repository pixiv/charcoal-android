package net.pixiv.charcoal.android.catalog.compose.m3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import net.pixiv.charcoal.android.compose.m3.component.CharcoalTopAppBarDefaults
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

/** TopAppBar の一覧。navigationIcon / actionIcon を text3 にした colors() を渡す。 */
class CatalogM3TopAppBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M3TopAppBarCatalog(onNavigationClick = { finish() })
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CatalogM3TopAppBarActivity::class.java)
        }
    }
}

@Composable
private fun M3TopAppBarCatalog(onNavigationClick: () -> Unit) {
    CatalogComposeM3Scaffold(
        title = "TopAppBar",
        onNavigationClick = onNavigationClick,
    ) {
        CatalogSectionLabel("defaultColors")
        TopAppBar(
            title = { Text("タイトル") },
            navigationIcon = { BackIcon() },
            actions = { MoreIcon() },
            colors = CharcoalTopAppBarDefaults.defaultColors(),
        )

        CatalogSectionLabel("overlayColors")
        Box {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(CharcoalTheme.colorToken.surface6),
            )
            TopAppBar(
                title = { Text("タイトル") },
                navigationIcon = { BackIcon() },
                actions = { MoreIcon() },
                colors = CharcoalTopAppBarDefaults.overlayColors(),
            )
        }
    }
}

@Composable
private fun BackIcon() {
    IconButton(onClick = {}) {
        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
    }
}

@Composable
private fun MoreIcon() {
    IconButton(onClick = {}) {
        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = null)
    }
}

@PreviewLightDark
@Composable
private fun M3TopAppBarCatalogPreview() {
    M3TopAppBarCatalog(onNavigationClick = {})
}
