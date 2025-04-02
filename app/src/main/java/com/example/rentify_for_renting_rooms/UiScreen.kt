package com.example.rentify_for_renting_rooms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import java.nio.channels.AsynchronousFileChannel.open

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()
        .background(
            brush = verticalGradient(
                colors = listOf(
                    Color(0xFFcec2c2),
                    Color(0xFFe6c9c9)
                )
            )
        )
    ){
        var query by remember { mutableStateOf("") }
        Column(modifier = Modifier.systemBarsPadding()){

            Row(modifier = Modifier.padding(start = 15.dp)){
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "Location Icon",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .size(20.dp).align(Alignment.CenterVertically)
                )
                Text(
                    text = "Your Location",
                    color = Color.DarkGray,
                    modifier = Modifier,
                    fontSize = 13.sp,
                    fontFamily = FontFamily.Serif,
                    textDecoration = TextDecoration.Underline
                )
            }
            Spacer(modifier = Modifier.height(1.dp))
            Row(modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp)){
                OutlinedTextField(
                    value = query,
                    onValueChange = { query = it },
                    modifier = Modifier
                        .border(1.dp, Color.Black, RoundedCornerShape(30.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    placeholder = {
                        Text(
                            text = "Search For Rooms",
                            color = Color.Black
                        )
                    },
                    shape = RoundedCornerShape(30.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon"
                        )
                    },
                    trailingIcon = {
                        if (query.isNotEmpty()) {
                            IconButton(onClick = { query = "" }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close Icon"
                                )
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Icon",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .size(45.dp).align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    imageVector = Icons.Filled.Mic,
                    contentDescription = "Mic Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(30.dp).align(Alignment.CenterVertically)
                )

            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth().horizontalScroll(rememberScrollState())
                    .padding(start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                for (i in text.indices) {
                    TextButton(
                        onClick = {},
                        modifier = Modifier
                            .border(1.dp, Color.Black, RoundedCornerShape(30.dp))
                            .height(35.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        )
                    ) {
                        Text(
                            text = text[i],
                            color = Color.Black
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
                Text(
                    text = "NearBy Rooms",
                    modifier = Modifier.padding(start = 15.dp),
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Serif
                )

                Spacer(modifier = Modifier.height(10.dp))

                for (i in images.indices) {
                    ElevatedCard(
                        onClick = {navController.navigate("NearByRoomDetails")},
                        modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),
                    ) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Image(
                                painter = painterResource(id = images[i]),
                                contentDescription = "Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                            Card(
                                modifier = Modifier
                                    .height(30.dp)
                                    .align(Alignment.BottomStart),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Black.copy(alpha = 0.7f)
                                )
                            ) {
                                Box(modifier = Modifier.fillMaxSize()) {
                                    Text(
                                        text = hotelName[i],
                                        modifier = Modifier
                                            .padding(start = 10.dp)
                                            .align(Alignment.CenterStart),
                                        color = Color.White,
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Serif
                                    )
                                    Text(
                                        text = price[i],
                                        modifier = Modifier
                                            .padding(end = 10.dp)
                                            .align(Alignment.CenterEnd),
                                        color = Color.White,
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Serif
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }


        }

    }
}



// NearBy Room Details for each Cards

@Composable
fun NearByRoomDetails(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()
        .background(
            brush = verticalGradient(
                colors = listOf(
                    Color(0xFFcec2c2),
                    Color(0xFFe6c9c9)
                )
            )
        )
    ){
        Column(modifier = Modifier.systemBarsPadding().verticalScroll(rememberScrollState())){
            var currentIndex by remember { mutableStateOf(0) }
            Text(
                text = "Hotel Outlook Images",
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            ElevatedCard(modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp))
            {
                Box {
                    Image(
                        painter = painterResource(id = MaldivesImages[currentIndex]),
                        contentDescription = "Hotel Image",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowLeft,
                            contentDescription = "Back Icon",
                            modifier = Modifier
                                .size(40.dp)
                                .clickable {
                                if (currentIndex > 0) currentIndex--
                            }
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowRight,
                            contentDescription = "Close Icon",
                            modifier = Modifier
                                .size(40.dp)
                                .clickable {
                                if (currentIndex < MaldivesImages.size - 1) currentIndex++
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp)){

                Text(
                    text = "Maldives",
                    modifier = Modifier,
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "$100",
                    color = Color.Black,
                    modifier = Modifier,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                )

            }
            Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp)){
                Row {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "Location Icon",
                        tint = Color.DarkGray,
                        modifier = Modifier
                            .size(20.dp).align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "Near Maldives Beach",
                        color = Color.DarkGray,
                        modifier = Modifier,
                        fontSize = 13.sp,
                        fontFamily = FontFamily.Serif,
                        textDecoration = TextDecoration.Underline
                    )
                }
                Spacer(modifier = Modifier.weight(1f))

                Row {
                    Row(modifier = Modifier) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Reviews Rating",
                            tint = Color.Yellow,
                            modifier = Modifier
                                .size(20.dp).align(Alignment.CenterVertically)
                        )
                        Text(
                            text = "4.2(1,229 reviews)",
                            color = Color.DarkGray,
                            modifier = Modifier,
                            fontSize = 13.sp,
                            fontFamily = FontFamily.Serif
                        )
                    }
                }

            }
            Spacer(modifier = Modifier.height(10.dp))

            // Description
            Text(
                text = "Description",
                modifier = Modifier.padding(start = 10.dp),
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Boasting a private beach, this 5-star resort features an outdoor swimming pool and stylish rooms." +
                        " It is located a 25-minute drive from Male International Airport and an airport transfer is provided." +
                        "This luxury resort offers a sauna, a Jacuzzi and outdoor tennis courts. " +
                        "For a fast and effortless check-in and departure experience," +
                        " guests can benefit from the express check-in/check-out kiosk.",
                modifier = Modifier.padding(start = 15.dp, end = 15.dp),
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = FontFamily.Serif,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Thin
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Amenities
            Text(
                text = "Amenities",
                modifier = Modifier.padding(start = 10.dp),
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row(modifier = Modifier
                .horizontalScroll(rememberScrollState())
            ){
                amenitiesList.forEach { amenity ->
                    Card(modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        ))
                    {
                        Card(modifier = Modifier.size(40.dp).align(Alignment.CenterHorizontally),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            )
                        ){
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Icon(
                                    imageVector = amenity.icon,
                                    contentDescription = amenity.name,
                                    tint = Color.DarkGray,
                                    modifier = Modifier
                                        .size(20.dp)

                                )
                            }
                        }
                        Text(
                            text = amenity.name,
                            color = Color.DarkGray,
                            fontSize = 13.sp,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            // Other Hotels
            Text(
                text = "Other Hotels",
                modifier = Modifier.padding(start = 10.dp),
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            for (i in images.indices) {
                ElevatedCard(
                    onClick = {},
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(id = images[i]),
                            contentDescription = "Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Card(
                            modifier = Modifier
                                .height(30.dp)
                                .align(Alignment.BottomStart),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Black.copy(alpha = 0.7f)
                            )
                        ) {
                            Box(modifier = Modifier.fillMaxSize()) {
                                Text(
                                    text = hotelName[i],
                                    modifier = Modifier
                                        .padding(start = 10.dp)
                                        .align(Alignment.CenterStart),
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif
                                )
                                Text(
                                    text = price[i],
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .align(Alignment.CenterEnd),
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
            Spacer(modifier = Modifier.height(70.dp))
        }

        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp, start = 10.dp, end = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ) {
                TextButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Text(
                        text = "Add to Favourite",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                TextButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Green
                    )
                ) {
                    Text(
                        text = "Book Now",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif
                    )
                }
            }
        }

    }
}



