package com.morrine.hometrix.ui.theme.screens.dashboard

import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.morrine.hometrix.R
import com.morrine.hometrix.navigation.ROUT_APARTMENT
import com.morrine.hometrix.navigation.ROUT_BEDROOM1
import com.morrine.hometrix.navigation.ROUT_BEDROOM2
import com.morrine.hometrix.navigation.ROUT_BEDROOM3
import com.morrine.hometrix.navigation.ROUT_BEDSITTER
import com.morrine.hometrix.navigation.ROUT_HOME
import com.morrine.hometrix.navigation.ROUT_SHOP
import com.morrine.hometrix.navigation.ROUT_SINGLEFAMILY
import com.morrine.hometrix.navigation.ROUT_SINGLEROOM
import com.morrine.hometrix.ui.theme.grey
import com.morrine.hometrix.ui.theme.newBlue
import com.morrine.hometrix.ui.theme.newOrange
import com.morrine.hometrix.ui.theme.newWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoard2Screen(navController: NavController){
    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("Tenants Screen") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back/nav */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = grey,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },

        //BottomBar
        bottomBar = {
            NavigationBar (
                containerColor = grey
            ){
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        // navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        //  navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = "Profile") },
                    label = { Text("Info") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        //  navController.navigate(ROUT_HOME)
                    }
                )

            }
        },

        //FloatingActionButton
        floatingActionButton = {
            FloatingActionButton (
                onClick = { /* Add action */ },
                containerColor = Color.LightGray
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        //contents
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                var mContext = LocalContext.current


                //Main Contents of the page
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 16.dp, vertical = 24.dp)
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    Column (modifier = Modifier.fillMaxSize()) {
                        var mContext = LocalContext.current
                        Image(
                            painter = painterResource(R.drawable.img_10),
                            contentDescription = "watch",
                            modifier = Modifier.size(300.dp).fillMaxSize()
                        )

                        Text(text = "Explore unit types :", fontSize = 30.sp)
                        Spacer(modifier = Modifier.height(30.dp).width(50.dp))
                        //row
                        Row ( modifier = Modifier.padding(start = 2.dp, end = 2.dp)){
                            Button(
                                onClick = {
                                    navController.navigate(ROUT_BEDSITTER)
                                },
                                colors = ButtonDefaults.buttonColors(newBlue),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.height(50.dp).width(180.dp),



                                ) {
                                Text(text = "Bedsitter", fontSize = 20.sp)


                            }
                            Spacer(modifier = Modifier.width(10.dp))

                            Spacer(modifier = Modifier.height(20.dp))
                            Button(
                                onClick = {
                                    navController.navigate(ROUT_SINGLEROOM)
                                },
                                colors = ButtonDefaults.buttonColors(newBlue),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.height(50.dp).width(180.dp)


                            ) {
                                Text(text = "Single Room", fontSize = 20.sp)

                            }
                        }
                        //end row
                        Spacer(modifier = Modifier.height(30.dp))
                        //row
                        Row ( modifier = Modifier.padding(start = 2.dp, end = 2.dp)){
                            Button(
                                onClick = {
                                    navController.navigate(ROUT_BEDROOM1)
                                },
                                colors = ButtonDefaults.buttonColors(newBlue),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.height(50.dp).width(180.dp),



                                ) {
                                Text(text = "1 Bedroom", fontSize = 20.sp)


                            }
                            Spacer(modifier = Modifier.width(10.dp))


                            Button(
                                onClick = {
                                    navController.navigate(ROUT_BEDROOM2)
                                },
                                colors = ButtonDefaults.buttonColors(newBlue),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.height(50.dp).width(180.dp)


                            ) {
                                Text(text = "2 Bedroom", fontSize = 20.sp)

                            }
                        }
                        //end row
                        Spacer(modifier = Modifier.height(30.dp))
                        //row
                        Row ( modifier = Modifier.padding(start = 2.dp, end = 2.dp)){
                            Button(
                                onClick = {
                                    navController.navigate(ROUT_BEDROOM3)
                                },
                                colors = ButtonDefaults.buttonColors(newBlue),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.height(50.dp).width(180.dp),



                                ) {
                                Text(text = "3 Bedroom", fontSize = 20.sp)



                            }


                            Spacer(modifier = Modifier.width(10.dp))
                            Button(
                                onClick = {
                                    navController.navigate(ROUT_SINGLEFAMILY)
                                },
                                colors = ButtonDefaults.buttonColors(newBlue),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.height(50.dp).width(180.dp)


                            ) {
                                Text(text = "SingleFamily", fontSize = 20.sp)

                            }
                        }
                        //end row


                        Spacer(modifier = Modifier.height(30.dp))
                        //row
                        Row ( modifier = Modifier.fillMaxWidth().padding(start = 2.dp, end = 2.dp)){
                            Button(
                                onClick = {
                                    navController.navigate(ROUT_APARTMENT)
                                },
                                colors = ButtonDefaults.buttonColors(newBlue),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.height(50.dp).width(180.dp),



                                ) {
                                Text(text = "Apartment", fontSize = 20.sp)



                            }
                            Spacer(modifier = Modifier.width(10.dp))

                            Spacer(modifier = Modifier.height(20.dp))
                            Button(
                                onClick = {
                                    navController.navigate(ROUT_SHOP)
                                },
                                colors = ButtonDefaults.buttonColors(newBlue),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.height(50.dp).width(180.dp)


                            ) {
                                Text(text = "Shop", fontSize = 20.sp)

                            }
                        }
                        //end row





                    }



                }
            }




            }



    )

    //End of scaffold
}

@Preview(showBackground = true)
@Composable
fun DashBoard2ScreenPreview(){
    DashBoard2Screen(rememberNavController())
}