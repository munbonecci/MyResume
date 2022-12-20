package com.munbonecci.myresume.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.munbonecci.myresume.R
import com.munbonecci.myresume.components.*
import com.munbonecci.myresume.data.model.CategoryData
import com.munbonecci.myresume.ui.theme.MyResumeTheme

@Composable
fun HomeScreen(
    onCategoryButtonClicked: (CategoryData) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            color = MaterialTheme.colors.primary,
            fontSize = 24.sp,
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1
        )
        CustomSpacer(
            spacerDimens = SpacerDimens.MEDIUM
        )
        ProfileImage()
        CustomSpacer(
            spacerDimens = SpacerDimens.MEDIUM
        )
        ProfileInfo()
        CustomSpacer(
            spacerDimens = SpacerDimens.MEDIUM
        )
        About()
        CustomSpacer(
            spacerDimens = SpacerDimens.SMALL
        )
        ProfileCategories(onCategoryButtonClicked)
        CustomSpacer(
            spacerDimens = SpacerDimens.MEDIUM
        )
    }
}

@Composable
@Preview(name = "light_mode")
@Preview(name = "dark_mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun HomeScreenPreview() {
    MyResumeTheme {
        Surface {
            HomeScreen(onCategoryButtonClicked = {})
        }
    }
}