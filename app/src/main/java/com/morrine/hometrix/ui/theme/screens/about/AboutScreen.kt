package com.morrine.hometrix.ui.theme.screens.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.morrine.hometrix.navigation.ROUT_APARTMENT
import com.morrine.hometrix.navigation.ROUT_BEDROOM1
import com.morrine.hometrix.navigation.ROUT_BEDROOM2
import com.morrine.hometrix.navigation.ROUT_BEDROOM3
import com.morrine.hometrix.navigation.ROUT_BEDSITTER
import com.morrine.hometrix.navigation.ROUT_SHOP
import com.morrine.hometrix.navigation.ROUT_SINGLEFAMILY
import com.morrine.hometrix.navigation.ROUT_SINGLEROOM
import com.morrine.hometrix.ui.theme.newBlue

@Composable
fun AboutScreen(navController: NavController) {
}
@Preview(showBackground = true)
@Composable
fun AboutScreenPreview(){
    AboutScreen(rememberNavController())
}