package com.example.rentify_for_renting_rooms

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "UiScreen"){
        composable("UiScreen"){
            UiScreen(navController)
        }
        composable("NearByRoomDetails"){
            NearByRoomDetails(navController)
        }
    }
}