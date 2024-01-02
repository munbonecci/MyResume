package com.munbonecci.myresume.presentation.detail_screen

import android.content.res.Configuration
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.munbonecci.myresume.components.CustomTopAppBar
import com.munbonecci.myresume.domain.DataGenerator
import com.munbonecci.myresume.ui.theme.MyResumeTheme

@Composable
fun CategoryDetailScreen(
    onBackButtonClicked: () -> Unit,
    type: String?,
    name: String?,
    viewModel: CategoryDetailViewModel = hiltViewModel()
) {
    val currentScreen = "Category"
    type?.let { id ->
        viewModel.getCategorySelectedData(id.toIntOrNull() ?: 0)
        val categoryDetailData = viewModel.uiCategoryDetailState.collectAsState()

        Scaffold(
            topBar = {
                CustomTopAppBar(
                    currentScreen = name ?: currentScreen,
                    showBackButton = true,
                    onBackButtonClick = { onBackButtonClicked.invoke() }
                )
            }
        ) { innerPadding ->
            Log.d("", innerPadding.toString())
            id.let { categoryId ->
                when (categoryId.toIntOrNull() ?: 0) {
                    DataGenerator.CATEGORY_CONTACT_INFO -> {
                        ContactInfo(categoryDetailData.value.category.contacts)
                    }
                    DataGenerator.CATEGORY_EXPERIENCE -> {
                        ExperienceInfo(categoryDetailData.value.category.experiences)
                    }
                    DataGenerator.CATEGORY_EDUCATION -> {
                        EducationInfo(categoryDetailData.value.category.educationData)
                    }
                    DataGenerator.CATEGORY_SKILLS -> {
                        SkillInfo(categoryDetailData.value.category.skills)
                    }
                    DataGenerator.CATEGORY_TECH_STACK -> {
                        TechnologyStackInfo(categoryDetailData.value.category.techData)
                    }
                    DataGenerator.CATEGORY_LANGUAGES -> {
                        LanguageInfo(categoryDetailData.value.category.languages)
                    }
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