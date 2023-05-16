package com.example.weatherforecase_may15th.presentation_layer

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherforecase_may15th.navigation.NavControl
import com.example.weatherforecase_may15th.presentation_layer.Widget.RequestPermission
import com.example.weatherforecase_may15th.ui.theme.WeatherFOrecase_May15thTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherApp(this)
        }
    }

}



@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun WeatherApp(activity:Activity) {

    // Base Screen
    WeatherFOrecase_May15thTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                // Initiating JetPack-Navigation
                NavControl(activity)

                // Checking Location Permission
                RequestPermission(permission = Manifest.permission.ACCESS_FINE_LOCATION)
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    WeatherApp()
}