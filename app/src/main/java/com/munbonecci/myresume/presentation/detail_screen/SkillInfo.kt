package com.munbonecci.myresume.presentation.detail_screen

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.munbonecci.myresume.components.AnimatedProgressBar
import com.munbonecci.myresume.components.CustomSpacer
import com.munbonecci.myresume.components.SpacerDimens
import com.munbonecci.myresume.components.SpacerOrientation
import com.munbonecci.myresume.data.model.SkillData
import com.munbonecci.myresume.ui.theme.dimen_16dp
import com.munbonecci.myresume.ui.theme.dimen_5dp
import com.munbonecci.myresume.ui.theme.dimen_8dp


@Composable
fun SkillInfo(skills: List<SkillData> = arrayListOf()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = dimen_16dp, end = dimen_16dp)
    ) {
        LazyColumn(
            modifier = Modifier.padding(dimen_5dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            items(skills) { skill ->
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
            .padding(top = dimen_8dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(skillData)
            },
        contentAlignment = Center
    ) {
        Column {
            Text(text = skillData.name, fontSize = 15.sp)
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