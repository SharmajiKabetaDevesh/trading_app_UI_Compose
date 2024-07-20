package com.example.quizapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.ThumbUp


import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit


val items:List<BottomNavItem> = listOf(
    BottomNavItem("Home", Icons.Rounded.Home),
    BottomNavItem("Wallet",Icons.Rounded.AccountBox),
    BottomNavItem("Notifications",Icons.Rounded.Notifications),
    BottomNavItem("Profile",Icons.Rounded.AccountCircle)
)

@Composable
fun BottomNavigation(){


    NavigationBar {
        Row(
            modifier= Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ){
               items.forEachIndexed{index,item->
                   NavigationBarItem(
                       selected=index== 0,
                       onClick = {},
                       icon = {
                           Icon(imageVector = item.icon,
                               contentDescription = item.title,
                           tint=MaterialTheme.colorScheme.onBackground
                           )
                       },label={
                           Text(
                               text = item.title,
                               textAlign = TextAlign.Center,
                               color = MaterialTheme.colorScheme.onBackground,
                               fontStyle = FontStyle.Normal,
                               fontWeight = FontWeight.Normal,
                               fontFamily = FontFamily.Default,
                               letterSpacing = TextUnit.Unspecified,
                               textDecoration = TextDecoration.None,
                               lineHeight = TextUnit.Unspecified,
                               overflow = TextOverflow.Clip,
                               softWrap = true,
                               maxLines = Int.MAX_VALUE,
                               minLines = 1,
                               onTextLayout = {  },
                               style = TextStyle.Default
                           )
                       }
                   )

               }
        }
    }
}