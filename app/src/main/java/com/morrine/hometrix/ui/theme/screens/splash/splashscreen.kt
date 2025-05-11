package com.morrine.hometrix.ui.theme.screens.splash

import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.morrine.hometrix.R
import com.morrine.hometrix.navigation.ROUT_SPLASH2
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.google.accompanist.pager.*
import com.morrine.hometrix.ui.theme.newBlue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun SplashScreen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        delay(2000) // display splash for 5 seconds with animation
        navController.navigate(ROUT_SPLASH2) {
            popUpTo(ROUT_SPLASH2) { inclusive = true }
        }
    }

    // Background Gradient Box
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(newBlue, Color(0xFF90A4AE)) // blue to grey gradient
                )
            )
    ) {
        // Double Wavy Shape at bottom
        DoubleWavyShape(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(180.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AnimatedSplashText()

            Spacer(modifier = Modifier.height(24.dp))

            PropertyImageCarousel()

            Spacer(modifier = Modifier.height(32.dp))

            FeatureCard(
                title = "Easy Booking",
                description = "Reserve your dream home with just a few taps."
            )

            FeatureCard(
                title = "24/7 Support",
                description = "We're here to help anytime, anywhere."
            )
        }
    }
}

@Composable
fun AnimatedSplashText() {
    val texts = listOf(
        "Find your dream home",
        "Affordable Rentals",
        "Secure & Trusted",
        "Best Neighborhoods"
    )
    var currentIndex by remember { mutableStateOf(0) }

    val transition = updateTransition(targetState = currentIndex, label = "TextTransition")

    val alpha by transition.animateFloat(
        transitionSpec = {
            tween(durationMillis = 1500)
        }, label = "AlphaAnim"
    ) { state ->
        if (state == currentIndex) 1f else 0f
    }

    LaunchedEffect(Unit) {
        while(true) {
            delay(3000)
            currentIndex = (currentIndex + 1) % texts.size
        }
    }

    Text(
        text = texts[currentIndex],
        fontSize = 28.sp,
        fontStyle = FontStyle.Italic,
        color = Color(0xFFFF9800), // orange color
        modifier = Modifier.alpha(alpha)
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PropertyImageCarousel() {
    val images = listOf(
        R.drawable.img_1,
        R.drawable.img,
        R.drawable.img_1
    )
    val pagerState = rememberPagerState()

    HorizontalPager(
        state = pagerState,
        count = images.size,
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(16.dp))
    ) { page ->
        Image(
            painter = painterResource(id = images[page]),
            contentDescription = "Property Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun FeatureCard(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFF9800)), // orange background
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.9f)
            )
        }
    }
}

@Composable
fun DoubleWavyShape(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height

        // Wave 1 - Blue
        val path1 = Path().apply {
            moveTo(0f, height * 0.6f)
            quadraticBezierTo(width * 0.25f, height * 0.9f, width * 0.5f, height * 0.7f)
            quadraticBezierTo(width * 0.75f, height * 0.5f, width, height * 0.8f)
            lineTo(width, height)
            lineTo(0f, height)
            close()
        }
        drawPath(path1, Color(0xFF2196F3))

        // Wave 2 - Light Gray
        val path2 = Path().apply {
            moveTo(0f, height * 0.7f)
            quadraticBezierTo(width * 0.25f, height * 0.4f, width * 0.5f, height * 0.6f)
            quadraticBezierTo(width * 0.75f, height * 0.8f, width, height * 0.5f)
            lineTo(width, height)
            lineTo(0f, height)
            close()
        }
        drawPath(path2, Color(0xFF90A4AE))
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}
