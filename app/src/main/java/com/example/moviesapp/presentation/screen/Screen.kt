package com.example.moviesapp.presentation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route:String,val title:String, val icon : ImageVector){
    object Home : Screen(route = "home " , title = "Home ", icon = Icons.Default.Home)

    object  Search: Screen(route = "Search " , title = "Search ", icon = Icons.Default.Search)

    object Profile: Screen(route = "profile " , title = "Profile ", icon = Icons.Default.Person)

    object Exit: Screen(route = "profile " , title = "Exit ", icon = Icons.Default.ExitToApp)

}
