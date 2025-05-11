import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.morrine.hometrix.navigation.ROUT_BROWSEPROPERTIES
import com.morrine.hometrix.navigation.ROUT_CHAT
import com.morrine.hometrix.navigation.ROUT_PRODUCT_LIST
import com.morrine.hometrix.navigation.ROUT_PROPERTYLIST
import com.morrine.hometrix.navigation.ROUT_TENANTBOOKING
import com.morrine.hometrix.navigation.ROUT_TENANTINQUIRY
import com.morrine.hometrix.navigation.ROUT_TENANTSPROFILE
import com.morrine.hometrix.navigation.ROUT_UPLOAD_TASK
import com.morrine.hometrix.navigation.ROUT_VIEWBOOKING
import com.morrine.hometrix.navigation.ROUT_VIEW_TASK

@Composable
fun DashBoard2Screen(navController: NavController) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    var title by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD))
            .verticalScroll(scrollState)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Welcome Tenant",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1976D2)
        )

        StyledActionButton(
            text = "Browse Properties",
            icon = Icons.Default.Home,
            containerColor = Color(0xFFFF9800),
            onClick = { navController.navigate(ROUT_PRODUCT_LIST) }
        )

        StyledActionButton(
            text = "My Bookings",
            icon = Icons.Default.Add,
            containerColor = Color(0xFFFF9800),
            onClick = { navController.navigate(ROUT_VIEW_TASK) }
        )
        StyledActionButton(
            text = "Message landlord",
            icon = Icons.Default.Add,
            containerColor = Color(0xFFFF9800),
            onClick = { navController.navigate(ROUT_CHAT) }
        )

        StyledActionButton(
            text = "Send Inquiry",
            icon = Icons.Default.MailOutline,
            containerColor = Color(0xFFFF9800),
            onClick = { navController.navigate(ROUT_UPLOAD_TASK) }
        )

        StyledActionButton(
            text = "Profile Settings",
            icon = Icons.Default.Settings,
            containerColor = Color(0xFFFF9800),
            onClick = { navController.navigate(ROUT_TENANTSPROFILE) }
        )

        Text("Property Details", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.DarkGray)

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Property Title") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Location") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Expected Rent (KES)") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                try {
                    val parsedPrice = price.toDoubleOrNull()
                    if (title.isBlank() || location.isBlank() || parsedPrice == null || parsedPrice <= 0) {
                        Toast.makeText(context, "Please enter valid property details.", Toast.LENGTH_SHORT).show()
                    } else {
                        // Simulate submission
                        Toast.makeText(context, "Property submitted: $title @ $location for KES $parsedPrice", Toast.LENGTH_LONG).show()

                        // Reset fields
                        title = ""
                        location = ""
                        price = ""
                    }
                } catch (e: Exception) {
                    Toast.makeText(context, "Submission failed: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("Submit Property", color = Color.White)
        }
        //
    }
}

@Composable
fun StyledActionButton(
    text: String,
    icon: ImageVector,
    containerColor: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = containerColor),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(icon, contentDescription = null, tint = Color.White)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text, color = Color.White, fontWeight = FontWeight.Medium)
    }
}


@Preview(showBackground = true)
@Composable
fun Dashboard2ScreenPreview() {
    DashBoard2Screen(rememberNavController())
}
