package com.morrine.hometrix.ui.theme.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.morrine.hometrix.R
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.morrine.hometrix.navigation.ROUT_LANDLORDUPLOAD
import com.morrine.hometrix.ui.theme.grey
import com.morrine.hometrix.ui.theme.newBlue
import com.morrine.hometrix.ui.theme.newOrange
import com.morrine.hometrix.ui.theme.newWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoardScreen(navController: NavController) {
    val mContext = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(newWhite)
    ) {
        // TopAppBar
        TopAppBar(
            title = {
                Text(
                    text = "Landlords Screen",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = newOrange,
                titleContentColor = Color.White
            ),
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "Share", tint = Color.White)
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings", tint = Color.White)
                }
            }
        )

        // Box for card stacking
        Box(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            // Top Card - Image
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.img_10),
                    contentDescription = "Property Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            // Bottom Card - Details with wave
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 370.dp)
                    .align(Alignment.BottomCenter),
                shape = TripleWaveShape(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor =newWhite)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Manage your properties easily and efficiently.",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    // Buttons
                    val buttonModifier = Modifier.fillMaxWidth()

                    Button(
                        onClick = { navController.navigate(ROUT_LANDLORDUPLOAD) },
                        colors = ButtonDefaults.buttonColors(newBlue),
                        shape = RoundedCornerShape(10.dp),
                        modifier = buttonModifier
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Upload", tint = newBlue)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Upload Property", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }

                    Button(
                        onClick = { /* Logic for manage listing */ },
                        colors = ButtonDefaults.buttonColors(newBlue),
                        shape = RoundedCornerShape(10.dp),
                        modifier = buttonModifier
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.List, contentDescription = "Manage", tint = newBlue)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Manage Listing", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }

                    Button(
                        onClick = { /* Logic for view inquiries */ },
                        colors = ButtonDefaults.buttonColors(newBlue),
                        shape = RoundedCornerShape(10.dp),
                        modifier = buttonModifier
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.Email, contentDescription = "Inquiries", tint = newBlue)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("View Inquiries", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

fun TripleWaveShape(): Shape = GenericShape { size, _ ->
    val width = size.width
    val height = size.height

    moveTo(0f, 60f)

    // First wave
    quadraticBezierTo(
        width / 6, 0f,
        width / 3, 60f
    )

    // Second wave
    quadraticBezierTo(
        width / 2, 120f,
        2 * width / 3, 60f
    )

    // Third wave
    quadraticBezierTo(
        5 * width / 6, 0f,
        width, 60f
    )

    // Complete the shape
    lineTo(width, height)
    lineTo(0f, height)
    close()
}


@Preview(showBackground = true)
@Composable
fun DashBoardScreenPreview() {
    DashBoardScreen(rememberNavController())
}
