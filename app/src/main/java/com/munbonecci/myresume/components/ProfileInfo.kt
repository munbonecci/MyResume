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


@Composable
fun ProfileInfo(profileName: String = "", headline: String = "") {
    val profile =
        profileName.ifEmpty { stringResource(id = R.string.profile_name) }
    val headLine =
        headline.ifEmpty { stringResource(id = R.string.profile_headline) }

    Column(
        modifier = Modifier.padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            color = MaterialTheme.colors.primary,
            fontSize = 24.sp,
            style = MaterialTheme.typography.h4,
            text = profile
        )
        Text(
            text = headLine,
            modifier = Modifier.padding(3.dp)
        )
    }
}

@Preview
@Composable
fun PreviewProfileInfo() {
    ProfileInfo()
}