package com.morrine.hometrix.ui.theme.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Splash2Screen( navController: NavController) {




    //End Navigation
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(newBlue)
            .paint(painter = painterResource(R.drawable.img_12), contentScale = ContentScale.FillBounds)

        ,


    ) {

        Spacer(modifier = Modifier.height(200.dp))

        Text(
            text = "WELCOME",
            fontSize =30.sp,
            fontStyle = FontStyle.Normal,
            color = newWhite,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)


        )
        Text(
            text = "Find your dream place",
            fontSize = 18.sp,
            fontStyle = FontStyle.Normal,
            color = newWhite,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)


        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {navController.navigate(ROUT_LOGIN)},


            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            colors = ButtonDefaults.buttonColors(newBlue)


        ) {
            Text(text = "Sign In", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {navController.navigate(ROUT_REGISTER)},
            colors = ButtonDefaults.buttonColors(newBlue),

            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth() 
                .padding(start = 30.dp, end = 30.dp)


        ) {
            Text(text = "Sign Up", fontSize = 20.sp)
        }











    }

}


@Preview(showBackground = true)
@Composable
fun Splash2ScreenPreview(){
    Splash2Screen(rememberNavController())
}
