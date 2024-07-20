package com.example.quizapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.BlueStart
import com.example.quizapp.ui.theme.GreenStart
import com.example.quizapp.ui.theme.OrangeStart
import com.example.quizapp.ui.theme.PurpleStart


val financeList =listOf(
 Finance(
     icon= Icons.Rounded.Star,
     name="My\nBusiness",
     background = OrangeStart
 ),
    Finance(
        icon= Icons.Rounded.AccountBox,
        name="My\nWallet",
        background = BlueStart
    ),
    Finance(
        icon= Icons.Rounded.Star,
        name="Finance\nAnalytics",
        background = PurpleStart
    ),
    Finance(
        icon= Icons.Default.Add,
        name="My\nTransactions",
        background = GreenStart
    ),
)

@Preview
@Composable
fun FinanceSection(){
Column(modifier= Modifier){
    Text(text = "Finance", fontSize = 24.sp,
    color= MaterialTheme.colorScheme.onBackground,
        fontWeight = FontWeight.Bold,
        modifier=Modifier.padding(16.dp)
    )

    LazyRow {
        items(financeList.size){
            FinanceItem(it)
        }
    }
}

}

@Composable
fun FinanceItem(index:Int){

    val finance=financeList[index];
    var lastitempadding=0.dp;
    if(index== financeList.size-1){
        lastitempadding=16.dp
    }

    Box(modifier=Modifier.padding(start=16.dp, end=lastitempadding)){
    Column(modifier=Modifier
        .clip(RoundedCornerShape(25.dp))
        .background(MaterialTheme.colorScheme.secondaryContainer)
        .size(120.dp)
        .padding(13.dp)
        .clickable {  }
        ,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
           Box(modifier=Modifier
               .clip(RoundedCornerShape(16.dp)).background(finance.background)
               .padding(6.dp)

           ){
               Icon(imageVector = finance.icon
               , contentDescription = finance.name,
                   tint= Color.White
               )
           }

        Text(text=finance.name,
            color=MaterialTheme.colorScheme.onSecondaryContainer,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp

            )
    }
    
    }
}