package com.morrine.hometrix.ui.theme.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.morrine.hometrix.R
import com.morrine.hometrix.navigation.ROUT_SPLASH
import kotlinx.coroutines.delay

@Composable
fun HomeTrixSplashScreen(navController: NavController) {
    val shoutingBlue = Color(0xFF1976D2)
    val vibrantPurple = Color(0xFF7B1FA2)
    val shoutingGray = Color(0xFF424242)
    val vibrantOrange = Color(0xFFFF9800)

    val animatedAlpha = remember { Animatable(0.4f) }

    LaunchedEffect(Unit) {
        while (true) {
            animatedAlpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            )
            animatedAlpha.animateTo(
                targetValue = 0.4f,
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            )

            delay(2000)
            navController.navigate(ROUT_SPLASH) {
                popUpTo(ROUT_SPLASH) { inclusive = true }
            }
        }
    }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(shoutingBlue, vibrantPurple, shoutingGray)
                )
            )
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left side column
        Column(
            modifier = Modifier
                .width(100.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_6),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .border(3.dp, vibrantOrange, RoundedCornerShape(24.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(24.dp))
            "HOMETRIX".forEach { letter ->
                Text(
                    text = letter.toString(),
                    color = vibrantOrange.copy(alpha = animatedAlpha.value),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
            }
        }

        Spacer(modifier = Modifier.width(24.dp))

        // Right side column
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Welcome!",
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White.copy(alpha = animatedAlpha.value)
            )
            Text(
                text = "Find your\nperfect home",
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                color = vibrantOrange.copy(alpha = animatedAlpha.value),
                modifier = Modifier.padding(top = 6.dp, bottom = 24.dp)
            )
            FeatureCard(
                title = "Quick Booking",
                description = "Reserve your dream home in moments.",
                backgroundColor = vibrantOrange,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun FeatureCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(140.dp)
            .shadow(8.dp, RoundedCornerShape(24.dp)),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.9f)
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 700, heightDp = 400)
@Composable
fun HomeTrixSplashScreenPreview() {
    HomeTrixSplashScreen(rememberNavController())
}
