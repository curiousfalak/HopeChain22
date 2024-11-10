package com.example

sealed class Screen (val screen:String){
    data object  Home: Screen("Home")
    data object  Campaign: Screen("Campaign")
    data object  Signature: Screen("Signature")
    data object Profile: Screen("Profile")




}