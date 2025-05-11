package com.morrine.hometrix.ui.theme.screens.splash

import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.morrine.hometrix.R
import com.morrine.hometrix.navigation.ROUT_LOGIN
import com.morrine.hometrix.navigation.ROUT_REGISTER
import com.morrine.hometrix.ui.theme.newBlue
import com.morrine.hometrix.ui.theme.newOrange
import com.morrine.hometrix.ui.theme.newWhite

import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Splash2Screen(navController: NavController) {
    val infiniteTransition = rememberInfiniteTransition()
    val animatedAlpha by infiniteTransition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.horizontalGradient(
                    colors = listOf(newBlue, Color(0xFF90A4AE)) // deep blue to gray-blue gradient
                )
            )
    ) {
        // Translucent floating circle accent
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = newBlue.copy(alpha = 0.10f),
                center = Offset(size.width * 0.75f, size.height * 0.25f),
                radius = size.minDimension * 0.25f
            )
        }

        // Logo and Text positioned with top padding of 120.dp
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 120.dp)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_6), // Replace with actual logo drawable
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(110.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .shadow(10.dp, RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "WELCOME",
                fontSize = 32.sp,
                fontStyle = FontStyle.Normal,
                color = newWhite.copy(alpha = animatedAlpha),
                textAlign = TextAlign.Center,
            )

            Text(
                text = "Find your dream place",
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                color = newWhite.copy(alpha = animatedAlpha),
                textAlign = TextAlign.Center,
            )
        }

        // Buttons positioned near the bottom with padding
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 64.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedGradientButton(text = "Sign In", onClick = { navController.navigate(ROUT_LOGIN) })
            AnimatedGradientButton(text = "Sign Up", onClick = { navController.navigate(ROUT_REGISTER) })
        }
    }
}


@Composable
fun AnimatedGradientButton(text: String, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    var pressed by remember { mutableStateOf(false) }
    // Observe press interactions to update pressed state
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> pressed = true
                is PressInteraction.Release, is PressInteraction.Cancel -> pressed = false
            }
        }
    }
    val scale by animateFloatAsState(targetValue = if (pressed) 0.95f else 1f)

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .scale(scale),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        interactionSource = interactionSource,
        shape = RoundedCornerShape(28.dp),
        contentPadding = ButtonDefaults.ContentPadding
    ) {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFFFF9800), Color(0xFFF57C00))
                    ),
                    shape = RoundedCornerShape(28.dp)
                )
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = text,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Splash2ScreenPreview() {
    Splash2Screen(navController = rememberNavController())
}
