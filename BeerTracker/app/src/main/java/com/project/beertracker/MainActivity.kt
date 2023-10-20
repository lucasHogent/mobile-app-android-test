package com.project.beertracker


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.project.beertracker.ui.theme.BeerTrackerTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            BeerTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopAppBar(pageName = "Home 2")
                }
            }
        }
    }

}

@Composable
fun TopAppBar(pageName: String) {

    Row(
        modifier = Modifier
            .padding(0.dp)
            .height(64.dp)
            .background(color = Color(0xFFF3EDF7))
            .padding(start = 4.dp, top = 8.dp, end = 4.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .width(48.dp)
                .height(48.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                horizontalArrangement = Arrangement.spacedBy(
                    10.dp,
                    Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        10.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
//                    Image(
//                        painter = painterResource(id = R..),
//                        contentDescription = "Personal settings",
//                        contentScale = ContentScale.None
//                    )


                }
            }
        }

        Text(
            text = pageName,
            modifier = Modifier
                .width(244.dp)
                .height(28.dp),
            // M3/title/large
            style = TextStyle(
                fontSize = 22.sp,
                lineHeight = 28.sp,
                //fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(400),
                color = Color(0xFF1D1B20),

                textAlign = TextAlign.Center,
            )
        )

        Column(
            modifier = Modifier
                .width(48.dp)
                .height(48.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                horizontalArrangement = Arrangement.spacedBy(
                    10.dp,
                    Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        10.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
//                    Image(
//                        modifier = Modifier
//                            .padding(1.dp)
//                            .width(24.dp)
//                            .height(24.dp),
//                        painter = painterResource(id = R.drawable.notifications_icon),
//                        contentDescription = "Notifications",
//                        contentScale = ContentScale.None
//                    )
                    Row(
                        modifier = Modifier
                            .offset(x = 333.dp, y = 12.dp)
                            .padding(3.dp)
                            .width(16.dp)
                            .height(16.dp)
                            .background(
                                color = Color(0xFFB3261E),
                                shape = RoundedCornerShape(size = 100.dp)
                            )
                            .padding(start = 4.dp, end = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(
                            0.dp,
                            Alignment.CenterHorizontally
                        ),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "3",
                            modifier = Modifier
                                .width(8.dp)
                                .height(16.dp),
                            // M3/label/small
                            style = TextStyle(
                                fontSize = 11.sp,
                                lineHeight = 16.sp,
                                //fontFamily = FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFFFFFFFF),
                                textAlign = TextAlign.Center,
                                letterSpacing = 0.5.sp,
                            )
                        )
                    }

                }
            }
        }
    }
}

