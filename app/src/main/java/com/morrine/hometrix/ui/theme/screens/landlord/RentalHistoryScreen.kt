package com.morrine.hometrix.ui.theme.screens.landlord

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import blue
import com.morrine.hometrix.R

import orange


@Composable
fun RentalHistoryScreen(navController: NavController) {
    val rentals = listOf(
        RentalHistoryItem("Green View Apartments", "Jan 2023", "Dec 2023", "Completed"),
        RentalHistoryItem("Sunset Villas", "Feb 2022", "Jan 2023", "Completed"),
        RentalHistoryItem("Downtown Studio", "Mar 2021", "Jan 2022", "Cancelled")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(blue)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Rental History",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        rentals.forEach { rental ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.history),
                        contentDescription = "History Icon",
                        tint = orange,
                        modifier = Modifier.size(40.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(text = rental.propertyName, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(text = "${rental.startDate} - ${rental.endDate}", fontSize = 14.sp)
                        Text(text = "Status: ${rental.status}", fontSize = 14.sp, color = Color.Gray)
                    }
                }
            }
        }
    }
}

data class RentalHistoryItem(
    val propertyName: String,
    val startDate: String,
    val endDate: String,
    val status: String
)

@Preview(showBackground = true)
@Composable
fun RentalHistoryScreenPreview() {
    RentalHistoryScreen(navController = rememberNavController())
}

