package net.pixiv.charcoal.android.catalog.dialog

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.wada811.viewbinding.viewBinding
import kotlinx.parcelize.Parcelize
import net.pixiv.charcoal.android.catalog.R
import net.pixiv.charcoal.android.catalog.databinding.ActivityDialogBinding
import net.pixiv.charcoal.android.catalog.extension.setSupportActionBarWithHomeButtonAndTitle
import net.pixiv.charcoal.android.view.dialog.CharcoalDialogButtonSettings
import net.pixiv.charcoal.android.view.dialog.CharcoalDialogEvent
import net.pixiv.charcoal.android.view.dialog.CharcoalDialogFragment

class DialogActivity : AppCompatActivity(R.layout.activity_dialog) {

    private val binding by viewBinding(ActivityDialogBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBarWithHomeButtonAndTitle(
            toolbar = binding.toolBar,
            title = "Dialog"
        )

        setupCharcoalDialog()

        binding.buttonAlertDialog1.setOnClickListener {
            AlertDialog.Builder(this)
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setNegativeButton(android.R.string.cancel) { _, _ -> }
                .setTitle(DIALOG_TITLE)
                .setMessage(DIALOG_DESCRIPTION)
                .show()
        }

        binding.buttonDialogFragment1.setOnClickListener {
            SampleDialogFragment().showNow(supportFragmentManager, DIALOG_TAG)
        }

        binding.buttonBottomSheetDialogFragment1.setOnClickListener {
            SampleBottomSheetDialogFragment().showNow(supportFragmentManager, DIALOG_TAG)
        }

        supportFragmentManager.setFragmentResultListener(
            CharcoalDialogFragment.FRAGMENT_REQUEST_KEY,
            this
        ) { _, result ->
            when (result.getParcelable<DialogActivityEvent>(CharcoalDialogFragment.FRAGMENT_RESULT_KEY_CHARCOAL_DIALOG_EVENT)) {
                DialogActivityEvent.SelectPrimaryButton -> {
                    Toast.makeText(this, "select primary button", Toast.LENGTH_SHORT).show()
                }
                DialogActivityEvent.SelectSecondaryButton -> {
                    Toast.makeText(this, "select secondary button", Toast.LENGTH_SHORT).show()
                }
                DialogActivityEvent.SelectTertiaryButton -> {
                    Toast.makeText(this, "select tertiary button", Toast.LENGTH_SHORT).show()
                }
                null -> {}
            }
        }
    }

