package com.morrine.hometrix.ui.theme.screens.dashboard

import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.morrine.hometrix.R
import com.morrine.hometrix.ui.theme.grey
import com.morrine.hometrix.ui.theme.newBlue
import com.morrine.hometrix.ui.theme.newOrange
import com.morrine.hometrix.ui.theme.newWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoardScreen(navController: NavController){

    Column (modifier = Modifier.fillMaxSize()){
        var mContext = LocalContext.current


        //TopAppBar
        TopAppBar(
            title = {
                Text(text = "Intents")},
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = grey,
                titleContentColor = newWhite,
                navigationIconContentColor = newWhite,
                actionIconContentColor = newWhite
            ),
            navigationIcon = {
                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Default.Menu, contentDescription ="" )
                }
            },
            actions = {
                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Default.Share, contentDescription ="" )
                }
                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Default.Settings, contentDescription ="" )
                }

            }
        )
        //end
        Image(
            painter = painterResource(R.drawable.img_10),
            contentDescription = "watch",
            modifier = Modifier.size(300.dp).fillMaxSize().padding(start = 50.dp, )
        )
        Spacer(modifier = Modifier.height(20.dp))
        //MPESA
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(newBlue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

        ) {
            Text(text = "Add new property", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        //CALL
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(newBlue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

        ) {
            Text(text = "Manage Listing", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        //SMS
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(newBlue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

        ) {
            Text(text = "view Inquiries", fontSize =20.sp )
        }
        Spacer(modifier = Modifier.height(20.dp))
        //SHARE
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(newBlue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

        ) {
            Text(text = "Booking requests", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        //CAMERA
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(newBlue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

        ) {
            Text(text = "Upload Photos", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))

    }

}

@Preview(showBackground = true)
@Composable
fun DashBoardScreenPreview(){
    com.morrine.hometrix.ui.theme.screens.dashboard .DashBoardScreen(rememberNavController())
}
