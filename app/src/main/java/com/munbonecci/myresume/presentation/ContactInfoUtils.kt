package com.munbonecci.myresume.presentation

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.munbonecci.myresume.R


object ContactInfoUtils {

    fun sendEmail(context: Context, email: String) {
        runCatching {
            context.startActivity(Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse(MAIL_TO)
                putExtra(
                    Intent.EXTRA_EMAIL,
                    arrayOf(email)
                )
                putExtra(Intent.EXTRA_SUBJECT, APP_FEEDBACK)
            })
        }.onFailure {
            showToastAlert(context, context.getString(R.string.not_email_app_found_error_msg))
        }
    }

    fun makeCallOrSendWhatsAppMessage(context: Context, phoneNumber: String) {
        val inflater = LayoutInflater.from(context)
        val dialogView: View? = inflater.inflate(R.layout.select_call_option_layout, null)

        val builder = AlertDialog.Builder(context).apply {
            setView(dialogView)
            setCancelable(true)
            setNegativeButton(
                context.getString(R.string.close_button)
            ) { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
            }
        }

        val alertDialog = builder.create()

        dialogView?.let {
            val callButton = dialogView.findViewById(R.id.callButton) as Button
            val whatsButton = dialogView.findViewById(R.id.whatsButton) as Button

            callButton.setOnClickListener {
                makeACall(context, phoneNumber)
                alertDialog.dismiss()
            }
            whatsButton.setOnClickListener {
                openWhatsApp(context, phoneNumber)
                alertDialog.dismiss()
            }
        }
        alertDialog.show()
    }

    private fun makeACall(context: Context, phoneNumber: String) {
        context.startActivity(Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        })
    }

    private fun openWhatsApp(context: Context, phoneNumber: String) {
        val isAppInstalled = appInstalledOrNot(WHATS_APP_PACKAGE, context)
        if (isAppInstalled) {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("${WHATS_APP_URI}${phoneNumber}")
            )
            context.startActivity(intent)
        } else {
            showToastAlert(context, WHATS_APP_NOT_INSTALLED)
        }
    }

    private fun appInstalledOrNot(uri: String, context: Context): Boolean {
        val packageManager = context.packageManager
        return try {
            packageManager.getPackageInfoCompat(uri, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    private fun PackageManager.getPackageInfoCompat(
        packageName: String,
        flags: Int = 0
    ): PackageInfo =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(flags.toLong()))
        } else {
            @Suppress("DEPRECATION") getPackageInfo(packageName, flags)
        }

    private fun showToastAlert(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun openChromeTabs(context: Context, url: String) {
        try {
            val customTabColorSchemeParams = CustomTabColorSchemeParams.Builder()
                .setToolbarColor(ContextCompat.getColor(context, R.color.purple_500))
                .setSecondaryToolbarColor(ContextCompat.getColor(context, R.color.purple_500))
                .build()
            val builder = CustomTabsIntent.Builder()
                .setShowTitle(true)
                .setShareState(CustomTabsIntent.SHARE_STATE_ON)
                .setExitAnimations(
                    context, android.R.anim.slide_in_left, android.R.anim.slide_out_right
                )
            val customTabsIntent =
                builder.setColorSchemeParams(
                    CustomTabsIntent.COLOR_SCHEME_DARK, customTabColorSchemeParams
                ).build()
            customTabsIntent.intent.setPackage(CHROME_PACKAGE)
            customTabsIntent.launchUrl(context, Uri.parse(url))
        } catch (e: Exception) {
            showToastAlert(context, CHROME_NOT_INSTALLED)
        }
    }

    private const val MAIL_TO = "mailto:"
    private const val APP_FEEDBACK = "App feedback"
    private const val WHATS_APP_PACKAGE = "com.whatsapp"
    private const val WHATS_APP_URI = "https://api.whatsapp.com/send?phone="
    private const val WHATS_APP_NOT_INSTALLED = "WhatsApp is not installed"
    private const val CHROME_NOT_INSTALLED = "Chrome is not installed"
    private const val CHROME_PACKAGE = "com.android.chrome"
}