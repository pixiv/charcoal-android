package net.pixiv.charcoal.android.view.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import net.pixiv.charcoal.android.R
import net.pixiv.charcoal.android.view.button.CharcoalButton

/**
 * Charcoal のポップアップ実装。
 */
class CharcoalDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.ThemeOverlay_Charcoal_Dialog_CharcoalDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_charcoal_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arguments = requireArguments()
        view.findViewById<TextView>(R.id.title).text = arguments.getString(ARGUMENTS_TITLE)

        setupDescription(arguments, view)
        setupImageRes(arguments, view)

        isCancelable = arguments.getBoolean(ARGUMENTS_IS_CANCELABLE)
        setupCloseButton(view, isCancelable, arguments)

        setupButtons(view, arguments)
    }

    private fun setupCloseButton(view: View, isCancelable: Boolean, arguments: Bundle) {
        val cancelButtonColoredBackground =
            arguments.getBoolean(ARGUMENTS_CANCEL_BUTTON_COLORED_BACKGROUND, false)
        val closeButtonId =
            if (cancelButtonColoredBackground) R.id.close_button_background else R.id.close_button
        val closeButton = view.findViewById<ImageView>(closeButtonId)

        if (isCancelable) {
            closeButton.setOnClickListener { dismiss() }
            closeButton.visibility = View.VISIBLE
        }
    }

    private fun setupButtons(view: View, arguments: Bundle) {
        view.findViewById<CharcoalButton>(R.id.primary_button).let {
            it.text = arguments.getString(ARGUMENTS_PRIMARY_BUTTON_TEXT)
            it.setOnClickListener {
                arguments.getParcelable<CharcoalDialogEvent>(ARGUMENTS_PRIMARY_BUTTON_EVENT)
                    ?.let(::setFragmentResult)
                dismiss()
            }
        }

        view.findViewById<CharcoalButton>(R.id.secondary_button).let {
            val label = arguments.getString(ARGUMENTS_SECOND_BUTTON_TEXT)
            if (label == null) {
                it.visibility = View.GONE
            } else {
                it.text = label
                it.setOnClickListener {
                    arguments.getParcelable<CharcoalDialogEvent>(ARGUMENTS_SECOND_BUTTON_EVENT)
                        ?.let(::setFragmentResult)
                    dismiss()
                }
            }
        }

        view.findViewById<CharcoalButton>(R.id.tertiary_button).let {
            val label = arguments.getString(ARGUMENTS_TERTIARY_BUTTON_TEXT)
            if (label == null) {
                it.visibility = View.GONE
            } else {
                it.text = label
                it.setOnClickListener {
                    arguments.getParcelable<CharcoalDialogEvent>(ARGUMENTS_TERTIARY_BUTTON_EVENT)
                        ?.let(::setFragmentResult)
                    dismiss()
                }
            }
        }
    }

    private fun setupDescription(arguments: Bundle, view: View) {
        val description = arguments.getString(ARGUMENTS_DESCRIPTION)
        val descriptionTextView = view.findViewById<TextView>(R.id.description)
        if (description == null) {
            descriptionTextView.visibility = View.GONE
        } else {
            descriptionTextView.text = description
        }
    }

    private fun setupImageRes(arguments: Bundle, view: View) {
        if (!arguments.containsKey(ARGUMENTS_IMAGE_RES)) return

        val imageRes = arguments.getInt(ARGUMENTS_IMAGE_RES)
        val imageView = view.findViewById<ImageView>(R.id.image)
        imageView.setImageResource(imageRes)
        imageView.visibility = View.VISIBLE
    }

    private fun setFragmentResult(dialogEvent: CharcoalDialogEvent) {
        val requestKey = checkNotNull(requireArguments().getString(ARGUMENTS_REQUEST_KEY))

        parentFragmentManager.setFragmentResult(
            requestKey,
            bundleOf(FRAGMENT_RESULT_KEY_CHARCOAL_DIALOG_EVENT to dialogEvent)
        )
    }

    companion object {
        /**
         * setFragmentResultListener の requestKey に設定するデフォルト値
         */
        const val FRAGMENT_REQUEST_KEY = "fragment_request_key_charcoal_dialog_fragment"

        /**
         * FragmentResultListener にて Bundle から CharcoalDialogEvent を受け取るための key
         */
        const val FRAGMENT_RESULT_KEY_CHARCOAL_DIALOG_EVENT =
            "fragment_result_key_charcoal_dialog_event"
        private const val ARGUMENTS_TITLE = "arguments_title"
        private const val ARGUMENTS_DESCRIPTION = "arguments_description"
        private const val ARGUMENTS_IMAGE_RES = "arguments_image_res"
        private const val ARGUMENTS_PRIMARY_BUTTON_TEXT = "arguments_primary_button_text"
        private const val ARGUMENTS_PRIMARY_BUTTON_EVENT = "arguments_primary_button_event"
        private const val ARGUMENTS_SECOND_BUTTON_TEXT = "arguments_secondary_button_text"
        private const val ARGUMENTS_SECOND_BUTTON_EVENT = "arguments_second_button_event"
        private const val ARGUMENTS_TERTIARY_BUTTON_TEXT = "arguments_tertiary_button_text"
        private const val ARGUMENTS_TERTIARY_BUTTON_EVENT = "arguments_tertiary_button_event"
        private const val ARGUMENTS_IS_CANCELABLE = "arguments_is_cancelable"
        private const val ARGUMENTS_CANCEL_BUTTON_COLORED_BACKGROUND =
            "arguments_cancel_button_colored_background"

        /**
         * FragmentResultListener に設定する requestKey を保持するための Bundle key
         */
        private const val ARGUMENTS_REQUEST_KEY = "arguments_request_key"

        /**
         * CharcoalDialogFragment に arguments を設定したインスタンスを取得する。
         *
         * @param title ポップアップのタイトル
         * @param message ポップアップのメッセージ
         * @param buttonSettings [CharcoalDialogButtonSettings] を利用したボタン表示設定
         * @param isCancelable ダイアログをキャンセルできるか。キャンセルできる場合は閉じるボタンを表示する。
         * @param requestKey Fragment Result Listener で利用する requestKey
         * @return arguments が設定された CharcoalDialogFragment のインスタンス
         */
        fun newInstance(
            title: String,
            message: String? = null,
            @DrawableRes imageRes: Int? = null,
            buttonSettings: CharcoalDialogButtonSettings,
            isCancelable: Boolean = true,
            cancelButtonColoredBackground: Boolean = false,
            requestKey: String = FRAGMENT_REQUEST_KEY
        ): CharcoalDialogFragment {
            return CharcoalDialogFragment().also { fragment ->
                fragment.arguments = Bundle().also { bundle ->
                    bundle.putString(ARGUMENTS_TITLE, title)
                    message?.let { bundle.putString(ARGUMENTS_DESCRIPTION, it) }
                    imageRes?.let { bundle.putInt(ARGUMENTS_IMAGE_RES, it) }

                    bundle.applyButtonArguments(buttonSettings)

                    bundle.putBoolean(ARGUMENTS_IS_CANCELABLE, isCancelable)
                    bundle.putBoolean(
                        ARGUMENTS_CANCEL_BUTTON_COLORED_BACKGROUND,
                        cancelButtonColoredBackground
                    )
                    bundle.putString(ARGUMENTS_REQUEST_KEY, requestKey)
                }
            }
        }

        private fun Bundle.applyButtonArguments(buttonSettings: CharcoalDialogButtonSettings) {
            when (buttonSettings) {
                is CharcoalDialogButtonSettings.OneButton -> {
                    this.putString(ARGUMENTS_PRIMARY_BUTTON_TEXT, buttonSettings.primaryButtonText)
                    buttonSettings.primaryButtonEvent?.let {
                        this.putParcelable(
                            ARGUMENTS_PRIMARY_BUTTON_EVENT, it
                        )
                    }
                }
                is CharcoalDialogButtonSettings.TwoButtons -> {
                    this.putString(ARGUMENTS_PRIMARY_BUTTON_TEXT, buttonSettings.primaryButtonText)
                    buttonSettings.primaryButtonEvent?.let {
                        this.putParcelable(
                            ARGUMENTS_PRIMARY_BUTTON_EVENT, it
                        )
                    }
                    this.putString(ARGUMENTS_SECOND_BUTTON_TEXT, buttonSettings.secondaryButtonText)
                    buttonSettings.secondaryButtonEvent?.let {
                        this.putParcelable(
                            ARGUMENTS_SECOND_BUTTON_EVENT, it
                        )
                    }
                }
                is CharcoalDialogButtonSettings.ThreeButtons -> {
                    this.putString(ARGUMENTS_PRIMARY_BUTTON_TEXT, buttonSettings.primaryButtonText)
                    buttonSettings.primaryButtonEvent?.let {
                        this.putParcelable(
                            ARGUMENTS_PRIMARY_BUTTON_EVENT, it
                        )
                    }
                    this.putString(ARGUMENTS_SECOND_BUTTON_TEXT, buttonSettings.secondaryButtonText)
                    buttonSettings.secondaryButtonEvent?.let {
                        this.putParcelable(
                            ARGUMENTS_SECOND_BUTTON_EVENT, it
                        )
                    }
                    this.putString(
                        ARGUMENTS_TERTIARY_BUTTON_TEXT,
                        buttonSettings.tertiaryButtonText
                    )
                    buttonSettings.tertiaryButtonEvent?.let {
                        this.putParcelable(
                            ARGUMENTS_TERTIARY_BUTTON_EVENT, it
                        )
                    }
                }
            }
        }
    }
}
