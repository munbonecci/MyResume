package com.munbonecci.myresume.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import com.munbonecci.myresume.ui.theme.dimen_300dp
import com.munbonecci.myresume.ui.theme.dimen_46dp
import com.munbonecci.myresume.ui.theme.dimen_8dp

@Composable
fun AnimatedProgressBar(indicatorProgress: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .height(dimen_46dp)
            .padding(top = dimen_8dp, bottom = dimen_8dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(dimen_8dp))
        CustomProgressBar(indicatorNumber = indicatorProgress)
    }
}

@Composable
fun CustomProgressBar(
    indicatorNumber: Int,
    backgroundIndicatorColor: Color = MaterialTheme.colors.primary.copy(alpha = 0.3f),
    indicatorPadding: Dp = dimen_8dp,
    gradientColors: List<Color> = listOf(
        MaterialTheme.colors.primary,
        MaterialTheme.colors.primaryVariant,
    ),
    animationDuration: Int = 1000,
    animationDelay: Int = 0
) {
    var percentage by remember {
        mutableStateOf(-1f)
    }

    val animateNumber = animateFloatAsState(
        targetValue = percentage,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        ), label = ""
    )

    LaunchedEffect(Unit) {
        percentage = indicatorNumber.toFloat()
    }

    Box(
        modifier = Modifier
            .height(dimen_300dp)
            .fillMaxWidth()
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimen_300dp)
                .padding(start = indicatorPadding, end = indicatorPadding)
        ) {
            drawLine(
                color = backgroundIndicatorColor,
                cap = StrokeCap.Round,
                strokeWidth = size.height,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = size.width, y = 0f)
            )
            val progress =
                (animateNumber.value / 100) * size.width

            drawLine(
                brush = Brush.linearGradient(colors = gradientColors),
                cap = StrokeCap.Round,
                strokeWidth = size.height,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = progress, y = 0f)
            )
        }
    }
}