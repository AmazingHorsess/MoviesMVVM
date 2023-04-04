package com.example.moviesmvvm.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController) {
    Test()

}

@Composable
fun Test() {
    Text(text = "Hello test")
}