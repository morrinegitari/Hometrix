package com.morrine.hometrix.ui.theme.screens.landlord

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.tooling.preview.Preview

data class TenantInquiry(val name: String, val message: String, val timestamp: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TenantInquiriesScreen(navController: NavController) {
    val inquiries = listOf(
        TenantInquiry("Alice M.", "Is the property at Kileleshwa still available?", "May 8, 2025"),
        TenantInquiry("Brian O.", "Can I schedule a viewing this weekend?", "May 7, 2025"),
        TenantInquiry("Catherine K.", "What's the deposit policy?", "May 6, 2025")
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tenant Inquiries") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.Email, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2196F3),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }


    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color(0xFFBBDEFB))
                .padding(16.dp)
        ) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(inquiries) { inquiry ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = inquiry.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text(text = inquiry.message, fontSize = 14.sp, color = Color.Gray)
                            Text(text = inquiry.timestamp, fontSize = 12.sp, color = Color.DarkGray)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TenantInquiriesScreenPreview() {
    TenantInquiriesScreen(navController = rememberNavController())
}
