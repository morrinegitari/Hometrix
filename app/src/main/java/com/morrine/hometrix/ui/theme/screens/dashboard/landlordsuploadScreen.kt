package com.morrine.hometrix.ui.theme.screens.dashboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                val navController = rememberNavController()
                LandlorduploadCScreen(navController)
            }
        }
    }

    @Composable
    fun LandlorduploadCScreen(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "selection") {
            composable("selection") { RoomSelectionScreen(navController) }
            composable("bedsitter") { UploadScreen("Bedsitter Upload Screen") }
            composable("single") { UploadScreen("Single Room Upload Screen") }
            composable("one_bedroom") { UploadScreen("1 Bedroom Upload Screen") }
            composable("two_bedroom") { UploadScreen("2 Bedroom Upload Screen") }
            composable("three_bedroom") { UploadScreen("3 Bedroom Upload Screen") }
            composable("apartment") { UploadScreen("Family Apartment Upload Screen") }
            composable("shop") { UploadScreen("Shop Upload Screen") }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun RoomSelectionScreen(navController: NavController) {
        val rooms = listOf(
            "Bedsitter" to "bedsitter",
            "Single Room" to "single",
            "1 Bedroom" to "one_bedroom",
            "2 Bedroom" to "two_bedroom",
            "3 Bedroom" to "three_bedroom",
            "Family Apartment" to "apartment",
            "Shop" to "shop"
        )

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Upload Room Type", color = Color.White) },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF1976D2))
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                rooms.forEach { (label, route) ->
                    Button(
                        onClick = { navController.navigate(route) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = label, color = Color.White, fontSize = 18.sp)
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun UploadScreen(title: String) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(title, color = Color.White) },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF1976D2))
                )
            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = title, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun LandlorduploadScreenPreview(){
    LandlorduploadCScreen(rememberNavController())
}
