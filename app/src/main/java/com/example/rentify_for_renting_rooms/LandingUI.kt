package com.example.rentify_for_renting_rooms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.filled.Help
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LandingUI(){
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(R.drawable.travel),
            contentDescription = "Login Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        // Need Help
        Icon(Icons.Filled.Help, contentDescription = "", tint = Color.White,
            modifier = Modifier.align(Alignment.TopEnd).padding(top = 50.dp, end = 15.dp))
        Column(modifier = Modifier.systemBarsPadding()){
            Text(
                text = "WELCOME" +
                        "\n" +
                        "TO " +
                        "\n" +
                        "RENTIFY",
                modifier = Modifier.padding(start = 15.dp, top = 100.dp, end = 15.dp),
                color = Color.White,
                fontSize = 40.sp,
                lineHeight = 40.sp,
                letterSpacing = 5.sp
            )
        }
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .align(Alignment.BottomCenter),
            colors = CardDefaults.cardColors(
                containerColor = Color.Black.copy(alpha = 0.7f)
            )
        ){
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Column {
                    TextButton(onClick = {},
                        modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White.copy(alpha = 0.7f),
                            contentColor = Color.Black
                        )
                    ) {
                        Text(
                            text = "SIGN UP",
                            modifier = Modifier,
                            fontSize = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    TextButton(onClick = {},
                        modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White.copy(alpha = 0.7f),
                            contentColor = Color.Black
                        )
                    ) {
                        Text(
                            text = "LOGIN",
                            modifier = Modifier,
                            fontSize = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    Row(modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp)){
                        Spacer(modifier = Modifier.weight(1f))
                        Card(modifier = Modifier,
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White.copy(alpha = 0.7f)
                            )
                        ){
                            Image(
                                painter = painterResource(R.drawable.google),
                                contentDescription = "Google Icon",
                                modifier = Modifier.size(50.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Card(modifier = Modifier,
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White.copy(alpha = 0.7f)
                            )){
                            Image(
                                painter = painterResource(R.drawable.twitter),
                                contentDescription = "Google Icon",
                                modifier = Modifier.size(50.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Card(modifier = Modifier,
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White.copy(alpha = 0.7f)
                            )){
                            Image(
                                painter = painterResource(R.drawable.apple),
                                contentDescription = "Google Icon",
                                modifier = Modifier.size(50.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }

        }
    }
}
