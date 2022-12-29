package com.munbonecci.myresume.presentation.detail_screen

import android.content.res.Configuration
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.munbonecci.myresume.components.AppBar
import com.munbonecci.myresume.domain.DataGenerator
import com.munbonecci.myresume.ui.theme.MyResumeTheme

@Composable
fun CategoryDetailScreen(onBackButtonClicked: () -> Unit, type: String?, name: String?) {
    val currentScreen = "Category"

    Scaffold(
        topBar = {
            AppBar(
                currentScreen = name ?: currentScreen,
                canNavigateBack = true,
                navigateUp = { onBackButtonClicked.invoke() }
            )
        }
    ) { innerPadding ->
        Log.d("", innerPadding.toString())
        type?.let {
            when (it.toIntOrNull() ?: 0) {
                DataGenerator.CATEGORY_CONTACT_INFO -> {
                    ContactInfo()
                }
                DataGenerator.CATEGORY_EXPERIENCE -> {
                    ExperienceInfo()
                }
                DataGenerator.CATEGORY_EDUCATION -> {
                    EducationInfo()
                }
                DataGenerator.CATEGORY_SKILLS -> {
                    SkillInfo()
                }
                DataGenerator.CATEGORY_TECH_STACK -> {
                    TechnologyStackInfo()
                }
                DataGenerator.CATEGORY_LANGUAGES -> {
                    LanguageInfo()
                }
            }
        }
    }
}

@Composable
@Preview(name = "light_mode")
@Preview(name = "dark_mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun CategoryDetailScreenPreview() {
    MyResumeTheme {
        Surface {
            CategoryDetailScreen(
                onBackButtonClicked = {},
                "",
                ""
            )
        }
    }
}