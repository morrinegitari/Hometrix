package com.morrine.hometrix.ui.theme.screens.home


import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.core.os.BufferFillPolicy
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("Home") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back/nav */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Back")
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
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        // navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.MailOutline, contentDescription = "booking") },
                    label = { Text("Booking") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        navController.navigate(ROUT_BOOKING)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = "Profile") },
                    label = { Text("Info") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        //  navController.navigate(ROUT_HOME)
                    }
                )

            }
        },

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
                        .background(grey)
                        .padding(horizontal = 16.dp, vertical = 24.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .verticalScroll(rememberScrollState())

                ) {
                    //SearchBar
                    var search by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = search,
                        onValueChange = { search = it },
                        modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
                        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
                        placeholder = { Text(text = "Search... ", fontSize = 30.sp) },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = newBlue,
                            focusedBorderColor = newOrange,
                        ),
                        shape = RoundedCornerShape(20.dp)

                    )


                    //End of SearchBar
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (modifier = Modifier.horizontalScroll(rememberScrollState())) {
                        Button(
                            onClick = {navController.navigate(ROUT_APARTMENT)},
                            colors = ButtonDefaults.buttonColors(newBlue),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.height(50.dp),
                        )
                        {
                            Text(text = "Apartment", fontSize = 20.sp)

                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Button(
                            onClick = {navController.navigate(ROUT_BEDSITTER)},
                            colors = ButtonDefaults.buttonColors(newBlue),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.height(50.dp).width(180.dp),
                        )
                        {
                            Text(text = "Bedsitter", fontSize = 20.sp)

                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Button(
                            onClick = {navController.navigate(ROUT_BEDROOM1)},
                            colors = ButtonDefaults.buttonColors(newBlue),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.height(50.dp).width(180.dp),
                        )
                        {
                            Text(text = "1 Bedroom", fontSize = 20.sp)

                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Button(
                            onClick = {navController.navigate(ROUT_BEDROOM2)},
                            colors = ButtonDefaults.buttonColors(newBlue),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.height(50.dp).width(180.dp),
                        )
                        {
                            Text(text = "2 Bedroom", fontSize = 20.sp)

                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Button(
                            onClick = {navController.navigate(ROUT_BEDROOM3) },
                            colors = ButtonDefaults.buttonColors(newBlue),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.height(50.dp).width(180.dp),
                        )
                        {
                            Text(text = "3 Bedroom", fontSize = 20.sp)

                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Button(
                            onClick = {navController.navigate(ROUT_SINGLEFAMILY)},
                            colors = ButtonDefaults.buttonColors(newBlue),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.height(50.dp).width(180.dp),
                        )
                        {
                            Text(text = "Single Family", fontSize = 20.sp)

                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Button(
                            onClick = {navController.navigate(ROUT_SHOP)},
                            colors = ButtonDefaults.buttonColors(newBlue),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.height(50.dp).width(180.dp),
                        )
                        {
                            Text(text = "Shop", fontSize = 20.sp)

                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Button(
                            onClick = {navController.navigate(ROUT_SINGLEROOM)},
                            colors = ButtonDefaults.buttonColors(newBlue),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.height(50.dp).width(180.dp),
                        )
                        {
                            Text(text = "Single rooms", fontSize = 20.sp)

                        }


                    }
                    Text(text = "All Property", fontSize = 30.sp, fontStyle = FontStyle.Italic)
                    Spacer(modifier = Modifier.height(20.dp))
//start
                  Card(modifier = Modifier.background(newBlue)) {
                      Box(
                          modifier = Modifier
                              .fillMaxWidth()
                              .height(250.dp)
                      ) {
                          Image(
                              painter = painterResource(id = R.drawable.house2),
                              contentDescription = "Background Image",
                              contentScale = ContentScale.Crop,
                              modifier = Modifier.matchParentSize()
                          )
                          Column (  modifier = Modifier
                              .align(Alignment.BottomStart)
                              .padding(16.dp)) {

                              // Overlay Text and Icon
                              Row(
                                  modifier = Modifier

                                      .padding(16.dp)
                                      .background(
                                          Color.Black.copy(alpha = 0.5f),
                                          shape = RoundedCornerShape(8.dp)
                                      )
                                      .padding(horizontal = 8.dp, vertical = 4.dp),
                                  verticalAlignment = Alignment.CenterVertically
                              ) {
                                  Icon(
                                      imageVector = Icons.Default.LocationOn,
                                      contentDescription = "Location Icon",
                                      tint = Color.Red
                                  )
                                  Spacer(modifier = Modifier.width(4.dp))
                                  Text(
                                      text = "Runda  Estate,Runda",
                                      fontSize = 20.sp,
                                      color = Color.White,
                                      style = MaterialTheme.typography.bodyMedium
                                  )
                              }
                              Spacer(modifier = Modifier.height(10.dp))
                              // ✅ Add Top-right overlay here
                              Row(
                                  modifier = Modifier

                                      .padding(8.dp)
                                      .background(
                                          Color.Black.copy(alpha = 0.5f),
                                          shape = RoundedCornerShape(8.dp)
                                      )
                                      .padding(horizontal = 8.dp, vertical = 4.dp),
                                  verticalAlignment = Alignment.CenterVertically
                              ) {
                                  Image(
                                      painter = painterResource(id = R.drawable.price),
                                      contentDescription = "Done Icon",
                                      modifier = Modifier.size(24.dp),
                                      colorFilter = ColorFilter.tint(Color.Red)
                                  )

                                  Spacer(modifier = Modifier.width(4.dp))
                                  Text("Price Ksh 910,000", fontSize = 20.sp, color = Color.White)
                              }


                          }

                      }
                      //end box

                     Column (){
                         Row (modifier = Modifier.background(newBlue).fillMaxWidth()){
                             Image(
                                 painter = painterResource(id = R.drawable.bathroom),
                                 contentDescription = "Done Icon",
                                 modifier = Modifier.size(24.dp),
                                 colorFilter = ColorFilter.tint(Color.Red)
                             )

                             Spacer(modifier = Modifier.width(4.dp))
                             Text(
                                 text = "3 Bathroom ",
                                 fontSize = 20.sp,
                                 color = Color.White,
                                 style = MaterialTheme.typography.bodyMedium
                             )
                             Spacer(modifier = Modifier.width(30.dp))
                             Image(
                                 painter = painterResource(id = R.drawable.bed),
                                 contentDescription = "Done Icon",
                                 modifier = Modifier.size(24.dp),
                                 colorFilter = ColorFilter.tint(Color.Red)
                             )

                             Spacer(modifier = Modifier.width(10.dp))
                             Text(
                                 text = "3 Bedroom",
                                 fontSize = 20.sp,
                                 color = Color.White,
                                 style = MaterialTheme.typography.bodyMedium
                             )


                         }
                         Row (modifier = Modifier.background(newBlue).fillMaxWidth()){

                                 IconButton (onClick = {
                                     val callIntent=Intent(Intent.ACTION_DIAL)
                                     callIntent.data="tel:0720245837".toUri()
                                     mContext.startActivity(callIntent)}){
                                     Icon(imageVector = Icons.Default.Call, contentDescription ="", tint = Color.Red )
                                 }

                             Spacer(modifier = Modifier.width(4.dp))
                             Text(
                                 text = "Contact us",
                                 fontSize = 20.sp,
                                 color = Color.White,
                                 style = MaterialTheme.typography.bodyMedium
                             )
                             Spacer(modifier = Modifier.width(30.dp))
                             IconButton (onClick = {
                                 val shareIntent = Intent(Intent.ACTION_SEND)
                                 shareIntent.type = "text/plain"
                                 shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("akinyiglory2@gmail.com"))
                                 shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                 shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                                 mContext.startActivity(shareIntent)

                             }){
                                 Icon(imageVector = Icons.Default.MailOutline, contentDescription ="", tint = Color.Red )
                             }
                             Spacer(modifier = Modifier.width(4.dp))
                             Text(
                                 text = "message us",
                                 fontSize = 20.sp,
                                 color = Color.White,
                                 style = MaterialTheme.typography.bodyMedium
                             )




                         }

                     }




                  }//end
                    //start
                    Spacer(modifier = Modifier.height(20.dp))
                    Card(modifier = Modifier.background(newBlue)) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.house1),
                                contentDescription = "Background Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.matchParentSize()
                            )
                            Column (  modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(16.dp)) {

                                // Overlay Text and Icon
                                Row(
                                    modifier = Modifier

                                        .padding(16.dp)
                                        .background(
                                            Color.Black.copy(alpha = 0.5f),
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(horizontal = 8.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.LocationOn,
                                        contentDescription = "Location Icon",
                                        tint = Color.Red
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "Lovington",
                                        fontSize = 20.sp,
                                        color = Color.White,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                // ✅ Add Top-right overlay here
                                Row(
                                    modifier = Modifier

                                        .padding(8.dp)
                                        .background(
                                            Color.Black.copy(alpha = 0.5f),
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(horizontal = 8.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.price),
                                        contentDescription = "Done Icon",
                                        modifier = Modifier.size(24.dp),
                                        colorFilter = ColorFilter.tint(Color.Red)
                                    )

                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text("Price Ksh 100,000", fontSize = 20.sp, color = Color.White)
                                }


                            }

                        }
                        //end box

                        Column (){
                            Row (modifier = Modifier.background(newBlue).fillMaxWidth()){
                                Image(
                                    painter = painterResource(id = R.drawable.bathroom),
                                    contentDescription = "Done Icon",
                                    modifier = Modifier.size(24.dp),
                                    colorFilter = ColorFilter.tint(Color.Red)
                                )

                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "1 Bathroom ",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Spacer(modifier = Modifier.width(30.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.bed),
                                    contentDescription = "Done Icon",
                                    modifier = Modifier.size(24.dp),
                                    colorFilter = ColorFilter.tint(Color.Red)
                                )

                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "2 Bedroom",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )


                            }
                            Row (modifier = Modifier.background(newBlue).fillMaxWidth()){

                                IconButton (onClick = {
                                    val callIntent=Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0720245837".toUri()
                                    mContext.startActivity(callIntent)}){
                                    Icon(imageVector = Icons.Default.Call, contentDescription ="", tint = Color.Red )
                                }

                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Contact us",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Spacer(modifier = Modifier.width(30.dp))
                                IconButton (onClick = {
                                    val shareIntent = Intent(Intent.ACTION_SEND)
                                    shareIntent.type = "text/plain"
                                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("akinyiglory2@gmail.com"))
                                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                                    mContext.startActivity(shareIntent)

                                }){
                                    Icon(imageVector = Icons.Default.MailOutline, contentDescription ="", tint = Color.Red )
                                }
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "message us",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )




                            }

                        }




                    }//end


                    //start
                    Spacer(modifier = Modifier.height(20.dp))
                    Card(modifier = Modifier.background(newBlue)) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.house3),
                                contentDescription = "Background Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.matchParentSize()
                            )
                            Column (  modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(16.dp)) {

                                // Overlay Text and Icon
                                Row(
                                    modifier = Modifier

                                        .padding(16.dp)
                                        .background(
                                            Color.Black.copy(alpha = 0.5f),
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(horizontal = 8.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.LocationOn,
                                        contentDescription = "Location Icon",
                                        tint = Color.Red
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "Garden Estate ,Roysambu ,Nairobi",
                                        fontSize = 20.sp,
                                        color = Color.White,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                // ✅ Add Top-right overlay here
                                Row(
                                    modifier = Modifier

                                        .padding(8.dp)
                                        .background(
                                            Color.Black.copy(alpha = 0.5f),
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(horizontal = 8.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.price),
                                        contentDescription = "Done Icon",
                                        modifier = Modifier.size(24.dp),
                                        colorFilter = ColorFilter.tint(Color.Red)
                                    )

                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text("Price Ksh 160,000", fontSize = 20.sp, color = Color.White)
                                }


                            }

                        }
                        //end box

                        Column (){
                            Row (modifier = Modifier.background(newBlue).fillMaxWidth()){
                                Image(
                                    painter = painterResource(id = R.drawable.bathroom),
                                    contentDescription = "Done Icon",
                                    modifier = Modifier.size(24.dp),
                                    colorFilter = ColorFilter.tint(Color.Red)
                                )

                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "2 Bathroom ",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Spacer(modifier = Modifier.width(30.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.bed),
                                    contentDescription = "Done Icon",
                                    modifier = Modifier.size(24.dp),
                                    colorFilter = ColorFilter.tint(Color.Red)
                                )

                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "2 Bedroom",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )


                            }
                            Row (modifier = Modifier.background(newBlue).fillMaxWidth()){

                                IconButton (onClick = {
                                    val callIntent=Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0720245837".toUri()
                                    mContext.startActivity(callIntent)}){
                                    Icon(imageVector = Icons.Default.Call, contentDescription ="", tint = Color.Red )
                                }

                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Contact us",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Spacer(modifier = Modifier.width(30.dp))
                                IconButton (onClick = {
                                    val shareIntent = Intent(Intent.ACTION_SEND)
                                    shareIntent.type = "text/plain"
                                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("akinyiglory2@gmail.com"))
                                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                                    mContext.startActivity(shareIntent)

                                }){
                                    Icon(imageVector = Icons.Default.MailOutline, contentDescription ="", tint = Color.Red )
                                }
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "message us",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )




                            }

                        }




                    }//end

                    //start
                    Spacer(modifier = Modifier.height(20.dp))
                    Card(modifier = Modifier.background(newBlue)) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.house4),
                                contentDescription = "Background Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.matchParentSize()
                            )
                            Column (  modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(16.dp)) {

                                // Overlay Text and Icon
                                Row(
                                    modifier = Modifier

                                        .padding(16.dp)
                                        .background(
                                            Color.Black.copy(alpha = 0.5f),
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(horizontal = 8.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.LocationOn,
                                        contentDescription = "Location Icon",
                                        tint = Color.Red
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "Thome of Northern Bypass,Nairobi",
                                        fontSize = 20.sp,
                                        color = Color.White,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                // ✅ Add Top-right overlay here
                                Row(
                                    modifier = Modifier

                                        .padding(8.dp)
                                        .background(
                                            Color.Black.copy(alpha = 0.5f),
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(horizontal = 8.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.price),
                                        contentDescription = "Done Icon",
                                        modifier = Modifier.size(24.dp),
                                        colorFilter = ColorFilter.tint(Color.Red)
                                    )

                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text("Price Ksh 910,000", fontSize = 20.sp, color = Color.White)
                                }


                            }

                        }
                        //end box

                        Column (){
                            Row (modifier = Modifier.background(newBlue).fillMaxWidth()){
                                Image(
                                    painter = painterResource(id = R.drawable.bathroom),
                                    contentDescription = "Done Icon",
                                    modifier = Modifier.size(24.dp),
                                    colorFilter = ColorFilter.tint(Color.Red)
                                )

                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "4 Bathroom ",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Spacer(modifier = Modifier.width(30.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.bed),
                                    contentDescription = "Done Icon",
                                    modifier = Modifier.size(24.dp),
                                    colorFilter = ColorFilter.tint(Color.Red)
                                )

                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "4 Bedroom",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )


                            }
                            Row (modifier = Modifier.background(newBlue).fillMaxWidth()){

                                IconButton (onClick = {
                                    val callIntent=Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0720245837".toUri()
                                    mContext.startActivity(callIntent)}){
                                    Icon(imageVector = Icons.Default.Call, contentDescription ="", tint = Color.Red )
                                }

                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Contact us",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Spacer(modifier = Modifier.width(30.dp))
                                IconButton (onClick = {
                                    val shareIntent = Intent(Intent.ACTION_SEND)
                                    shareIntent.type = "text/plain"
                                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("akinyiglory2@gmail.com"))
                                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                                    mContext.startActivity(shareIntent)

                                }){
                                    Icon(imageVector = Icons.Default.MailOutline, contentDescription ="", tint = Color.Red )
                                }
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "message us",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )




                            }

                        }




                    }//end
                    //end of card
                    //start
                    Spacer(modifier = Modifier.height(20.dp))
                    Card(modifier = Modifier.background(newBlue)) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.house5),
                                contentDescription = "Background Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.matchParentSize()
                            )
                            Column (  modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(16.dp)) {

                                // Overlay Text and Icon
                                Row(
                                    modifier = Modifier

                                        .padding(16.dp)
                                        .background(
                                            Color.Black.copy(alpha = 0.5f),
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(horizontal = 8.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.LocationOn,
                                        contentDescription = "Location Icon",
                                        tint = Color.Red
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "Forest View Apartment Parklands,Nairobi",
                                        fontSize = 20.sp,
                                        color = Color.White,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                // ✅ Add Top-right overlay here
                                Row(
                                    modifier = Modifier

                                        .padding(8.dp)
                                        .background(
                                            Color.Black.copy(alpha = 0.5f),
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(horizontal = 8.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.price),
                                        contentDescription = "Done Icon",
                                        modifier = Modifier.size(24.dp),
                                        colorFilter = ColorFilter.tint(Color.Red)
                                    )

                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text("Price Ksh 200,000", fontSize = 20.sp, color = Color.White)
                                }


                            }

                        }
                        //end box

                        Column (){
                            Row (modifier = Modifier.background(newBlue).fillMaxWidth()){
                                Image(
                                    painter = painterResource(id = R.drawable.bathroom),
                                    contentDescription = "Done Icon",
                                    modifier = Modifier.size(24.dp),
                                    colorFilter = ColorFilter.tint(Color.Red)
                                )

                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "4 Bathroom ",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Spacer(modifier = Modifier.width(30.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.bed),
                                    contentDescription = "Done Icon",
                                    modifier = Modifier.size(24.dp),
                                    colorFilter = ColorFilter.tint(Color.Red)
                                )

                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "3 Bedroom",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )


                            }
                            Row (modifier = Modifier.background(newBlue).fillMaxWidth()){

                                IconButton (onClick = {
                                    val callIntent=Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0720245837".toUri()
                                    mContext.startActivity(callIntent)}){
                                    Icon(imageVector = Icons.Default.Call, contentDescription ="", tint = Color.Red )
                                }

                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Contact us",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Spacer(modifier = Modifier.width(30.dp))
                                IconButton (onClick = {
                                    val shareIntent = Intent(Intent.ACTION_SEND)
                                    shareIntent.type = "text/plain"
                                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("akinyiglory2@gmail.com"))
                                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                                    mContext.startActivity(shareIntent)

                                }){
                                    Icon(imageVector = Icons.Default.MailOutline, contentDescription ="", tint = Color.Red )
                                }
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "message us",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )




                            }

                        }
                    }
                    //end card

                    //end
                   Spacer (modifier = Modifier.height(20.dp))
                    //start
                    Spacer(modifier = Modifier.height(20.dp))
                    Card(modifier = Modifier.background(newBlue)) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.house6),
                                contentDescription = "Background Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.matchParentSize()
                            )
                            Column (  modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(16.dp)) {

                                // Overlay Text and Icon
                                Row(
                                    modifier = Modifier

                                        .padding(16.dp)
                                        .background(
                                            Color.Black.copy(alpha = 0.5f),
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(horizontal = 8.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.LocationOn,
                                        contentDescription = "Location Icon",
                                        tint = Color.Red
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "Karen,Nairobi",
                                        fontSize = 20.sp,
                                        color = Color.White,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                // ✅ Add Top-right overlay here
                                Row(
                                    modifier = Modifier

                                        .padding(8.dp)
                                        .background(
                                            Color.Black.copy(alpha = 0.5f),
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(horizontal = 8.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.price),
                                        contentDescription = "Done Icon",
                                        modifier = Modifier.size(24.dp),
                                        colorFilter = ColorFilter.tint(Color.Red)
                                    )

                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text("Price Ksh 100,000", fontSize = 20.sp, color = Color.White)
                                }


                            }

                        }
                        //end box

                        Column (){
                            Row (modifier = Modifier.background(newBlue).fillMaxWidth()){
                                Image(
                                    painter = painterResource(id = R.drawable.bathroom),
                                    contentDescription = "Done Icon",
                                    modifier = Modifier.size(24.dp),
                                    colorFilter = ColorFilter.tint(Color.Red)
                                )

                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "2 Bathroom ",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Spacer(modifier = Modifier.width(30.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.bed),
                                    contentDescription = "Done Icon",
                                    modifier = Modifier.size(24.dp),
                                    colorFilter = ColorFilter.tint(Color.Red)
                                )

                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "1 Bedroom",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )


                            }
                            Row (modifier = Modifier.background(newBlue).fillMaxWidth()){

                                IconButton (onClick = {
                                    val callIntent=Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0720245837".toUri()
                                    mContext.startActivity(callIntent)}){
                                    Icon(imageVector = Icons.Default.Call, contentDescription ="", tint = Color.Red )
                                }

                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Contact us",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Spacer(modifier = Modifier.width(30.dp))
                                IconButton (onClick = {
                                    val shareIntent = Intent(Intent.ACTION_SEND)
                                    shareIntent.type = "text/plain"
                                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("akinyiglory2@gmail.com"))
                                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                                    mContext.startActivity(shareIntent)

                                }){
                                    Icon(imageVector = Icons.Default.MailOutline, contentDescription ="", tint = Color.Red )
                                }
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "message us",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )

                            }

                        }
                    }
                    //end card
                }



            }








        }
    )

    //End of scaffold
}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}


