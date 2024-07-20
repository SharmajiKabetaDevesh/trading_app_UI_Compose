package com.example.quizapp

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.BlueEnd
import com.example.quizapp.ui.theme.BlueStart
import com.example.quizapp.ui.theme.GreenEnd
import com.example.quizapp.ui.theme.GreenStart
import com.example.quizapp.ui.theme.OrangeEnd
import com.example.quizapp.ui.theme.OrangeStart
import com.example.quizapp.ui.theme.PurpleEnd
import com.example.quizapp.ui.theme.PurpleStart


val cards:List<CardDetails> =listOf(
    CardDetails("VISA","4111 7411 4111 4111","Business",36.67,color= getGradient(PurpleStart, PurpleEnd)),
    CardDetails("MASTER CARD","4805 8143 7286 8143","Business",46.67,color= getGradient(BlueStart, BlueEnd)),
    CardDetails("SAVINGS CARD","4111 7411 4111 4111","Business",5.67,color= getGradient(OrangeStart, OrangeEnd)),
    CardDetails("SCHOOL CARD","4111 7411 4111 4111","Business",1.67,color= getGradient(GreenStart,
        GreenEnd))

)

fun getGradient(
    startColor:Color,
    endColor:Color,

    ):Brush{
    return Brush.horizontalGradient(
        colors=listOf(startColor,endColor)
    )
}

@Composable
fun CardsSection(){
    LazyRow{
        items(cards.size){index->
            CardItem(index)
        }
    }
}



@Composable
fun CardItem(index:Int){

    val card=cards[index]
    var lastItempaddingEnd=0.dp
    if(index==cards.size-1){
        lastItempaddingEnd=16.dp
    }
    var image= painterResource(id = R.drawable.ic_visa)
    if(card.cardType=="MASTER CARD"){
        image= painterResource(id = R.drawable.ic_mastercard)
    }
    Box(modifier=Modifier.padding(start=16.dp,end=lastItempaddingEnd)){
        Column(modifier= Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(card.color)
            .width(250.dp)
            .height(200.dp)
            .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween) {

            Image(painter=image,

                contentDescription = card.cardName,
                modifier=Modifier.width(60.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = card.cardName,
                color=Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
                )


            Text(text =  "${card.balance}",
                color=Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )


            Text(text = card.cardNumber,
                color=Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )



        }

    }
}

