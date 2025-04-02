package com.example.rentify_for_renting_rooms

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Garage
import androidx.compose.material.icons.filled.LocalCafe
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector


// Ui Screen Details
val text = listOf(
    "2 BHK",
    "3 BHK",
    "4 BHK",
    "5 BHK",
    "6 BHK",
    "7 BHK",
    "8 BHK",
    "9 BHK",
)

val images = listOf(
    R.drawable.hotel1,
    R.drawable.hotel2,
    R.drawable.hotel3,
    R.drawable.hotel4,
)


val hotelName = listOf(
    "Maldives",
    "SwitzerLand",
    "New Zealand",
    "Dubai"
)

val price = listOf(
    "$100",
    "$89",
    "$300",
    "$80"
)

// NearBy Room Details

val MaldivesImages = listOf(
    R.drawable.maldives1,
    R.drawable.maldives2,
    R.drawable.maldives3,
    R.drawable.maldives4,
)

data class Amenities(
    val icon: ImageVector,
    val name: String
)

val amenitiesList = listOf(
    Amenities(Icons.Default.Wifi, "Free WiFi"),
    Amenities(Icons.Default.LocalCafe, "Hot Coffee"),
    Amenities(Icons.Default.Restaurant, "Restaurant"),
    Amenities(Icons.Default.Garage, "Big Garage"),
    Amenities(Icons.Default.Bed, "Multiple Beds")
)
