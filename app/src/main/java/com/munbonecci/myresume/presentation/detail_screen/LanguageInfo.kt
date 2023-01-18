package com.munbonecci.myresume.presentation.detail_screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.munbonecci.myresume.components.CircularProgressbar
import com.munbonecci.myresume.components.CustomSpacer
import com.munbonecci.myresume.components.SpacerDimens
import com.munbonecci.myresume.components.SpacerOrientation
import com.munbonecci.myresume.data.model.LanguageData
import com.munbonecci.myresume.ui.theme.dimen_16dp
import com.munbonecci.myresume.ui.theme.dimen_8dp

@Composable
fun LanguageInfo(languages: List<LanguageData> = arrayListOf()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = dimen_16dp, end = dimen_16dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(dimen_16dp),
            horizontalArrangement = Arrangement.spacedBy(dimen_16dp)
        ) {
            items(languages) { language ->
                LanguageInfoItem(language, onItemClick = { data ->
                    Log.d("Language pressed: ", data.name)
                })
            }
        }
    }
}

@Composable
fun LanguageInfoItem(languageData: LanguageData, onItemClick: (LanguageData) -> Unit) {
    Box(
        modifier = Modifier
            .padding(top = dimen_8dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(languageData)
            },
        contentAlignment = Center
    ) {
        Column {
            CustomSpacer(
                spacerDimens = SpacerDimens.MEDIUM, spacerOrientation = SpacerOrientation.HORIZONTAL
            )
            CircularProgressbar(
                dataUsage = languageData.percentage.toFloat(), name = languageData.name
            )
            CustomSpacer(
                spacerDimens = SpacerDimens.MEDIUM, spacerOrientation = SpacerOrientation.HORIZONTAL
            )
        }
    }
}

@Preview
@Composable
fun PreviewLanguageInfo() {
    LanguageInfo()
}