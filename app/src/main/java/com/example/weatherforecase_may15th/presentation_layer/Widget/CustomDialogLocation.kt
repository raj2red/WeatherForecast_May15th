package com.example.weatherforecase_may15th.presentation_layer.Widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun CustomDialogLocation(
    title: String? = "Message",
    desc: String? = "Your Message",
    enableLocation: MutableState<Boolean>,
    onClick: () -> Unit
) {
    Dialog(
        onDismissRequest = { enableLocation.value = false}
    ) {
        Box(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp)
                // .width(300.dp)
                // .height(164.dp)
                .background(
                    color = MaterialTheme.colors.onPrimary,
                    shape = RoundedCornerShape(25.dp, 5.dp, 25.dp, 5.dp)
                )
                .verticalScroll(rememberScrollState())

        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                //.........................Image: preview
                Image(
                    painter = painterResource(id = com.example.weatherforecase_may15th.R.drawable.humidity),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    /*  colorFilter  = ColorFilter.tint(
                          color = MaterialTheme.colorScheme.primary
                      ),*/
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .height(320.dp)
                        .fillMaxWidth(),

                    )
                //.........................Spacer
                //.........................Text: title
                Text(
                    text = title!!,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        //  .padding(top = 5.dp)
                        .fillMaxWidth(),
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.primary,
                )
                Spacer(modifier = Modifier.height(8.dp))
                //.........................Text : description
                Text(
                    text = desc!!,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                        .fillMaxWidth(),
                    letterSpacing = 1.sp,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.primary,
                )
                //.........................Spacer
                Spacer(modifier = Modifier.height(24.dp))

                //.........................Button : OK button
                val cornerRadius = 16.dp
                val gradientColors = listOf(Color(0xFFff669f), Color(0xFFff8961))
                val roundedCornerShape = RoundedCornerShape(topStart = 30.dp,bottomEnd = 30.dp)

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, end = 32.dp),
                    onClick=onClick,
                    contentPadding = PaddingValues(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(cornerRadius)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                brush = Brush.horizontalGradient(colors = gradientColors),
                                shape = roundedCornerShape
                            )
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text ="Enable",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }


                //.........................Spacer
                Spacer(modifier = Modifier.height(12.dp))


                TextButton(onClick = {
                    enableLocation.value = false
                }) { Text("Cancel", style = MaterialTheme.typography.subtitle2) }


                Spacer(modifier = Modifier.height(24.dp))

            }
        }
    }
}