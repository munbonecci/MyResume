package com.munbonecci.myresume.presentation.home_screen

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
import androidx.compose.ui.unit.sp
import com.munbonecci.myresume.R
import com.munbonecci.myresume.components.ExpandableText
import com.munbonecci.myresume.ui.theme.dimen_3dp
import com.munbonecci.myresume.ui.theme.dimen_5dp


@Composable
fun About(aboutInfo: String = "") {
    Column(
        modifier = Modifier.padding(dimen_5dp),
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
            text = aboutInfo,
            modifier = Modifier.padding(dimen_3dp)
        )
    }
}

@Preview
@Composable
fun PreviewAbout() {
    About()
}