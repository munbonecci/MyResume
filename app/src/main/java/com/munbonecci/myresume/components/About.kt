package com.munbonecci.myresume.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.munbonecci.myresume.R
import com.munbonecci.myresume.domain.DataGenerator


@Composable
fun About() {
    Column(
        modifier = Modifier.padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            color = MaterialTheme.colors.primary,
            fontSize = 20.sp,
            style = MaterialTheme.typography.h4,
            text = stringResource(id = R.string.about_label)
        )
        ExpandableText(
            fontSize = 12.sp,
            text = DataGenerator.ABOUT_INFO,
            modifier = Modifier.padding(3.dp)
        )
    }
}

@Preview
@Composable
fun PreviewAbout() {
    About()
}