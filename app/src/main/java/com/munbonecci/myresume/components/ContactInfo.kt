package com.munbonecci.myresume.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.munbonecci.myresume.R
import com.munbonecci.myresume.data.model.ContactInfoData
import com.munbonecci.myresume.domain.DataGenerator
import com.munbonecci.myresume.ui.theme.dimen_20dp


@Composable
fun ContactInfo() {
    val contactInfoList = DataGenerator(LocalContext.current).contactInfoDataList
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            items(contactInfoList) { contactInfo ->
                ContactInfoItem(contactInfo, onItemClick = { data ->
                    when (data.type) {
                        DataGenerator.EMAIL_TYPE -> {
                            sendEmail(context)
                        }
                        DataGenerator.PHONE_TYPE -> {}
                        DataGenerator.WEB_VIEW_TYPE -> {}
                    }
                })
            }
        }
    }
}

@Composable
fun ContactInfoItem(contactInfo: ContactInfoData, onItemClick: (ContactInfoData) -> Unit) {
    Column(modifier = Modifier
        .padding(top = 16.dp)
        .fillMaxWidth()
        .clickable {
            onItemClick(contactInfo)
        }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = contactInfo.icon),
                contentDescription = contactInfo.iconContentDescription,
                modifier = Modifier
                    .size(dimen_20dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary)
            )
            CustomSpacer(
                spacerDimens = SpacerDimens.EXTRA_SMALL,
                spacerOrientation = SpacerOrientation.HORIZONTAL
            )
            Text(fontSize = 14.sp, text = contactInfo.label)
        }
        CustomSpacer(
            spacerDimens = SpacerDimens.MEDIUM,
            spacerOrientation = SpacerOrientation.HORIZONTAL
        )
        Text(
            fontSize = 12.sp,
            text = contactInfo.info,
            modifier = Modifier.padding(3.dp)
        )
        CustomSpacer(
            spacerDimens = SpacerDimens.LARGE,
            spacerOrientation = SpacerOrientation.HORIZONTAL
        )
    }
}

private fun sendEmail(context: Context) {
    runCatching {
        context.startActivity(Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse(MAIL_TO)
            putExtra(
                Intent.EXTRA_EMAIL,
                arrayOf(context.getString(R.string.contact_email))
            )
            putExtra(Intent.EXTRA_SUBJECT, APP_FEEDBACK)
        })
    }.onFailure {
        Toast.makeText(
            context,
            context.getString(R.string.not_email_app_found_error_msg),
            Toast.LENGTH_SHORT
        ).show()
    }
}

private const val MAIL_TO = "mailto:"
private const val APP_FEEDBACK = "App feedback"

@Preview
@Composable
fun PreviewContactInfo() {
    ContactInfo()
}