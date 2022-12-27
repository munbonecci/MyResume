package com.munbonecci.myresume.presentation.home_screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.munbonecci.myresume.components.CustomSpacer
import com.munbonecci.myresume.components.SpacerDimens
import com.munbonecci.myresume.data.model.CategoryData
import com.munbonecci.myresume.ui.theme.MyResumeTheme
import com.munbonecci.myresume.ui.theme.dimen_16dp

@Composable
fun HomeScreen(
    onCategoryButtonClicked: (CategoryData) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = dimen_16dp, start = dimen_16dp, end = dimen_16dp)
    ) {
        HomeHeader()
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