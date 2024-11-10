package com.example.hopechain22


import Campaign
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hopechain22.ui.theme.HopeChain22Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HopeChain22Theme {
                BotSheetWithTopAndBottomBar()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BotSheetWithTopAndBottomBar() {
    val navController = rememberNavController()
    var selectedIcon by remember { mutableStateOf(Icons.Default.Home) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("HopeChain") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1C74BC), // Set your desired container color here
                    titleContentColor = Color.White
                ),
                actions = {
                    IconButton(
                        onClick = {
                            selectedIcon = Icons.Default.Person
                            navController.navigate("profile") {
                                popUpTo("home") { inclusive = true }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = if (selectedIcon == Icons.Default.Person) Color.White else Color.Gray
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(containerColor = Color(0xFF1C74BC)) {
                val bottomBarItems = listOf(
                    Triple(Icons.Default.Home, "Home", "home"),
                    Triple(Icons.Default.DateRange, "Campaigns", "campaigns"),
                    Triple(Icons.Default.AddCircle, "Signature", "signature"),

                    Triple(Icons.Default.Person, "Profile", "profile")
                )

                bottomBarItems.forEach { (icon, description, route) ->
                    IconButton(
                        onClick = {
                            selectedIcon = icon
                            navController.navigate(route) {
                                popUpTo("home") { inclusive = true }
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = description,
                            tint = if (selectedIcon == icon) Color.White else Color.Gray
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { Home() }
            composable("campaigns") { Campaign() }
            composable("signature") { Signature()}
            composable("profile") { Profile() }
        }
    }
}


