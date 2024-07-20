package com.example.quizapp

import androidx.compose.ui.graphics.Brush

data class CardDetails(
    val cardType:String,
    val cardNumber:String,
    val cardName:String,
    val  balance:Double,
    val color:Brush
)
