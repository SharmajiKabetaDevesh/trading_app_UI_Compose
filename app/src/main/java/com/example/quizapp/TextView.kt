package com.example.quizapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

@Composable
fun TextView(data:String,color:Color,modifier: Modifier = Modifier){
    Text(
        text = data,
         modifier=modifier           ,
        textAlign = TextAlign.Center,

        color = color,

        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,

        letterSpacing = TextUnit.Unspecified,


        overflow = TextOverflow.Clip,
        softWrap = true,
        maxLines = Int.MAX_VALUE,
        minLines = 1,
        onTextLayout = {  },
        style = TextStyle.Default
    )
}