    private fun setupCharcoalDialog() {
        binding.buttonCharcoalDialog1.setOnClickListener {
            val buttonSettings = CharcoalDialogButtonSettings.OneButton(primaryButtonText = getString(android.R.string.ok))

            CharcoalDialogFragment.newInstance(
                title = DIALOG_TITLE,
                message = DIALOG_DESCRIPTION,
                buttonSettings = buttonSettings,
                isCancelable = false
            ).showNow(supportFragmentManager, DIALOG_TAG)
        }

        binding.buttonCharcoalDialog2.setOnClickListener {
            val buttonSettings = CharcoalDialogButtonSettings.OneButton(
                primaryButtonText = getString(android.R.string.ok),
                primaryButtonEvent = DialogActivityEvent.SelectPrimaryButton
            )

            CharcoalDialogFragment.newInstance(
                title = "1つ目のボタンを押したことを検出する",
                message = "1つ目のボタンを押すと Toast が表示される",
                buttonSettings = buttonSettings,
                isCancelable = false
            ).showNow(supportFragmentManager, DIALOG_TAG)
        }

        binding.buttonCharcoalDialog3.setOnClickListener {
            val buttonSettings = CharcoalDialogButtonSettings.OneButton(primaryButtonText = getString(android.R.string.ok))

            CharcoalDialogFragment.newInstance(
                title = "description がない場合",
                buttonSettings = buttonSettings,
                isCancelable = false
            ).showNow(supportFragmentManager, DIALOG_TAG)
        }

        binding.buttonCharcoalDialog4.setOnClickListener {
            val buttonSettings = CharcoalDialogButtonSettings.TwoButtons(
                primaryButtonText = getString(android.R.string.ok),
                secondaryButtonText = "second"
            )

            CharcoalDialogFragment.newInstance(
                title = "2つめのボタンが存在する場合",
                buttonSettings = buttonSettings,
                isCancelable = false
            ).showNow(supportFragmentManager, DIALOG_TAG)
        }

        binding.buttonCharcoalDialog5.setOnClickListener {
            val buttonSettings = CharcoalDialogButtonSettings.TwoButtons(
                primaryButtonText = getString(android.R.string.ok),
                secondaryButtonText = "second",
                secondaryButtonEvent = DialogActivityEvent.SelectSecondaryButton
            )

            CharcoalDialogFragment.newInstance(
                title = "2つ目のボタンを押したことを検出する",
                message = "2つ目のボタンを押すと Toast が表示される",
                buttonSettings = buttonSettings,
                isCancelable = false
            ).showNow(supportFragmentManager, DIALOG_TAG)
        }

        binding.buttonCharcoalDialog6.setOnClickListener {
            val buttonSettings = CharcoalDialogButtonSettings.ThreeButtons(
                primaryButtonText = getString(android.R.string.ok),
                secondaryButtonText = "second",
                tertiaryButtonText = "third"
            )

            CharcoalDialogFragment.newInstance(
                title = "3つめのボタンが存在する場合",
                buttonSettings = buttonSettings,
                isCancelable = false
            ).showNow(supportFragmentManager, DIALOG_TAG)
        }

        binding.buttonCharcoalDialog7.setOnClickListener {
            val buttonSettings = CharcoalDialogButtonSettings.ThreeButtons(
                primaryButtonText = getString(android.R.string.ok),
                secondaryButtonText = "second",
                tertiaryButtonText = "third",
                tertiaryButtonEvent = DialogActivityEvent.SelectTertiaryButton
            )

            CharcoalDialogFragment.newInstance(
                title = "3つ目のボタンを押したことを検出する",
                message = "3つ目のボタンを押すと Toast が表示される",
                buttonSettings = buttonSettings,
                isCancelable = false
            ).showNow(supportFragmentManager, DIALOG_TAG)
        }

        binding.buttonCharcoalDialog8.setOnClickListener {
            val buttonSettings = CharcoalDialogButtonSettings.ThreeButtons(
                primaryButtonText = getString(android.R.string.ok),
                secondaryButtonText = "second",
                tertiaryButtonText = "third"
            )

            CharcoalDialogFragment.newInstance(
                title = "キャンセル可能",
                message = "×ボタン、もしくはダイアログの外側の選択するとダイアログが消える",
                buttonSettings = buttonSettings,
                isCancelable = true
            ).showNow(supportFragmentManager, DIALOG_TAG)
        }

        binding.buttonCharcoalDialog9.setOnClickListener {
            val buttonSettings = CharcoalDialogButtonSettings.TwoButtons(
                primaryButtonText = getString(android.R.string.ok),
                secondaryButtonText = "second"
            )

            CharcoalDialogFragment.newInstance(
                title = "画像つき",
                message = "画像つきダイアログ",
                imageRes = R.drawable.dialog_sample_image,
                buttonSettings = buttonSettings,
                isCancelable = false
            ).showNow(supportFragmentManager, DIALOG_TAG)
        }

        binding.buttonCharcoalDialog10.setOnClickListener {
            val buttonSettings = CharcoalDialogButtonSettings.TwoButtons(
                primaryButtonText = getString(android.R.string.ok),
                secondaryButtonText = "second"
            )

            CharcoalDialogFragment.newInstance(
                title = "画像つきキャンセル可能",
                message = "画像つきダイアログ、キャンセルボタンつき",
                imageRes = R.drawable.dialog_sample_image,
                buttonSettings = buttonSettings,
                isCancelable = true,
            ).showNow(supportFragmentManager, DIALOG_TAG)
        }

        binding.buttonCharcoalDialog11.setOnClickListener {
            val buttonSettings = CharcoalDialogButtonSettings.TwoButtons(
                primaryButtonText = getString(android.R.string.ok),
                secondaryButtonText = "second"
            )

            CharcoalDialogFragment.newInstance(
                title = "画像つきキャンセル可能背景色付き",
                message = "画像つきダイアログ、背景色付きキャンセルボタン",
                imageRes = R.drawable.dialog_sample_image,
                buttonSettings = buttonSettings,
                isCancelable = true,
                cancelButtonColoredBackground = true
            ).showNow(supportFragmentManager, DIALOG_TAG)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val DIALOG_TITLE = "Lorem ipsum dolor sit amet, consectetur adipisicing"
        private const val DIALOG_DESCRIPTION = "Lorem ipsum dolor sit amet, consectetur adipisicing elit," +
            " sed do eiusmod tempor incididunt ut labore"

        private const val DIALOG_TAG = "tag"

        fun createIntent(context: Context): Intent = Intent(context, DialogActivity::class.java)
    }

    sealed class DialogActivityEvent : CharcoalDialogEvent {
        @Parcelize
        object SelectPrimaryButton : DialogActivityEvent()

        @Parcelize
        object SelectSecondaryButton : DialogActivityEvent()

        @Parcelize
        object SelectTertiaryButton : DialogActivityEvent()
    }
}
