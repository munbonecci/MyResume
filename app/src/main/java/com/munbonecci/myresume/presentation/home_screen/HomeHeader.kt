package com.munbonecci.myresume.presentation.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.munbonecci.myresume.R
import com.munbonecci.myresume.presentation.ContactInfoUtils
import com.munbonecci.myresume.ui.theme.*

@Composable
fun HomeHeader() {
    val showInfoDialog = remember { mutableStateOf(false) }

    if (showInfoDialog.value) OnInfoButtonPressed(showInfoDialog)

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            color = MaterialTheme.colors.primary,
            fontSize = 24.sp,
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1,
            modifier = Modifier.align(Alignment.CenterStart)
        )
        IconButton(enabled = true, onClick = {
            showInfoDialog.value = true
        }, modifier = Modifier.align(Alignment.CenterEnd)) {
            Icon(
                imageVector = Icons.Filled.Info,
                tint = MaterialTheme.colors.primary,
                contentDescription = stringResource(R.string.close_button),
            )
        }
    }
}

@Composable
fun OnInfoButtonPressed(showInfoDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { showInfoDialog.value = false }) {
        CustomInfoDialog(showInfoDialog = showInfoDialog)
    }
}

@Composable
private fun CustomInfoDialog(
    modifier: Modifier = Modifier,
    showInfoDialog: MutableState<Boolean>
) {
    val context = LocalContext.current

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
                    showInfoDialog.value = false
                }, modifier = Modifier.align(Alignment.End)) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        tint = MaterialTheme.colors.primary,
                        contentDescription = stringResource(R.string.close_button),
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.resume_icon),
                    contentDescription = stringResource(id = R.string.app_name),
                    modifier = Modifier
                        .size(dimen_60dp)
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    modifier = Modifier
                        .padding(top = dimen_2dp)
                        .align(Alignment.CenterHorizontally),
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(id = R.string.app_info),
                    fontSize = 11.sp,
                    modifier = Modifier.padding(top = dimen_4dp),
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier.padding(top = dimen_4dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            showInfoDialog.value = false
                            ContactInfoUtils.sendEmail(
                                context,
                                context.getString(R.string.contact_email)
                            )
                        }
                    ) {
                        Text(text = stringResource(id = R.string.comments_feedback_here))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeHeader() {
    HomeHeader()
}