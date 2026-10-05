package net.pixiv.charcoal.android.catalog.compose.m3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import net.pixiv.charcoal.android.compose.m3.component.CharcoalDividerDefaults
import net.pixiv.charcoal.android.compose.theme.CharcoalTheme

/** Material3 版の実装一覧。各項目から個別の画面へ遷移する。 */
class CatalogComposeM3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatalogComposeM3(
                onNavigationClick = { finish() },
                onPageClick = { startActivity(it.createIntent(this)) },
            )
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CatalogComposeM3Activity::class.java)
        }
    }
}

/** 一覧に並べる画面。 */
internal enum class CatalogComposeM3Page(val title: String) {
    Button("Button"),
    Checkbox("Checkbox"),
    Switch("Switch"),
    RadioButton("RadioButton"),
    AlertDialog("AlertDialog"),
    Tab("Tab"),
    TopAppBar("TopAppBar"),
    ;

    fun createIntent(context: Context): Intent = when (this) {
        Button -> CatalogM3ButtonActivity.createIntent(context)
        Checkbox -> CatalogM3CheckboxActivity.createIntent(context)
        Switch -> CatalogM3SwitchActivity.createIntent(context)
        RadioButton -> CatalogM3RadioButtonActivity.createIntent(context)
        AlertDialog -> CatalogM3AlertDialogActivity.createIntent(context)
        Tab -> CatalogM3TabActivity.createIntent(context)
        TopAppBar -> CatalogM3TopAppBarActivity.createIntent(context)
    }
}

@Composable
private fun CatalogComposeM3(
    onNavigationClick: () -> Unit,
    onPageClick: (CatalogComposeM3Page) -> Unit,
) {
    CatalogComposeM3Scaffold(
        title = "Compose Catalog (Material 3)",
        onNavigationClick = onNavigationClick,
        contentPadding = PaddingValues(0.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        CatalogComposeM3Page.entries.forEach { page ->
            CatalogPageRow(title = page.title, onClick = { onPageClick(page) })
            HorizontalDivider(color = CharcoalDividerDefaults.color)
        }
    }
}

@Composable
private fun CatalogPageRow(
    title: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clickable { onClick() }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = title, color = CharcoalTheme.colorToken.text1)
    }
}

@PreviewLightDark
@Composable
private fun CatalogComposeM3Preview() {
    CatalogComposeM3(onNavigationClick = {}, onPageClick = {})
}
