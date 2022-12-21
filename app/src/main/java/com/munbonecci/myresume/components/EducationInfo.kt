package com.munbonecci.myresume.components

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.munbonecci.myresume.data.model.EducationData
import com.munbonecci.myresume.domain.DataGenerator
import com.munbonecci.myresume.presentation.ContactInfoUtils
import com.munbonecci.myresume.ui.theme.dimen_16dp
import com.munbonecci.myresume.ui.theme.dimen_30dp
import com.munbonecci.myresume.ui.theme.dimen_3dp
import com.munbonecci.myresume.ui.theme.dimen_5dp


@Composable
fun EducationInfo() {
    val educationInfoList = DataGenerator(LocalContext.current).educationInfoDataList
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimen_16dp)
    ) {
        LazyColumn(
            modifier = Modifier.padding(dimen_5dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            items(educationInfoList) { education ->
                EducationInfoItem(education, onItemClick = { data ->
                    if (data.school.isNotEmpty()) {
                        ContactInfoUtils.openChromeTabs(context, data.schoolURL)
                    }
                })
            }
        }
    }
}

@Composable
fun EducationInfoItem(educationData: EducationData, onItemClick: (EducationData) -> Unit) {
    Column(modifier = Modifier
        .padding(top = dimen_16dp)
        .fillMaxWidth()
        .clickable {
            onItemClick(educationData)
        }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = educationData.icon),
                contentDescription = educationData.iconContentDescription,
                modifier = Modifier
                    .size(dimen_30dp)
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
                text = educationData.school
            )
        }
        CustomSpacer(
            spacerDimens = SpacerDimens.MEDIUM,
            spacerOrientation = SpacerOrientation.HORIZONTAL
        )
        Text(
            fontSize = 14.sp,
            text = "${educationData.degree}, ${educationData.fieldOfStudy}",
            modifier = Modifier.padding(1.dp)
        )
        Text(
            fontSize = 12.sp,
            text = "${educationData.startDate} - ${educationData.endDate}",
            modifier = Modifier.padding(1.dp)
        )
        Text(
            fontSize = 13.sp,
            text = "Grade: ${educationData.grade}",
            modifier = Modifier.padding(1.dp)
        )
        CustomSpacer(
            spacerDimens = SpacerDimens.EXTRA_LARGE,
            spacerOrientation = SpacerOrientation.HORIZONTAL
        )
        ExpandableText(
            fontSize = 13.sp,
            text = educationData.description,
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
fun PreviewEducationInfo() {
    EducationInfo()
}