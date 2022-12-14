package com.munbonecci.myresume.components

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
import androidx.compose.ui.res.stringResource
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

    LazyColumn(
        modifier = Modifier.padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        item {
            Text(
                color = MaterialTheme.colors.primary,
                fontSize = 20.sp,
                style = MaterialTheme.typography.h4,
                text = stringResource(id = R.string.contact_info_label)
            )
        }
        items(contactInfoList) { contactInfo ->
            ContactInfoItem(contactInfo, onItemClick = { data ->
                when (data.type) {
                    DataGenerator.EMAIL_TYPE -> {}
                    DataGenerator.PHONE_TYPE -> {}
                    DataGenerator.WEB_VIEW_TYPE -> {}
                }
            })
        }
    }
}

@Composable
fun ContactInfoItem(contactInfo: ContactInfoData, onItemClick: (ContactInfoData) -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onItemClick(contactInfo)
        }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp)
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

@Preview
@Composable
fun PreviewContactInfo() {
    ContactInfo()
}