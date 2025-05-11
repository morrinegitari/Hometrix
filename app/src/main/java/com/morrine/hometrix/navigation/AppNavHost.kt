package com.morrine.hometrix.navigation

import AboutScreen
import DashBoard2Screen
import DashBoardScreen


import android.os.Build
import androidx.annotation.RequiresApi
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
import com.glory.nunuachapchap.ui.theme.screens.products.ProductListScreen
import com.morrine.hometrix.data.ChatDatabase
import com.morrine.hometrix.data.TaskDatabase
//import com.glory.nunuachapchap.ui.theme.screens.task.TenantBookingScreen
import com.morrine.hometrix.data.UserDatabase
import com.morrine.hometrix.repository.ChatRepository
import com.morrine.hometrix.repository.TaskRepository
import com.morrine.hometrix.repository.UserRepository
import com.morrine.hometrix.ui.screens.PropertyListScreen
import com.morrine.hometrix.ui.theme.screens.HomeScreen

import com.morrine.hometrix.ui.theme.screens.auth.LoginScreen
import com.morrine.hometrix.ui.theme.screens.auth.RegisterScreen
import com.morrine.hometrix.ui.theme.screens.booking.ViewBookingScreen
import com.morrine.hometrix.ui.theme.screens.dashboard.ChatScreen
//import com.morrine.hometrix.ui.theme.screens.dashboard.AddPropertyScreen
//import com.morrine.hometrix.ui.theme.screens.dashboard.EditPropertyScreen



import com.morrine.hometrix.ui.theme.screens.landlord.NotificationScreen
import com.morrine.hometrix.ui.theme.screens.landlord.ProfileSettingsScreen

import com.morrine.hometrix.ui.theme.screens.landlord.RentalHistoryScreen
import com.morrine.hometrix.ui.theme.screens.landlord.ReportsAnalyticsScreen
import com.morrine.hometrix.ui.theme.screens.landlord.TenantInquiriesScreen

import com.morrine.hometrix.ui.theme.screens.splash.Splash2Screen
import com.morrine.hometrix.ui.theme.screens.splash.SplashScreen
import com.morrine.hometrix.ui.theme.screens.tenant.TenantInquiryScreen
import com.morrine.hometrix.ui.theme.screens.tenant.TenantProfileScreen
//import com.morrine.hometrix.ui.theme.screens.tenant.ViewBookingScreen
import com.morrine.hometrix.viewmodel.AuthViewModel
import com.morrine.hometrix.viewmodel.MypropertyViewModel
import com.morrine.hometrix.viewmodel.PropertyViewModel

import com.morrine.hometrix.ui.theme.screens.myproperty.EditMypropertyScreen
import com.morrine.hometrix.ui.theme.screens.myproperty.MypropertyListScreen
import com.morrine.hometrix.ui.theme.screens.products.AddProductScreen
import com.morrine.hometrix.ui.theme.screens.products.EditProductScreen
import com.morrine.hometrix.ui.theme.screens.task.UploadTaskScreen
import com.morrine.hometrix.ui.theme.screens.task.ViewTaskScreen
import com.morrine.hometrix.viewmodel.ChatViewModel
import com.morrine.hometrix.viewmodel.ChatViewModelFactory
import com.morrine.hometrix.viewmodel.ProductViewModel
import com.morrine.hometrix.viewmodel.TaskViewModel
import com.morrine.iceberry.ui.theme.screens.myproperty.AddMypropertyScreen


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH  ,
    propertyViewModel: PropertyViewModel = viewModel(),
    productViewModel: ProductViewModel = viewModel(),
    mypropertyViewModel: MypropertyViewModel =viewModel()



    ) {
    val context = LocalContext.current
    // Initialize Room Database and Repository for Chat
    val chatDatabase = ChatDatabase.getDatabase(context)
    val chatRepository = ChatRepository(chatDatabase.messageDao()) // ✅ Correct DAO reference
    val chatViewModel: ChatViewModel = viewModel(factory = ChatViewModelFactory(chatRepository))



    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_CHAT) {
            ChatScreen(chatViewModel) // ✅ Correct ViewModel reference
        }


        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_SPLASH2) {
            Splash2Screen(navController)
        }
        composable(ROUT_DASHBOARD) {
            DashBoardScreen(navController)
        }
        composable(ROUT_DASHBOARD2) {
            DashBoard2Screen(navController)
        }
        //landlord

        composable(ROUT_PROFILE_SETTINGS) {
            ProfileSettingsScreen(navController)
        }
        composable(ROUT_RENTAL_HISTORY) {
            RentalHistoryScreen(navController)
        }
        composable(ROUT_REPORTSANALYTICS) {
            ReportsAnalyticsScreen(navController)
        }

        composable(ROUT_TENANT_INQUIRIES) {
            TenantInquiriesScreen(navController)
        }
        composable(ROUT_VIEW_BOOKING) {
            ViewBookingScreen(navController)

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

        // Tenant Screens
        composable("dashboard_tenant") {
            DashBoard2Screen(navController = navController)
        }

        //composable(ROUT_TENANTBOOKING) {
            //TenantBookingScreen(navController)
        //}
        composable(ROUT_TENANTINQUIRY) {
            TenantInquiryScreen(navController = navController)
        }
        composable(ROUT_TENANTSPROFILE) {
            TenantProfileScreen(navController = navController)
        }

        // Landlord Screens (Optional, if navigating from tenant to landlord)
        composable(ROUT_DASHBOARD) {
            DashBoardScreen(navController = navController)
        }

        composable(ROUT_NOTIFICATIONS) {
            ReportsAnalyticsScreen(navController = navController)
        }
        composable(ROUT_NOTIFICATIONS) {
            NotificationScreen(navController = navController)
        }
        composable(ROUT_ADD_PROPERTY) {

        }

        composable(ROUT_PROPERTYLIST) {
            PropertyListScreen(navController,viewModel ())

        }
        //myproperty

        composable(ROUT_ADDMYPROPERTY) {
            AddMypropertyScreen(navController, mypropertyViewModel)
        }

        composable(ROUT_MYPROPERTYLIST) {
            MypropertyListScreen(navController, mypropertyViewModel)
        }

        composable(
            route = ROUT_EDITMYPROPERTY,
            arguments = listOf(navArgument("mypropertyId") { type = NavType.IntType })
        ) { backStackEntry ->
            val mypropertyId = backStackEntry.arguments?.getInt("mypropertyId")
            if (mypropertyId != null) {
                EditMypropertyScreen(mypropertyId, navController, mypropertyViewModel)
            }
        }


        //TASK

        // Initialize Content Database and ViewModel
        val taskDatabase = TaskDatabase.getDatabase(context)
        val taskRepository = TaskRepository(taskDatabase.taskDao())
        val taskViewModel = TaskViewModel(taskRepository)

        composable(ROUT_UPLOAD_TASK) {
            UploadTaskScreen(navController, taskViewModel)
        }
        composable(ROUT_VIEW_TASK) {
            ViewTaskScreen(navController, taskViewModel) { id ->
                navController.navigate("upload_task?id=$id")
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




    }
}










