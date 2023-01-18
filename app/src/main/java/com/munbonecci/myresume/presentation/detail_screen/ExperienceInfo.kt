package com.munbonecci.myresume.presentation.detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.munbonecci.myresume.components.CustomSpacer
import com.munbonecci.myresume.components.ExpandableText
import com.munbonecci.myresume.components.SpacerDimens
import com.munbonecci.myresume.components.SpacerOrientation
import com.munbonecci.myresume.data.model.ExperienceData
import com.munbonecci.myresume.presentation.ContactInfoUtils
import com.munbonecci.myresume.ui.theme.dimen_16dp
import com.munbonecci.myresume.ui.theme.dimen_1dp
import com.munbonecci.myresume.ui.theme.dimen_20dp
import com.munbonecci.myresume.ui.theme.dimen_3dp


@Composable
fun ExperienceInfo(experiences: List<ExperienceData> = arrayListOf()) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            items(experiences) { experience ->
                ExperienceInfoItem(experience, onItemClick = { data ->
                    if (data.companyURL.isNotEmpty()) {
                        ContactInfoUtils.openChromeTabs(context, data.companyURL)
                    }
                })
            }
        }
    }
}

@Composable
fun ExperienceInfoItem(experienceInfo: ExperienceData, onItemClick: (ExperienceData) -> Unit) {
    Column(modifier = Modifier
        .padding(top = dimen_16dp, start = dimen_16dp, end = dimen_16dp)
        .fillMaxWidth()
        .clickable {
            onItemClick(experienceInfo)
        }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = experienceInfo.icon),
                contentDescription = experienceInfo.iconContentDescription,
                modifier = Modifier
                    .size(dimen_20dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )
            CustomSpacer(
                spacerDimens = SpacerDimens.EXTRA_SMALL,
                spacerOrientation = SpacerOrientation.HORIZONTAL
            )
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                text = experienceInfo.companyRole
            )
        }
        CustomSpacer(
            spacerDimens = SpacerDimens.MEDIUM,
            spacerOrientation = SpacerOrientation.HORIZONTAL
        )
        Text(
            fontSize = 14.sp,
            text = "${experienceInfo.companyName} · ${experienceInfo.employmentType}",
            modifier = Modifier.padding(dimen_1dp)
        )
        Text(
            fontSize = 11.sp,
            text = "${experienceInfo.startDate} - ${experienceInfo.endDate}",
            modifier = Modifier.padding(dimen_1dp)
        )
        Text(
            fontSize = 11.sp,
            text = experienceInfo.location,
            modifier = Modifier.padding(dimen_1dp)
        )
        CustomSpacer(
            spacerDimens = SpacerDimens.EXTRA_LARGE,
            spacerOrientation = SpacerOrientation.HORIZONTAL
        )
        ExpandableText(
            fontSize = 13.sp,
            text = experienceInfo.description,
            modifier = Modifier.padding(dimen_3dp)
        )
        CustomSpacer(
            spacerDimens = SpacerDimens.LARGE,
            spacerOrientation = SpacerOrientation.HORIZONTAL
        )
    }
}

@Preview
@Composable
fun PreviewExperienceInfo() {
    ExperienceInfo()
}