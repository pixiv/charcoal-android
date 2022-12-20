package net.pixiv.charcoal.android.compose

import android.content.res.AssetManager
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import net.pixiv.charcoal.android.compose.generated.CharcoalFoundation

fun createCharcoalInstance(assets: AssetManager): CharcoalFoundation {
    val inputStream = assets.open("generated/CharcoalFoundation.json")
    val jsonString = inputStream.bufferedReader().use { it.readText() }
    return Json.decodeFromString(jsonString)
}
