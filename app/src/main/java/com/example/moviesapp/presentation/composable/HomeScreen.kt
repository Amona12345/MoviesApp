package com.example.screenstask.presentaion.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.moviesapp.R
import com.example.moviesapp.presentation.model.MovieVewModel
import com.example.moviesapp.presentation.screen.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieHorzintalPager(
    viewModel:MovieVewModel = hiltViewModel(),
    navController: NavController
) {
    val state by viewModel.state.collectAsState()
    val images = listOf(
        R.drawable.images,
        R.drawable.image3,
        R.drawable.image2,
        R.drawable.images,
        R.drawable.image3,
        R.drawable.image2,
        R.drawable.image2,
        R.drawable.image2,
        R.drawable.image2,
    )
    Column(
        modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.images),
                contentDescription = "backgroundImage",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .alpha(0.8f)
            )

            Row {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    border = BorderStroke(
                        2.dp,
                        Color.White
                    ),
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .height(100.dp)
                        .padding(25.dp)
                        .width(145.dp)
                ) {
                    Text(text = "Now Streaming", color = Color.White)
                }
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    border = BorderStroke(
                        2.dp,
                        Color.White
                    ),
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .height(100.dp)
                        .padding(25.dp)
                        .width(145.dp)
                ) {
                    Text(text = "coming soon", color = Color.White)
                }
            }
            val pagerState = rememberPagerState { PAGES }
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 60.dp),
                pageSpacing = 4.dp, modifier = Modifier
                    .padding(50.dp, 100.dp, 50.dp)
            ) { index ->
                val pageOfset =
                    (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
                val imageSize by animateFloatAsState(
                    targetValue = (if (pageOfset != 0.0f) 0.75f else 1f),
                    animationSpec = tween(durationMillis = 200), label = ""
                )
                AsyncImage(
                    modifier = Modifier
                        .height(300.dp)
                        .width(250.dp)
                        .clickable { navController.navigate(Screen.Search.route) }
                        .clip(RoundedCornerShape(16.dp))
                        .graphicsLayer {
                            scaleX = imageSize
                            scaleY = imageSize
                        },
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(images[index]).build(),
                    contentDescription = "ImagePager",
                    contentScale = ContentScale.Crop
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(15.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_access_time_24),
                    contentDescription = "addImage"
                )
                Text(text = "2h 23m", color = Color.Black)

            }

            Text(
                textAlign = TextAlign.Center,
                text = state.moviename.toString(), color = Color.Black, fontSize = 30.sp
            )
            Row() {
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
        }
    }
}
private const val PAGES=3