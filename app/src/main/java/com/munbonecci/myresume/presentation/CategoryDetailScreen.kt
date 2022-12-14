package com.munbonecci.myresume.presentation

import android.content.res.Configuration
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.munbonecci.myresume.components.AppBar
import com.munbonecci.myresume.ui.theme.MyResumeTheme

@Composable
fun CategoryDetailScreen(onBackButtonClicked: () -> Unit) {
    val currentScreen = "Category"

    Scaffold(
        topBar = {
            AppBar(
                currentScreen = currentScreen,
                canNavigateBack = true,
                navigateUp = { onBackButtonClicked.invoke() }
            )
        }
    ) { innerPadding ->
        Log.d("", innerPadding.toString())
    }
}

@Composable
@Preview(name = "light_mode")
@Preview(name = "dark_mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun CategoryDetailScreenPreview() {
    MyResumeTheme {
        Surface {
            CategoryDetailScreen(onBackButtonClicked = {})
        }
    }
}