package com.example.quizapp

import android.graphics.Paint.Align
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.GreenStart

val currencies=listOf(

    Currency("RUPPEE",83.35f,1f),
    Currency("EURO",823.35f,10.4f),
    Currency("DOLLAR",843.35f,15.4f),
    Currency("YEN",05f,1.4f)

)
val image=listOf(
    R.drawable.ruppee,
    R.drawable.euro,
    R.drawable.dollar,
    R.drawable.yen
)

@Preview
@Composable
fun CurrenciesSection(){
     var isvisible by remember {
         mutableStateOf(false)
     }

    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }
 Box(modifier=Modifier
     .fillMaxSize()
     .padding(top=32.dp),
     contentAlignment = Alignment.BottomCenter){
    Column(modifier= Modifier
        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
        .background(MaterialTheme.colorScheme.inverseOnSurface)
        .animateContentSize()
    ) {
       
        
        Row(modifier= Modifier

            .padding(16.dp)
            .animateContentSize()
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
            ){
            Box(modifier= Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.onSecondary)
                .clickable {
                    isvisible = !isvisible
                    iconState = if (isvisible) {
                        Icons.Rounded.KeyboardArrowUp
                    } else {
                        Icons.Rounded.KeyboardArrowDown
                    }
                }
                
            ){
                Icon(imageVector =iconState ,
                    contentDescription = "Currencies",
                    modifier=Modifier.size(25.dp),
                    tint=MaterialTheme.colorScheme.onSecondary)
            }
            Spacer(modifier = Modifier.width(20.dp))
            Text(text="Currencies",
            fontSize = 20.sp,
                color=MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Bold,

            )
        }

        Spacer(modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer))


        if(isvisible){
            BoxWithConstraints(
                modifier= Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp)
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .background(MaterialTheme.colorScheme.background)
            ) {
               val box=this
                val width=box.maxWidth/3

                Column(modifier= Modifier
                    .fillMaxWidth()
                    .padding(10.dp)) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (
                        modifier=Modifier.fillMaxWidth()
                    ){


                        Text( modifier=Modifier.width(width)
                            ,text = "Currency"
                        , fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color=MaterialTheme.colorScheme.onBackground,
                            textDecoration = TextDecoration.None,

                        )

                        Text( modifier=Modifier.width(width)
                            ,text = "Buy"
                            , fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color=MaterialTheme.colorScheme.onBackground,
                            textAlign= TextAlign.End,

                        )

                        Text( modifier=Modifier.width(width)
                            ,text = "Sell"
                            , fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color=MaterialTheme.colorScheme.onBackground,
                                    textAlign= TextAlign.End,

                        )

                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    LazyColumn(
                        modifier=Modifier
                    ) {
items(currencies.size){
    CurrencyItem(index = it, width = width)
}
                    }
                }
            }
        }
    }
 }
}


@Composable
fun CurrencyItem(index:Int,width:Dp){
 val currency= currencies[index]
 val image=image[index]
    Row(
        modifier= Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
          Box(modifier= Modifier
              .clip(RoundedCornerShape(8.dp))
              .background(GreenStart)
              .padding(4.dp)
          ){
              Icon(
                  modifier=Modifier.size(18.dp),
                  painter = painterResource(image),
                  contentDescription = currency.name,
                  tint=Color.White)
          }

        Text(text=currency.name,

            modifier=Modifier.padding(start = 10.dp).width(width)
             , fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color=MaterialTheme.colorScheme.onBackground,

        )

        Text(text=currency.sell.toString(),

            modifier=Modifier.padding(start = 10.dp).width(width)
            , fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color=MaterialTheme.colorScheme.onBackground,
                      textAlign = TextAlign.Center
            )

        Text(text=currency.sell.toString(),

            modifier=Modifier.padding(start = 10.dp).width(width)
            , fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color=MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
            )
    }
}