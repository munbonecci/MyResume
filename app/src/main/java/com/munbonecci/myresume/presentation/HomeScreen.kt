package com.munbonecci.myresume.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.munbonecci.myresume.components.*
import com.munbonecci.myresume.ui.theme.MyResumeTheme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
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
        ContactInfo()
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
            HomeScreen()
        }
    }
}