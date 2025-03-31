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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.nio.channels.AsynchronousFileChannel.open

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        var query by remember { mutableStateOf("") }
        Column {
            Spacer(modifier = Modifier.height(35.dp))
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
                        .width(300.dp)
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
                            .height(35.dp)
                    ) {
                        Text(
                            text = text[i],
                            color = Color.Black
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "NearBy Rooms",
                modifier = Modifier.padding(start = 15.dp),
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif
                )

            Spacer(modifier = Modifier.height(10.dp))

            Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
                for (i in images.indices) {
                    ElevatedCard(
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



