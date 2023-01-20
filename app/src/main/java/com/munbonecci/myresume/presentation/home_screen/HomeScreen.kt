package com.munbonecci.myresume.presentation.home_screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.munbonecci.myresume.components.CustomSpacer
import com.munbonecci.myresume.components.SpacerDimens
import com.munbonecci.myresume.data.model.CategoryData
import com.munbonecci.myresume.presentation.ProfileViewModel
import com.munbonecci.myresume.ui.theme.MyResumeTheme
import com.munbonecci.myresume.ui.theme.dimen_16dp

@Composable
fun HomeScreen(
    onCategoryButtonClicked: (CategoryData) -> Unit,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val profileData by viewModel.uiProfileState.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = dimen_16dp, end = dimen_16dp)
    ) {
        item {
            HomeHeader()
            CustomSpacer(spacerDimens = SpacerDimens.MEDIUM)
            ProfileImage(
                profileImage = profileData.profile.profileIcon,
                imageDescription = profileData.profile.profileIconContentDescription,
                profileDialogData = profileData.profile.profileDialogData
            )
            CustomSpacer(spacerDimens = SpacerDimens.MEDIUM)
            ProfileInfo(
                profileName = profileData.profile.profileName,
                headline = profileData.profile.headline
            )
            CustomSpacer(spacerDimens = SpacerDimens.MEDIUM)
            About(aboutInfo = profileData.profile.aboutInfo)
            CustomSpacer(spacerDimens = SpacerDimens.SMALL)
        }
        this@LazyColumn.profileCategories(onCategoryButtonClicked, profileData)
        item {
            CustomSpacer(spacerDimens = SpacerDimens.MEDIUM)
        }
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