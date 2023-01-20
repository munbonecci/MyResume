package com.munbonecci.myresume.presentation.detail_screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.munbonecci.myresume.R
import com.munbonecci.myresume.components.CustomSpacer
import com.munbonecci.myresume.components.ExpandableText
import com.munbonecci.myresume.components.SpacerDimens
import com.munbonecci.myresume.components.SpacerOrientation
import com.munbonecci.myresume.data.model.TechStackData
import com.munbonecci.myresume.domain.model.CategoryTechData
import com.munbonecci.myresume.ui.theme.*


@Composable
fun TechnologyStackInfo(categoryTechData: CategoryTechData = CategoryTechData()) {
    val projectStackList = categoryTechData.projects
    val developmentStackList = categoryTechData.developmentStacks
    val androidToolsStackList = categoryTechData.androidTools
    val uiFrameworksStackList = categoryTechData.uiFrameworks
    val designToolsStackList = categoryTechData.designTools
    val databaseStackList = categoryTechData.databases
    val versionControlStackList = categoryTechData.versionControlStacks
    val releaseStackList = categoryTechData.releases
    val analyticsStackList = categoryTechData.analytics
    val othersStackList = categoryTechData.others

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = dimen_16dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            item {
                Text(
                    modifier = Modifier.padding(dimen_8dp),
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h4,
                    text = stringResource(id = R.string.project_management_label)
                )
            }
            items(projectStackList) { info ->
                TechnologyStackItem(info, onItemClick = { data ->
                    Log.d("data: ", data.name)
                })
            }
            item {
                Text(
                    modifier = Modifier.padding(dimen_8dp),
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h4,
                    text = stringResource(id = R.string.development_tools_label)
                )
            }
            items(developmentStackList) { info ->
                TechnologyStackItem(info, onItemClick = { data ->
                    Log.d("data: ", data.name)
                })
            }
            item {
                Text(
                    modifier = Modifier.padding(dimen_8dp),
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h4,
                    text = stringResource(id = R.string.android_tools_label)
                )
            }
            items(androidToolsStackList) { info ->
                TechnologyStackItem(info, onItemClick = { data ->
                    Log.d("data: ", data.name)
                })
            }
            item {
                Text(
                    modifier = Modifier.padding(dimen_8dp),
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h4,
                    text = stringResource(id = R.string.ui_framework_label)
                )
            }
            items(uiFrameworksStackList) { info ->
                TechnologyStackItem(info, onItemClick = { data ->
                    Log.d("data: ", data.name)
                })
            }
            item {
                Text(
                    modifier = Modifier.padding(dimen_8dp),
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h4,
                    text = stringResource(id = R.string.design_tools_label)
                )
            }
            items(designToolsStackList) { info ->
                TechnologyStackItem(info, onItemClick = { data ->
                    Log.d("data: ", data.name)
                })
            }
            item {
                Text(
                    modifier = Modifier.padding(dimen_8dp),
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h4,
                    text = stringResource(id = R.string.database_label)
                )
            }
            items(databaseStackList) { info ->
                TechnologyStackItem(info, onItemClick = { data ->
                    Log.d("data: ", data.name)
                })
            }
            item {
                Text(
                    modifier = Modifier.padding(dimen_8dp),
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h4,
                    text = stringResource(id = R.string.version_control_label)
                )
            }
            items(versionControlStackList) { info ->
                TechnologyStackItem(info, onItemClick = { data ->
                    Log.d("data: ", data.name)
                })
            }
            item {
                Text(
                    modifier = Modifier.padding(dimen_8dp),
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h4,
                    text = stringResource(id = R.string.release_management_label)
                )
            }
            items(releaseStackList) { info ->
                TechnologyStackItem(info, onItemClick = { data ->
                    Log.d("data: ", data.name)
                })
            }
            item {
                Text(
                    modifier = Modifier.padding(dimen_8dp),
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h4,
                    text = stringResource(id = R.string.analytics_tools_label)
                )
            }
            items(analyticsStackList) { info ->
                TechnologyStackItem(info, onItemClick = { data ->
                    Log.d("data: ", data.name)
                })
            }
            item {
                Text(
                    modifier = Modifier.padding(dimen_8dp),
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h4,
                    text = stringResource(id = R.string.other_tools_label)
                )
            }
            items(othersStackList) { info ->
                TechnologyStackItem(info, onItemClick = { data ->
                    Log.d("data: ", data.name)
                })
            }
        }
    }
}

@Composable
fun TechnologyStackItem(techData: TechStackData, onItemClick: (TechStackData) -> Unit) {
    Column(modifier = Modifier
        .padding(top = dimen_4dp, start = dimen_16dp, end = dimen_16dp, bottom = dimen_8dp)
        .fillMaxWidth()
        .clickable {
            onItemClick(techData)
        }) {
        CustomSpacer(
            spacerDimens = SpacerDimens.MEDIUM,
            spacerOrientation = SpacerOrientation.HORIZONTAL
        )
        Text(
            fontSize = 14.sp,
            text = "${stringResource(id = R.string.bullet)} ${techData.name}",
            modifier = Modifier.padding(dimen_1dp)
        )
        CustomSpacer(
            spacerDimens = SpacerDimens.EXTRA_LARGE,
            spacerOrientation = SpacerOrientation.HORIZONTAL
        )
        if (techData.description.isNotEmpty()) {
            ExpandableText(
                fontSize = 13.sp,
                text = techData.description,
                modifier = Modifier.padding(dimen_3dp)
            )
            CustomSpacer(
                spacerDimens = SpacerDimens.LARGE,
                spacerOrientation = SpacerOrientation.HORIZONTAL
            )
        }
    }
}

@Preview
@Composable
fun PreviewTechnologyStackInfo() {
    TechnologyStackInfo()
}