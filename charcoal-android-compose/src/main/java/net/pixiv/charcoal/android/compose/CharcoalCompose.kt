package net.pixiv.charcoal.android.compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// TODO Compose の動作確認のため一時的に用意したので、コンポーネントが追加され始めたら削除する
@Composable
fun CharcoalCompose() {
    val instance = createCharcoalInstance(LocalContext.current.assets)
    Text(text = "charcoal-android-compose ${instance.spacing.the104}")
}
