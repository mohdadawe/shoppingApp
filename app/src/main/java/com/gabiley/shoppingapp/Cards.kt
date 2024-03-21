package com.gabiley.shoppingapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cards(){
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission Accepted
        }
        else {
            // Permission Denied
        }
    }

    Card(
        modifier = Modifier
            .fillMaxSize(),
        RoundedCornerShape(0.dp),
        //elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                //.background(Color.Green)
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                //.background(Color.LightGray)
            ) {
                Text(
                    text = "#",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "11 min",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.padding(7.dp))

                Text(
                    text = "Axmed Cali Muuse",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Waxaad ka Jartay: 12,000",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )


            Spacer(modifier = Modifier.padding(7.dp))


            ///////////////////////////////////////////////////
            ///////////////////////////////////////////////////
            ///////////////////////////////////////////////////

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    //.background(color = Color.Yellow)
                    .fillMaxSize()
                    .padding(
                        start = 30.dp,
                        end = 30.dp,
                        top = 0.dp,
                        bottom = 0.dp
                    )
            ) {
                // DOLLAR
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                    //.background(Color.Gray)
                ) {
                    Text(
                        text = "USD",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "$112",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold
                    )

                }

                // SLSH
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                    //.background(Color.LightGray)
                ) {
                    Text(
                        text = "SLSH",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "20,000,000",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }


            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    //.background(color = Color.Yellow)
                    .fillMaxSize()
                    .padding(
                        start = 30.dp,
                        end = 30.dp,
                        top = 0.dp,
                        bottom = 0.dp
                    )
            ) {

                Button(onClick = {
                    when (PackageManager.PERMISSION_GRANTED) {
                        //Check permission
                        ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) -> {

                            val money = 12000
                            val myNumber = 4638883

                            val dialedNum    = "*220*$myNumber*$money%23"
                            val callIntent   = Intent(Intent.ACTION_CALL)
                            callIntent.data  = Uri.parse("tel:$dialedNum")
                            startActivity(context, callIntent, null)
                        }
                        else -> {
                            // Asking for permission
                            launcher.launch(Manifest.permission.CALL_PHONE)
                        }
                    }

                }) {
                    Text(text = "Telesom", fontSize = 16.sp)
                }
                Button(onClick = {
                    when (PackageManager.PERMISSION_GRANTED) {
                        //Check permission
                        ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) -> {

                            val money = 12000
                            val myNumber = 4638883

                            val dialedNum    = "*220*$myNumber*$money%23"
                            val callIntent   = Intent(Intent.ACTION_CALL)
                            callIntent.data  = Uri.parse("tel:$dialedNum")
                            startActivity(context, callIntent, null)
                        }
                        else -> {
                            // Asking for permission
                            launcher.launch(Manifest.permission.CALL_PHONE)
                        }
                    }
                }) {
                    Text(text = "Somtel", fontSize = 16.sp)
                }




            }
        }
    } //END Card
}

