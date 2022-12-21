package com.munbonecci.myresume.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.munbonecci.myresume.R
import com.munbonecci.myresume.presentation.ContactInfoUtils
import com.munbonecci.myresume.ui.theme.*

@Composable
fun ProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(dimen_120dp)
            .padding(dimen_5dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = dimen_4dp,
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
    val context = LocalContext.current
    val resume = stringResource(id = R.string.resume_feedback_url)
    Card(
        shape = RoundedCornerShape(dimen_10dp),
        modifier = Modifier.padding(dimen_10dp, dimen_5dp, dimen_10dp, dimen_10dp),
        elevation = dimen_8dp
    ) {
        Column(
            modifier = modifier
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        top = dimen_4dp,
                        bottom = dimen_16dp,
                        start = dimen_16dp,
                        end = dimen_16dp
                    )
                    .verticalScroll(rememberScrollState())
                    .weight(weight = 1f, fill = false)
            ) {
                IconButton(enabled = true, onClick = {
                    showProfileDialog.value = false
                }, modifier = Modifier.align(Alignment.End)) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        tint = MaterialTheme.colors.primary,
                        contentDescription = stringResource(R.string.close_button),
                    )
                }
                Surface(
                    modifier = Modifier
                        .size(dimen_60dp)
                        .align(Alignment.CenterHorizontally),
                    shape = CircleShape,
                    border = BorderStroke(0.5.dp, Color.LightGray),
                    elevation = dimen_2dp,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_image),
                        contentDescription = stringResource(id = R.string.profile_image_content_description),
                        modifier = Modifier
                            .size(dimen_60dp),
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    text = stringResource(id = R.string.profile_name),
                    modifier = Modifier
                        .padding(top = dimen_2dp)
                        .align(Alignment.CenterHorizontally),
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(id = R.string.profile_headline),
                    modifier = Modifier
                        .padding(top = dimen_2dp)
                        .align(Alignment.CenterHorizontally),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    "${stringResource(id = R.string.location_label)}:" +
                            " ${stringResource(id = R.string.location_zapopan)}",
                    fontSize = 11.sp,
                    modifier = Modifier
                        .padding(top = dimen_4dp)
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
                    modifier = Modifier.padding(top = dimen_4dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            showProfileDialog.value = false
                            ContactInfoUtils.openChromeTabs(context, resume)
                        }
                    ) {
                        Text(text = stringResource(id = R.string.show_full_resume))
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