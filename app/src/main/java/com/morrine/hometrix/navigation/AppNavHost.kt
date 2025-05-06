package com.morrine.hometrix.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.morrine.hometrix.data.UserDatabase
import com.morrine.hometrix.repository.UserRepository
import com.morrine.hometrix.ui.theme.screens.about.AboutScreen
import com.morrine.hometrix.ui.theme.screens.auth.LoginScreen
import com.morrine.hometrix.ui.theme.screens.auth.RegisterScreen
import com.morrine.hometrix.ui.theme.screens.dashboard.BookingScreen
import com.morrine.hometrix.ui.theme.screens.dashboard.DashBoard2Screen
import com.morrine.hometrix.ui.theme.screens.dashboard.DashBoardScreen
import com.morrine.hometrix.ui.theme.screens.dashboard.LandlorduploadCScreen
import com.morrine.hometrix.ui.theme.screens.dashboard.LandlorduploadScreenPreview
import com.morrine.hometrix.ui.theme.screens.home.HomeScreen
import com.morrine.hometrix.ui.theme.screens.products.AddProductScreen
import com.morrine.hometrix.ui.theme.screens.products.ProductListScreen
import com.morrine.hometrix.ui.theme.screens.splash.Splash2Screen
import com.morrine.hometrix.ui.theme.screens.splash.SplashScreen
import com.morrine.hometrix.ui.theme.screens.tenant.ApartmentScreen
import com.morrine.hometrix.ui.theme.screens.tenant.Bedroom1Screen
import com.morrine.hometrix.ui.theme.screens.tenant.Bedroom2Screen
import com.morrine.hometrix.ui.theme.screens.tenant.Bedroom3Screen
import com.morrine.hometrix.ui.theme.screens.tenant.BedsitterScreen
import com.morrine.hometrix.ui.theme.screens.tenant.ShopScreen
import com.morrine.hometrix.ui.theme.screens.tenant.SinglefamilyScreen
import com.morrine.hometrix.ui.theme.screens.tenant.SingleroomScreen
import com.morrine.hometrix.viewmodel.AuthViewModel
import com.morrine.hometrix.viewmodel.ProductViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH,
    productViewModel: ProductViewModel = viewModel()
) {
    val context = LocalContext.current


    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable (ROUT_HOME) {
            HomeScreen(navController)
        }
        composable (ROUT_BOOKING) {
            BookingScreen(navController)
        }
        composable (ROUT_LANDLORDUPLOAD) {
            LandlorduploadCScreen(navController)
        }
        composable (ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_SPLASH2) {
            Splash2Screen(navController)
        }
        composable (ROUT_DASHBOARD) {
            DashBoardScreen(   navController)
        }
        composable (ROUT_DASHBOARD2) {
            DashBoard2Screen(   navController)
        }

        composable (ROUT_APARTMENT) {
            ApartmentScreen(   navController)
        }
        composable (ROUT_BEDROOM1) {
            Bedroom1Screen(   navController)
        }
        composable (ROUT_BEDSITTER) {
            BedsitterScreen(   navController)
        }
        composable (ROUT_BEDROOM2) {
            Bedroom2Screen(   navController)
        }
        composable (ROUT_BEDROOM3) {
            Bedroom3Screen(   navController)
        }
        composable (ROUT_SHOP) {
            ShopScreen(   navController)
        }
        composable (ROUT_SINGLEROOM) {
           SingleroomScreen(   navController)
        }
        composable (ROUT_SINGLEFAMILY) {
            SinglefamilyScreen(   navController)
        }


        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }

        // PRODUCTS
        composable(ROUT_ADD_PRODUCT) {
            AddProductScreen(navController, productViewModel)
        }

        composable(ROUT_PRODUCT_LIST) {
            ProductListScreen(navController, productViewModel)
        }

        composable(
            route = ROUT_EDIT_PRODUCT,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            if (productId != null) {
                EditProductScreen(productId, navController, productViewModel)
            }
        }
//Bedsitter
        composable(ROUT_ADD_BEDSITTER) {
            AddBedsitterScreen(navController, productViewModel)
        }
        composable(
            route = ROUT_EDIT_BEDSITTER,
            arguments = listOf(navArgument("bedsitterId") { type = NavType.IntType })
        ) { backStackEntry ->
            val bedsitterId = backStackEntry.arguments?.getInt("bedsitterId")
            if (bedsitterId != null) {
                EditBedsitterScreen(bedsitterId, navController, bedsitterViewModel)
            }
        }



    }
}

@Composable
fun EditProductScreen(x0: Int, x1: NavHostController, x2: ProductViewModel) {
    TODO("Not yet implemented")
}

