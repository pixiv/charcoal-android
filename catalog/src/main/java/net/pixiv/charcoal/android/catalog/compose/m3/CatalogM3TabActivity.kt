package net.pixiv.charcoal.android.catalog.compose.m3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import net.pixiv.charcoal.android.compose.m3.component.CharcoalTabDefaults

/** Tab の一覧。SecondaryTabRow に Charcoal のインジケータと配色を渡す。 */
class CatalogM3TabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M3TabCatalog(onNavigationClick = { finish() })
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CatalogM3TabActivity::class.java)
        }
    }
}

private val tabTitles = listOf("イラスト", "マンガ", "小説")

@Composable
private fun M3TabCatalog(onNavigationClick: () -> Unit) {
    CatalogComposeM3Scaffold(
        title = "Tab",
        onNavigationClick = onNavigationClick,
    ) {
        var selected by remember { mutableIntStateOf(0) }
        SecondaryTabRow(
            selectedTabIndex = selected,
            indicator = { CharcoalTabDefaults.Indicator(Modifier.tabIndicatorOffset(selected)) },
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selected == index,
                    onClick = { selected = index },
                    selectedContentColor = CharcoalTabDefaults.selectedContentColor,
                    unselectedContentColor = CharcoalTabDefaults.unselectedContentColor,
                    text = { Text(title) },
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun M3TabCatalogPreview() {
    M3TabCatalog(onNavigationClick = {})
}
