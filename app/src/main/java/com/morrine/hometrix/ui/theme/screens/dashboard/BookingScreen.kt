package com.morrine.hometrix.ui.theme.screens.dashboard

// 📦 Imports
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.morrine.hometrix.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.morrine.hometrix.ui.theme.newBlue
import com.morrine.hometrix.ui.theme.newOrange
import com.morrine.hometrix.ui.theme.newWhite


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var showSuccess by remember { mutableStateOf(false) }
    val mContext = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Booking Screen") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = newOrange,
                    titleContentColor = newWhite
                ),
                navigationIcon = {
                    IconButton(onClick = { /* Back action */ }) {
                        Icon(Icons.Default.Menu, contentDescription = null)
                    }
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(newWhite)
                    .padding(padding)
            ) {
                // Image Section
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_11),
                        contentDescription = "watch",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                }

                // Booking Form
                Card(
                    shape = DoubleWaveShape(),
                    elevation = CardDefaults.cardElevation(8.dp),
                    colors = CardDefaults.cardColors(containerColor = newWhite),
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-40).dp)
                        .padding(horizontal = 16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(
                            "Please fill out the form to complete your booking.",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )

                        val fieldColors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = newBlue,
                            focusedContainerColor = newBlue,
                            unfocusedTextColor = Color.White,
                            focusedTextColor = Color.White,
                            cursorColor = Color.White
                        )

                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            label = { Text("Full Name",fontSize = 18.sp, color = Color.White) },
                            shape = RoundedCornerShape(12.dp),
                            colors = fieldColors,
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email Address",fontSize = 18.sp, color = Color.White) },
                            shape = RoundedCornerShape(12.dp),
                            colors = fieldColors,
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = phone,
                            onValueChange = { phone = it },
                            label = { Text("Phone Number",fontSize = 18.sp, color = Color.White) },
                            shape = RoundedCornerShape(12.dp),
                            colors = fieldColors,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Button(
                            onClick = {
                                val simToolKitIntent =
                                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitIntent?.let { mContext.startActivity(it) }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = newBlue)
                        ) {
                            Text("Make Payment",fontSize = 18.sp, color = Color.White, modifier = Modifier.padding(end = 150.dp))
                        }

                        Button(
                            onClick = {
                                if (name.isNotBlank() && phone.isNotBlank()) {
                                    showSuccess = true
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = newBlue)
                        ) {
                            Text("Book Now",
                                color = Color.White, fontSize = 18.sp,
                                modifier = Modifier.padding(end = 180.dp))
                        }

                        if (showSuccess) {
                            Text(
                                "Booking Successful!",
                                color = Color(0xFF388E3C),
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    )
}


// 🌊 Double Wave Shape Definition
fun DoubleWaveShape(): Shape = GenericShape { size, _ ->
    val width = size.width
    val height = size.height

    moveTo(0f, 60f)
    quadraticBezierTo(width / 4, 0f, width / 2, 60f)
    quadraticBezierTo(3 * width / 4, 120f, width, 60f)
    lineTo(width, height)
    lineTo(0f, height)
    close()
}



@Preview(showBackground = true)
@Composable
fun BookingScreenPreview(){
    BookingScreen(rememberNavController())
}
