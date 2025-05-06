package com.morrine.hometrix.ui.theme.screens.dashboard

import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
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
import com.morrine.hometrix.navigation.ROUT_BOOKING
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
fun DashBoard2Screen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tenants Dashboard") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle nav */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = newOrange,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = newOrange) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.MailOutline, contentDescription = "Booking") },
                    label = { Text("Booking") },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(ROUT_BOOKING)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = selectedIndex == 2,
                    onClick = {
                        selectedIndex = 2
                        // navController.navigate(ROUT_PROFILE)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = "Info") },
                    label = { Text("Info") },
                    selected = selectedIndex == 3,
                    onClick = {
                        selectedIndex = 3
                        // navController.navigate(ROUT_INFO)
                    }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Handle add */ },
                containerColor = Color.LightGray
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .background(newWhite)
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.img_10),
                    contentDescription = "Header Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Explore Unit Types",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = newOrange
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Button grid
                val buttonModifier = Modifier
                    .weight(1f)
                    .height(50.dp)

                val buttonShape = RoundedCornerShape(10.dp)

                fun unitButton(label: String, route: String) = @androidx.compose.runtime.Composable {
                    Button(
                        onClick = { navController.navigate(route) },
                        colors = ButtonDefaults.buttonColors(newBlue),
                        shape = buttonShape,
                        modifier = buttonModifier
                    ) {
                        Text(text = label, fontSize = 16.sp)
                    }
                }

                val unitTypes = listOf(
                    "Bedsitter" to ROUT_BEDSITTER,
                    "Single Room" to ROUT_SINGLEROOM,
                    "1 Bedroom" to ROUT_BEDROOM1,
                    "2 Bedroom" to ROUT_BEDROOM2,
                    "3 Bedroom" to ROUT_BEDROOM3,
                    "SingleFamily" to ROUT_SINGLEFAMILY,
                    "Apartment" to ROUT_APARTMENT,
                    "Shop" to ROUT_SHOP,
                )

                unitTypes.chunked(2).forEach { rowItems ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        rowItems.forEach { (label, route) ->
                            unitButton(label, route).invoke()
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DashBoard2ScreenPreview(){
    DashBoard2Screen(rememberNavController())
}

