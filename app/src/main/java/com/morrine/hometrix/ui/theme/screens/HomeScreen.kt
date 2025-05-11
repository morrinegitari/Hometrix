package com.morrine.hometrix.ui.theme.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.morrine.hometrix.ui.theme.screens.landlord.RentalHistoryScreen
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(navController: NavController) {
    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF1630F5), Color.Gray),
        startY = 0f,
        endY = 1000f
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                AnimatedTitle("Home Trix App")

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(cards.size) { index ->
                        FeatureCard(cards[index])
                    }
                }
            }

            BottomNavigationBar()
        }
    }
}

@Composable
fun AnimatedTitle(title: String) {
    Row(modifier = Modifier.padding(bottom = 16.dp)) {
        for (i in title.indices) {
            val offsetY = remember { Animatable(40f) }
            val delayMillis = i * 50L

            LaunchedEffect(Unit) {
                delay(delayMillis)
                offsetY.animateTo(0f, animationSpec = tween(durationMillis = 300))
            }

            Text(
                text = title[i].toString(),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF263238),
                modifier = Modifier.offset(y = offsetY.value.dp)
            )
        }
    }
}

@Composable
fun FeatureCard(card: FeatureCardData) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(12.dp))
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(16.dp)
            .clickable { }
    ) {
        Text(text = card.icon, fontSize = 24.sp)
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = card.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF263238)
            )
            Text(
                text = card.description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    val items = listOf("🏠" to "Home", "💬" to "ChatScreen", "📅" to "Calendar", "⚙️" to "Settings")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White, RoundedCornerShape(24.dp))
            .shadow(8.dp, RoundedCornerShape(24.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,


    ) {
        items.forEach { (icon, _) ->
            Text(
                text = icon,
                fontSize = 24.sp,
                modifier = Modifier.padding(8.dp),
                color = Color(0xFFFF9800)
            )
        }
    }
}

// Data Model for Feature Cards
val cards = listOf(
    FeatureCardData("📊", "Dashboard Overview", "Quick glance at property statuses, occupancy rates, and tasks."),
    FeatureCardData("👥", "Tenant Management", "Manage tenant information and lease agreements."),
    FeatureCardData("🛠️", "Maintenance Requests", "Track and assign maintenance tasks."),
    FeatureCardData("💰", "Financial Reports", "View income, expenses, and financial statements."),
    FeatureCardData("🏘️", "Property Listings", "Manage listings, add new properties, and update details.")
)

data class FeatureCardData(val icon: String, val title: String, val description: String)
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
