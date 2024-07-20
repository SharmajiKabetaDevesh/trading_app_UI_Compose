package com.example.quizapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun WalletSection(){

    Row(
        modifier= Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(modifier = Modifier) {
            Text(text = "Wallet", fontSize = 17.sp,
                color=MaterialTheme.colorScheme.onBackground,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Normal,
                letterSpacing = TextUnit.Unspecified,
                overflow = TextOverflow.Clip,
                softWrap = true,
                maxLines = Int.MAX_VALUE,
                minLines = 1,
                onTextLayout = {  },
                style = TextStyle.Default)

            Text(text = "$ 44.75",
                fontSize = 24.sp,
                color=MaterialTheme.colorScheme.onBackground,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                letterSpacing = TextUnit.Unspecified,
                overflow = TextOverflow.Clip,
                softWrap = true,
                maxLines = Int.MAX_VALUE,
                minLines = 1,
                onTextLayout = {  },
                style = TextStyle.Default)
        }
        Box(modifier= Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .clickable { }
            .padding(6.dp)
        ){
            Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search",
                tint=MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }


}