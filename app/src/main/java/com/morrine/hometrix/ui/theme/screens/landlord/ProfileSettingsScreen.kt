package com.morrine.hometrix.ui.theme.screens.landlord

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.morrine.hometrix.ui.theme.newBlue
import orange

@Composable
fun ProfileSettingsScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = { SnackbarHost(scaffoldState.snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Your profile form (TextFields etc.)

            Button(
                onClick = {
                    coroutineScope.launch {
                        // Show snackbar
                        scaffoldState.snackbarHostState.showSnackbar("Changes saved successfully!")
                        // Delay so user sees the message briefly
                        delay(1200)
                        // Navigate back to dashboard
                        navController.popBackStack()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(newBlue)
            ) {
                Text("Save Changes", color = Color.White)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ProfileSettingsScreenPreview() {
    ProfileSettingsScreen( rememberNavController())

}

