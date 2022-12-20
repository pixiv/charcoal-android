// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json               = Json { allowStructuredMapKeys = true }
// val charcoalFoundation = json.parse(CharcoalFoundation.serializer(), jsonString)

package net.pixiv.charcoal.android.compose.generated

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class CharcoalFoundation (
    val borderRadius: BorderRadius,
    val spacing: Spacing,
    val typography: Typography,
    val color: Color
)

@Serializable
data class BorderRadius (
    @SerialName("4")
    val the4: Long,

    @SerialName("8")
    val the8: Long,

    @SerialName("16")
    val the16: Long,

    @SerialName("24")
    val the24: Long,

    val none: Long,
    val oval: Long
)

@Serializable
data class Color (
    val transparent: Assertive,
    val background1: Assertive,
    val background2: Assertive,
    val icon6: Assertive,
    val link1: Assertive,
    val link2: Assertive,
    val surface1: Assertive,
    val surface2: Assertive,
    val surface3: Assertive,
    val surface4: Assertive,
    val surface6: Assertive,
    val surface7: Assertive,
    val surface8: Assertive,
    val surface9: Assertive,
    val surface10: Assertive,
    val text1: Assertive,
    val text2: Assertive,
    val text3: Assertive,
    val text4: Assertive,
    val text5: Assertive,
    val brand: Assertive,
    val assertive: Assertive,
    val warning: Assertive,
    val success: Assertive,
    val updatedItem: Assertive,
    val border: Assertive
)

@Serializable
data class Assertive (
    val red: Double,
    val green: Double,
    val blue: Double,
    val alpha: Double
)

@Serializable
data class Spacing (
    @SerialName("0")
    val the0: Long,

    @SerialName("4")
    val the4: Long,

    @SerialName("8")
    val the8: Long,

    @SerialName("16")
    val the16: Long,

    @SerialName("24")
    val the24: Long,

    @SerialName("40")
    val the40: Long,

    @SerialName("64")
    val the64: Long,

    @SerialName("104")
    val the104: Long,

    @SerialName("168")
    val the168: Long,

    @SerialName("272")
    val the272: Long,

    @SerialName("440")
    val the440: Long
)

@Serializable
data class Typography (
    val size: Size
)

@Serializable
data class Size (
    @SerialName("12")
    val the12: The12,

    @SerialName("14")
    val the14: The12,

    @SerialName("16")
    val the16: The12,

    @SerialName("20")
    val the20: The12,

    @SerialName("32")
    val the32: The12
)

@Serializable
data class The12 (
    val fontSize: Long,
    val lineHeight: Long
)
