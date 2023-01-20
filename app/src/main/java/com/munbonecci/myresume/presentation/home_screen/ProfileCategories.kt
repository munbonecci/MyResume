package com.munbonecci.myresume.presentation.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.munbonecci.myresume.R
import com.munbonecci.myresume.components.CustomSpacer
import com.munbonecci.myresume.components.SpacerDimens
import com.munbonecci.myresume.components.SpacerOrientation
import com.munbonecci.myresume.data.model.CategoryData
import com.munbonecci.myresume.domain.model.ProfileUIState
import com.munbonecci.myresume.ui.theme.dimen_16dp
import com.munbonecci.myresume.ui.theme.dimen_20dp
import com.munbonecci.myresume.ui.theme.dimen_4dp

fun LazyListScope.profileCategories(
    onCategoryButtonClicked: (CategoryData) -> Unit,
    profileData: ProfileUIState
) {
    val categoryInfoList = profileData.profile.categories

    items(categoryInfoList) { categoryInfo ->
        ProfileCategoryItem(categoryInfo, onItemClick = { data ->
            onCategoryButtonClicked.invoke(data)
        })
    }
}

@Composable
fun ProfileCategoryItem(categoryData: CategoryData, onItemClick: (CategoryData) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(dimen_4dp)
        .clickable {
            onItemClick(categoryData)
        }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = dimen_16dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = categoryData.icon),
                contentDescription = categoryData.iconContentDescription,
                modifier = Modifier
                    .size(dimen_20dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(weight = 3f, fill = false)
                        .padding(start = dimen_16dp)
                ) {
                    Text(fontSize = 14.sp, text = categoryData.label)
                    CustomSpacer(
                        spacerDimens = SpacerDimens.SMALL,
                        spacerOrientation = SpacerOrientation.HORIZONTAL
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24),
                    contentDescription = categoryData.iconContentDescription,
                    modifier = Modifier
                        .size(dimen_20dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary)
                )
            }
        }
        CustomSpacer(
            spacerDimens = SpacerDimens.LARGE, spacerOrientation = SpacerOrientation.HORIZONTAL
        )
    }
}

@Preview
@Composable
fun PreviewProfileCategories() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = dimen_16dp, start = dimen_16dp, end = dimen_16dp)
    ) {
        profileCategories(onCategoryButtonClicked = {}, profileData = ProfileUIState())
    }
}