package com.morrine.hometrix.ui.theme.screens.splash

import  android.annotation.SuppressLint
import android.window.SplashScreen
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.morrine.hometrix.R
import com.morrine.hometrix.navigation.ROUT_HOME
import com.morrine.hometrix.navigation.ROUT_LOGIN
import com.morrine.hometrix.navigation.ROUT_REGISTER
import com.morrine.hometrix.navigation.ROUT_SPLASH2
import com.morrine.hometrix.ui.theme.newBlue
import com.morrine.hometrix.ui.theme.newWhite
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen( navController: NavController) {
    //Navigation
    var coroutine = rememberCoroutineScope()
    coroutine.launch{
        delay(2000)
        navController.navigate(ROUT_SPLASH2)
    }



    //End Navigation
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(newBlue)
            .paint(painter = painterResource(R.drawable.img_12), contentScale = ContentScale.FillBounds)

        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = "HOMETRIX App",
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            color = newWhite


            )
        Text(
            text = "Find best home at your place",
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            color = newWhite


            )
        Image(
            painter = painterResource(R.drawable.img_1),
            contentDescription = "watch",
            modifier = Modifier.size(300.dp).fillMaxSize()
        )











    }

}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen(rememberNavController())
}
