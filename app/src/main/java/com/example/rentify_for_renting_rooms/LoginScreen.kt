package com.example.rentify_for_renting_rooms

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LogInUI(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()
        .background(
            brush = verticalGradient(
                colors = listOf(
                    Color(0xFFcec2c2),
                    Color(0xFFe6c9c9)
                )
            )
        ),
        contentAlignment = Alignment.Center
    ){
        Column(modifier = Modifier){
            Card(modifier = Modifier.align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(70.dp)
                ){
                Image(painter = painterResource(R.drawable.login_logo),
                    contentDescription = "Login Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(180.dp)
                    )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Welcome Back" +"\n"+ "To Roomzy",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))

            var email by remember { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth().padding(start = 25.dp, end = 25.dp),
                leadingIcon = {
                    Icon(Icons.Filled.Email, contentDescription = "Visibility")
                }
            )

            var clicked by remember { mutableStateOf(false) }
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
                trailingIcon = {
                    IconButton(onClick = { clicked = !clicked }) {
                        if (clicked) {
                            Icon(Icons.Filled.Visibility, contentDescription = "Hide password")
                        } else {
                            Icon(Icons.Filled.VisibilityOff, contentDescription = "Show password")
                        }
                    }
                },
                visualTransformation = if (clicked) VisualTransformation.None else PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.padding(start = 25.dp, end = 25.dp)){
                Text(
                    text = "Don't have an account?",
                    modifier = Modifier.align(Alignment.CenterVertically)
                        .clickable(onClick = { navController.navigate("SignUpUI") }),
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.weight(1f))
                ElevatedCard(modifier = Modifier
                    .height(45.dp)
                    .width(150.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(10.dp)),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 15.dp,
                        focusedElevation = 20.dp,
                        hoveredElevation = 25.dp
                    )
                ){
                    Box(modifier = Modifier.fillMaxSize()
                        .background(
                            brush = verticalGradient(
                                colors = listOf(
                                    Color(0xFFcec2c2),
                                    Color(0xFFe6c9c9)
                                )
                            )
                        ),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Login"
                        )
                    }
                }
            }
        }
    }
}
