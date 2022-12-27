package com.munbonecci.myresume.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.munbonecci.myresume.R

// Set of Material typography styles to start with
val Typography: Typography
    get() = Typography(
        body1 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        h1 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        /* Other default text styles to override
        button = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp
        ),
        caption = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
        */
    )

val fonts = FontFamily(
    Font(R.font.jost_light, weight = FontWeight.Light),
    Font(R.font.jost_regular, weight = FontWeight.Normal),
    Font(R.font.jost_medium, weight = FontWeight.Medium),
    Font(R.font.jost_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(R.font.jost_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.jost_bold, weight = FontWeight.Bold)
)