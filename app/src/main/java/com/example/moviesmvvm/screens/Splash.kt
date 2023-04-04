package com.example.moviesmvvm.screens

import android.window.SplashScreen
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.moviesmvvm.navigation.NavRoute
import com.example.moviesmvvm.ui.theme.MoviesMVVMTheme
import com.example.moviesmvvm.utils.Screens.MAIN
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){
    var startAnimations by remember { mutableStateOf(false)}
    val alphaAnimation = animateFloatAsState(targetValue = if (startAnimations) 1f else 0f,
    animationSpec = tween(delayMillis = 3000))
    LaunchedEffect(key1 = true){
        startAnimations = true
        delay(4000)
        navController.navigate(MAIN)
    }

    Splash(alpha = alphaAnimation.value)
}
@Composable
fun Splash(alpha:Float){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()

    ){
        Icon(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alpha),
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "",
            tint = Color.Black
        )

    }

}

@Composable
@Preview(showBackground = true)
fun prevSplash(){
    MoviesMVVMTheme {
        SplashScreen(navController = rememberNavController())
        
    }
}