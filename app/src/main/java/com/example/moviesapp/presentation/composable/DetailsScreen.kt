package com.example.moviesapp.presentation.composable


import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moviesapp.R
import com.example.moviesapp.presentation.screen.Screen

@Composable
fun Search(navController: NavController){
    val youTube ="https://youtu.be/QRjDOMFsg1o?si=3RbwirOT6Ug_4zik"
    val context = LocalContext.current
    val yIntent= remember {Intent(Intent.ACTION_VIEW, Uri.parse(youTube))}
    Column(modifier = Modifier.fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally) {

        Box(modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.images),
                contentDescription = "backgroundImage",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp))
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Row(modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth()
                    .height(80.dp),horizontalArrangement = Arrangement.spacedBy(150.dp),
                    verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(id = R.drawable.baseline_close_24),
                        contentDescription ="remoeImage", modifier = Modifier
                            .size(40.dp)
                            .clickable { navController.navigate(Screen.Home.route) } )
                    Button(onClick = { },
                        colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
                        Row (horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically){
                            Image(painter = painterResource(id = R.drawable.baseline_watch_later_24), contentDescription = "addImage")
                            Text(text = "2h 23m", color = Color.White)
                        }
                    }
                }
                Image(painter = painterResource(id = R.drawable.baseline_slow_motion_video_24), contentDescription = "vedioImage",
                    modifier = Modifier
                        .size(70.dp)
                        .clickable { context.startActivity(yIntent) })
            }

        }



        Card (
            Modifier
                .fillMaxWidth()
                .height(600.dp)
                .padding(8.dp), shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ){
            Column (horizontalAlignment = Alignment.CenterHorizontally) {
                Row (horizontalArrangement = Arrangement.spacedBy(90.dp), modifier = Modifier.padding(10.dp)){
                    Text(text = "6.8/10",style = TextStyle(fontWeight = FontWeight.Bold))
                    Text(text = "63%",style = TextStyle(fontWeight = FontWeight.Bold))
                    Text(text = "4/10",style = TextStyle(fontWeight = FontWeight.Bold))

                }
                Row (horizontalArrangement = Arrangement.spacedBy(70.dp),modifier = Modifier.padding(start = 4.dp)){
                    Text(text = "IMDB", style = TextStyle(fontWeight = FontWeight.Light))
                    Text(text = "Rotten Tomatoes ", style = TextStyle(fontWeight = FontWeight.Light))
                    Text(text = "IGN", style = TextStyle(fontWeight = FontWeight.Light))

                }
                Text(
                    textAlign = TextAlign.Center,
                    text = "Fantastic Beats :" +
                            "The Secrets Of Dumbledore", color = Color.Black, fontSize = 30.sp
                )
                Row {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(Color.White),
                        border = BorderStroke(
                            2.dp,
                            Color.Black
                        ),
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .height(90.dp)
                            .padding(25.dp)
                            .width(145.dp)
                    ) {
                        Text(text = "Fantasy", color = Color.Black)
                    }
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(Color.White),
                        border = BorderStroke(
                            2.dp,
                            Color.Black
                        ),
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .height(90.dp)
                            .padding(25.dp)
                            .width(145.dp)
                    ) {
                        Text(text = "Adventure", color = Color.Black)
                    }
                }
                LazyRow(modifier = Modifier.fillMaxWidth(),contentPadding = PaddingValues(16.dp)){
                    items(10){item->
                        Image(painter = painterResource(id = R.drawable.images) ,contentDescription = "backgroundImage",
                            contentScale = ContentScale.Crop, modifier = Modifier
                                .size(90.dp)
                                .clip(CircleShape)
                                .border(
                                    3.dp,
                                    Color.White, CircleShape
                                )
                        )

                    }}
                Text(text = "stringResource()",
                    modifier = Modifier.padding(10.dp), style =
                    TextStyle(fontSize = 20.sp)
                )
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .height(100.dp)
                        .padding(25.dp)
                        .width(150.dp)
                ) {
                    Text(text = "Booking", color = Color.White, style = TextStyle(fontSize = 20.sp) )
                }
            }
        }
    }}