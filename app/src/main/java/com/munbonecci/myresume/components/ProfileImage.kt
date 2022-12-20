package com.munbonecci.myresume.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.munbonecci.myresume.R

@Composable
fun ProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(120.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        val showProfileDialog = remember { mutableStateOf(false) }

        if (showProfileDialog.value) {
            OnProfileImagePressed(showProfileDialog)
        }

        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = stringResource(id = R.string.profile_image_content_description),
            modifier = modifier
                .size(135.dp)
                .clickable(
                    enabled = true,
                    onClickLabel = "Clickable image",
                    onClick = {
                        showProfileDialog.value = true
                    }
                ),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun OnProfileImagePressed(showProfileDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { showProfileDialog.value = false }) {
        CustomDialogUI(showProfileDialog = showProfileDialog)
    }
}

@Composable
private fun CustomDialogUI(
    modifier: Modifier = Modifier,
    showProfileDialog: MutableState<Boolean>
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = modifier
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
                    .weight(weight = 1f, fill = false)
            ) {
                Surface(
                    modifier = Modifier
                        .size(60.dp)
                        .padding(4.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = CircleShape,
                    border = BorderStroke(0.5.dp, Color.LightGray),
                    elevation = 2.dp,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_image),
                        contentDescription = stringResource(id = R.string.profile_image_content_description),
                        modifier = Modifier
                            .size(60.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    text = stringResource(id = R.string.profile_name),
                    modifier = Modifier
                        .padding(top = 2.dp)
                        .align(Alignment.CenterHorizontally),
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(id = R.string.profile_headline),
                    modifier = Modifier
                        .padding(top = 2.dp)
                        .align(Alignment.CenterHorizontally),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    "${stringResource(id = R.string.location_label)}:" +
                            " ${stringResource(id = R.string.location_zapopan)}",
                    fontSize = 11.sp,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )
                Text(
                    stringResource(id = R.string.contact_phone_label) +
                            " ${stringResource(id = R.string.contact_phone)}",
                    fontSize = 11.sp
                )
                Text(
                    stringResource(id = R.string.contact_email_label) +
                            " ${stringResource(id = R.string.contact_email)}",
                    fontSize = 11.sp
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            showProfileDialog.value = false
                        }
                    ) {
                        Text(text = stringResource(id = R.string.show_full_resume))
                    }
                }
                Row(
                    modifier = Modifier.padding(top = 4.dp, bottom = 2.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            showProfileDialog.value = false
                        }
                    ) {
                        Text(text = stringResource(id = R.string.dismiss_label))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewProfileImage() {
    ProfileImage()
}