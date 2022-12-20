package com.munbonecci.myresume.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.munbonecci.myresume.data.model.SkillData
import com.munbonecci.myresume.domain.DataGenerator


@Composable
fun SkillInfo() {
    val skillInfoList = DataGenerator(LocalContext.current).skillInfoDataList

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            items(skillInfoList) { skill ->
                SkillInfoItem(skill, onItemClick = { data ->
                    Log.d("Skill pressed: ", data.name)
                })
            }
        }
    }
}

@Composable
fun SkillInfoItem(skillData: SkillData, onItemClick: (SkillData) -> Unit) {
    Box(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(skillData)
            },
        contentAlignment = Center
    ) {
        Column() {
            Text(
                text = skillData.name,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
            )
            CustomSpacer(
                spacerDimens = SpacerDimens.MEDIUM, spacerOrientation = SpacerOrientation.HORIZONTAL
            )
            AnimatedProgressBar(indicatorProgress = skillData.percentage)
            CustomSpacer(
                spacerDimens = SpacerDimens.MEDIUM, spacerOrientation = SpacerOrientation.HORIZONTAL
            )
        }
    }
}

@Preview
@Composable
fun PreviewSkillInfo() {
    SkillInfo()
}