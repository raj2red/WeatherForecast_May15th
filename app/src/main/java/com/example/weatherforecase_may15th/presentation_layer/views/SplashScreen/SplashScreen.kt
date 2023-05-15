package com.example.weatherforecase_may15th.presentation_layer.views

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import com.example.weatherforecase_may15th.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherforecase_may15th.navigation.NavControl
import com.example.weatherforecase_may15th.navigation.NavigationScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val defaultCity = "San Diego"

    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // Animation for the Splash Screen
    LaunchedEffect(key1 = true, block = {
        scale.animateTo(targetValue = 0.9f,
        animationSpec = tween(durationMillis = 800, easing = {
            OvershootInterpolator(8f).getInterpolation(it)
        })
        )

        delay(2000L)

        navController.navigate(NavigationScreens.MainScreen.name +"/$defaultCity")

    } )

    // Splash Screen UI
    Surface(
        modifier = Modifier
            .padding(all = 15.dp)
            .size(350.dp)
            .scale(scale.value),
        shape = CircleShape,
        color = Color.White,
        border = BorderStroke(width = 2.dp, color = Color.LightGray)

    ) {

        Column(
            modifier = Modifier.padding(2.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "rain_cloudy_sun",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(150.dp))

            Text(text = "Find Weather",
                style = MaterialTheme.typography.h4,
                color = Color.LightGray
            )

        }

    }
}