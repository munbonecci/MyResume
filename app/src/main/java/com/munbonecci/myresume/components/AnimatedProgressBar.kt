package com.munbonecci.myresume.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedProgressBar(indicatorProgress: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .height(46.dp)
            .padding(top = 8.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        CustomProgressBar(indicatorNumber = indicatorProgress)
    }
}

@Composable
fun CustomProgressBar(
    indicatorNumber: Int,
    backgroundIndicatorColor: Color = MaterialTheme.colors.primary.copy(alpha = 0.3f),
    indicatorPadding: Dp = 8.dp,
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
        )
    )

    LaunchedEffect(Unit) {
        percentage = indicatorNumber.toFloat()
    }

    Box(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
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