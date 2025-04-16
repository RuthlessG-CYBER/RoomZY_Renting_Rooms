package com.example.rentify_for_renting_rooms

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "LandingUI"){
        composable("LandingUI"){
            LandingUI(navController)
        }
        composable("UiScreen"){
            UiScreen(navController)
        }
        composable("NearByRoomDetails"){
            NearByRoomDetails(navController)
        }
        composable("LogInUI"){
            LogInUI(navController)
        }
        composable("SignUpUI") {
            SignUpUI(navController)
        }
    }
}