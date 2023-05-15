package com.example.weatherforecase_may15th.presentation_layer.views.SearchScreen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun SearchAppBar(
    title: String = "Title",
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    elevation: Dp = 0.dp,
    navController: NavController,
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {}
                 ) {
    val showDialog = remember {
        mutableStateOf(false)
    }
    val showIt = remember {
        mutableStateOf(false)
    }


    
    TopAppBar(title = {
                      Text(text = title,
                          color = MaterialTheme.colors.onSecondary,
                          style = TextStyle(fontWeight = FontWeight.Bold,
                                           fontSize = 15.sp))
    },
        actions = {
                  if (isMainScreen){
                      IconButton(onClick = {
                          onAddActionClicked.invoke()
                      }) {
                           Icon(imageVector = Icons.Default.Search, 
                               contentDescription = "search icon")
                          
                      }

                  }else Box {}
                  
        },
        navigationIcon = {
                         if(icon != null) {
                              Icon(imageVector = icon, contentDescription = null,
                                  tint = MaterialTheme.colors.onSecondary,
                                  modifier = Modifier.clickable {
                                      onButtonClicked.invoke()
                                  })
                         }
            if (isMainScreen) {
                    showIt.value = false
                    Box{}
            }

        },
        backgroundColor = Color.Transparent,
        elevation = elevation)
    


}