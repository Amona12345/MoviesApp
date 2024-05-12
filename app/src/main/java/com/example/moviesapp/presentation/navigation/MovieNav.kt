package com.example.moviesapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviesapp.presentation.composable.Search
import com.example.moviesapp.presentation.screen.Screen
import com.example.screenstask.presentaion.screens.MovieHorzintalPager

@Composable
fun Nav(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            MovieHorzintalPager(navController = navController)
        }
        composable(Screen.Search.route) {
           Search(navController = navController)
        }
        composable(Screen.Profile.route) {
          //  Profile()
        }
        composable(Screen.Exit.route) {
          //  Exit()
        }
    }

}