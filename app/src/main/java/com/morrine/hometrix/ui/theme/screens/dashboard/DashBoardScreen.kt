import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.morrine.hometrix.R
import com.morrine.hometrix.navigation.ROUT_ADDMYPROPERTY
import com.morrine.hometrix.navigation.ROUT_ADD_PRODUCT
import com.morrine.hometrix.navigation.ROUT_ADD_PROPERTY

import com.morrine.hometrix.navigation.ROUT_MANAGE_LISTINGS
import com.morrine.hometrix.navigation.ROUT_NOTIFICATIONS
import com.morrine.hometrix.navigation.ROUT_PROFILE_SETTINGS
import com.morrine.hometrix.navigation.ROUT_RENTAL_HISTORY
import com.morrine.hometrix.navigation.ROUT_REPORTSANALYTICS
import com.morrine.hometrix.navigation.ROUT_TENANT_INQUIRIES

import com.morrine.hometrix.navigation.ROUT_UPLOADPROPERTY
import com.morrine.hometrix.navigation.ROUT_VIEW_BOOKING
import com.morrine.hometrix.navigation.ROUT_VIEW_TASK

val blue = Color(0xFF1555F6)
val lightBlue = Color(0xFFBBDEFB)
val orange = Color(0xFFFF9800)
val darkGray = Color(0xFF424242)

@Composable
fun DashBoardScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val infiniteTransition = rememberInfiniteTransition()
    val animatedAlpha by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(blue, lightBlue),
                    startY = 0f,
                    endY = Float.POSITIVE_INFINITY
                )
            )
            .verticalScroll(scrollState)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = orange),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Landlord Panel",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.alpha(animatedAlpha)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.dashboard_banner),
            contentDescription = "Dashboard Banner",
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_avatar),
                    contentDescription = "Profile Avatar",
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Welcome Back!",
                    fontSize = 22.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.alpha(animatedAlpha)
                )
                Text(
                    text = "Manage your properties and stay updated.",
                    fontSize = 16.sp,
                    color = darkGray
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Button(
                            onClick = { ROUT_NOTIFICATIONS },
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp)
                                .shadow(6.dp, RoundedCornerShape(12.dp)),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800))
                        ) {
                            Icon(Icons.Default.Notifications, contentDescription = "Add", tint = Color.White)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Notification", color = Color.White, fontSize = 10.sp)
                        }

                        Button(
                            onClick = { ROUT_PROFILE_SETTINGS },
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp)
                                .shadow(6.dp, RoundedCornerShape(12.dp)),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800))
                        ) {
                            Icon(Icons.Default.Settings, contentDescription = "List", tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Settings", color = Color.White, fontSize = 10.sp)
                        }
                    }
                }


                StyledActionButton(
                    text = "Upload Property",
                    icon = Icons.Default.Add,
                    containerColor = orange,
                    contentColor = Color.White,
                    onClick = {  navController.navigate(ROUT_ADD_PRODUCT) }
                )


                StyledActionButton(
                    text = "View Bookings",
                    icon = Icons.Default.Email,
                    containerColor = orange,
                    contentColor = Color.White,
                    onClick = { navController.navigate(ROUT_VIEW_TASK) }
                )



                StyledActionButton(
                    text = "Tenant Inquiries",
                    icon = Icons.Default.MailOutline,
                    containerColor = orange,
                    contentColor = Color.White,
                    onClick = { navController.navigate(ROUT_TENANT_INQUIRIES) }
                )




                StyledActionButton(
                    text = "Rental History",
                    icon = Icons.Default.Refresh,
                    containerColor = orange,
                    contentColor = Color.White,
                    onClick = { navController.navigate(ROUT_RENTAL_HISTORY) }
                )



                StyledActionButton(
                    text = "Reports & Analytics",
                    icon = Icons.Default.Clear,
                    containerColor = orange,
                    contentColor = Color.White,
                    onClick = {navController.navigate(ROUT_REPORTSANALYTICS) }
                )

            }
        }
    }
}

@Composable
fun StyledActionButton(
    text: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    containerColor: Color,
    contentColor: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(icon, contentDescription = null)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text, fontWeight = FontWeight.Medium)
    }
}

@Preview(showBackground = true)
@Composable
fun DashBoardScreenPreview() {
    DashBoardScreen(navController = rememberNavController())
}
