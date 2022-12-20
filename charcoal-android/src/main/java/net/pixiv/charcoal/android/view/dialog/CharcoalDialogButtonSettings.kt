package net.pixiv.charcoal.android.view.dialog

/**
 * [CharcoalDialogFragment] にボタンの表示数、文言、選択時に取得するイベントクラスを設定する。
 */
sealed class CharcoalDialogButtonSettings {
    /**
     * ボタンを1つ表示したい場合に利用する。
     *
     * @property primaryButtonText 1つ目のボタンに表示する文言
     * @property primaryButtonEvent 1つ目のボタンが押下されたときに取得できる [CharcoalDialogEvent] を実装したクラス
     */
    data class OneButton(
        val primaryButtonText: String,
        val primaryButtonEvent: CharcoalDialogEvent? = null
    ) : CharcoalDialogButtonSettings()

    /**
     * ボタンを2つ表示したい場合に利用する。
     *
     * @property primaryButtonText 1つ目のボタンに表示する文言
     * @property primaryButtonEvent 1つ目のボタンが押下されたときに取得できる [CharcoalDialogEvent] を実装したクラス
     * @property secondaryButtonText 2つ目のボタンに表示する文言
     * @property secondaryButtonEvent 2つ目のボタンが押下されたときに取得できる [CharcoalDialogEvent] を実装したクラス
     */
    data class TwoButtons(
        val primaryButtonText: String,
        val primaryButtonEvent: CharcoalDialogEvent? = null,
        val secondaryButtonText: String,
        val secondaryButtonEvent: CharcoalDialogEvent? = null
    ) : CharcoalDialogButtonSettings()

    /**
     * ボタンを3つ表示したい場合に利用する。
     *
     * @property primaryButtonText 1つ目のボタンに表示する文言
     * @property primaryButtonEvent 1つ目のボタンが押下されたときに取得できる [CharcoalDialogEvent] を実装したクラス
     * @property secondaryButtonText 2つ目のボタンに表示する文言
     * @property secondaryButtonEvent 2つ目のボタンが押下されたときに取得できる [CharcoalDialogEvent] を実装したクラス
     * @property tertiaryButtonText 3つ目のボタンに表示する文言
     * @property tertiaryButtonEvent 3つ目のボタンが押下されたときに取得できる [CharcoalDialogEvent] を実装したクラス
     */
    data class ThreeButtons(
        val primaryButtonText: String,
        val primaryButtonEvent: CharcoalDialogEvent? = null,
        val secondaryButtonText: String,
        val secondaryButtonEvent: CharcoalDialogEvent? = null,
        val tertiaryButtonText: String,
        val tertiaryButtonEvent: CharcoalDialogEvent? = null
    ) : CharcoalDialogButtonSettings()
}
