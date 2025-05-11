package com.morrine.hometrix.ui.theme.screens.booking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.morrine.hometrix.R
import com.morrine.hometrix.navigation.ROUT_ABOUT
import com.morrine.hometrix.navigation.ROUT_DASHBOARD2
import com.morrine.hometrix.navigation.ROUT_HOME
import com.morrine.hometrix.ui.theme.newOrange
import com.morrine.hometrix.ui.theme.newWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewBookingScreen(navController: NavController) {
                var selectedIndex by remember { mutableStateOf(0) }

                Scaffold(
                    //TopBar
                    topBar = {
                        TopAppBar(
                            title = { Text("Booking Screen") },
                            navigationIcon = {
                                IconButton(onClick = { ROUT_DASHBOARD2 }) {
                                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = newOrange,
                                titleContentColor = Color.White,
                                navigationIconContentColor = Color.White
                            )
                        )
                    },

                    //BottomBar
                    bottomBar = {
                        NavigationBar (
                            containerColor = newOrange
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
                                icon = { Icon(Icons.Default.Info, contentDescription = "Profile") },
                                label = { Text("Info") },
                                selected = selectedIndex == 2,
                                onClick = { selectedIndex = 2
                                      navController.navigate(ROUT_ABOUT)
                                }
                            )

                        }
                    },
                    //end

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
                        Column (
                            modifier = Modifier
                                .padding(paddingValues)
                                .fillMaxSize()
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


                                var houseName by remember { mutableStateOf(TextFieldValue("")) }
                                var checkInDate by remember { mutableStateOf(TextFieldValue("")) }
                                var checkOutDate by remember { mutableStateOf(TextFieldValue("")) }
                                var guests by remember { mutableStateOf(TextFieldValue("")) }
                                var specialRequests by remember { mutableStateOf(TextFieldValue("")) }
                                var bookingConfirmed by remember { mutableStateOf(false) }

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = listOf(Color(0xFF6F9FEA), Color.Gray)
                                            )
                                        )
                                        .padding(20.dp),
                                    verticalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    Text(
                                        text = "House Booking",
                                        fontSize = 26.sp,
                                        color = Color(0xFF080909),
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )

                                    OutlinedTextField(
                                        value = houseName,
                                        onValueChange = { houseName = it },
                                        label = { Text("House / Property Name",color = Color.White) },
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = OutlinedTextFieldDefaults.colors(
                                            focusedBorderColor = Color.White,  // Border color when focused
                                            unfocusedBorderColor = Color.White, // Border color when not focused
                                            focusedTextColor = Color.White,
                                            unfocusedTextColor = Color.White
                                        )
                                    )

                                    OutlinedTextField(
                                        value = checkInDate,
                                        onValueChange = { checkInDate = it },
                                        label = { Text("Check-in Date (YYYY-MM-DD)",color = Color.White) },
                                        placeholder = { Text("YYYY-MM-DD",color = Color.White) },
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = OutlinedTextFieldDefaults.colors(
                                            focusedBorderColor = Color.White,  // Border color when focused
                                            unfocusedBorderColor = Color.White, // Border color when not focused
                                            focusedTextColor = Color.White,
                                            unfocusedTextColor = Color.White
                                        )
                                    )

                                    OutlinedTextField(
                                        value = checkOutDate,
                                        onValueChange = { checkOutDate = it },
                                        label = { Text("Check-out Date (YYYY-MM-DD)",color = Color.White) },
                                        placeholder = { Text("YYYY-MM-DD",color = Color.White) },
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = OutlinedTextFieldDefaults.colors(
                                            focusedBorderColor = Color.White,  // Border color when focused
                                            unfocusedBorderColor = Color.White, // Border color when not focused
                                            focusedTextColor = Color.White,
                                            unfocusedTextColor = Color.White
                                        )
                                    )

                                    OutlinedTextField(
                                        value = guests,
                                        onValueChange = { guests = it },
                                        label = { Text("Number of Guests",color = Color.White) },
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = OutlinedTextFieldDefaults.colors(
                                            focusedBorderColor = Color.White,  // Border color when focused
                                            unfocusedBorderColor = Color.White, // Border color when not focused
                                            focusedTextColor = Color.White,
                                            unfocusedTextColor = Color.White
                                        )
                                    )

                                    OutlinedTextField(
                                        value = specialRequests,
                                        onValueChange = { specialRequests = it },
                                        label = { Text("Special Requests / Notes",color = Color.White) },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(100.dp),
                                        maxLines = 4,
                                        colors = OutlinedTextFieldDefaults.colors(
                                            focusedBorderColor = Color.White,  // Border color when focused
                                            unfocusedBorderColor = Color.White, // Border color when not focused
                                            focusedTextColor = Color.White,
                                            unfocusedTextColor = Color.White
                                        )
                                    )

                                    Button(
                                        onClick = {
                                            // Simulate booking confirmation
                                            bookingConfirmed = true
                                        },
                                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107)),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text("Book Now", color = Color.White, fontSize = 18.sp)
                                    }

                                    if (bookingConfirmed) {
                                        Text(
                                            text = "Booking confirmed for $houseName!",
                                            color = Color(0xFFE08F18),
                                            fontSize = 16.sp,
                                            modifier = Modifier.fillMaxWidth(),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }

                                //END
                            }


                        }


                    }
                )

                //End of scaffold










}

@Preview(showBackground = true)
@Composable
fun ViewBookingScreenPreview() {
    ViewBookingScreen(rememberNavController())
}
