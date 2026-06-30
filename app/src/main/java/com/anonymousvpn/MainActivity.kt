package com.anonymousvpn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainUI()
        }
    }
}

@Composable
fun MainUI() {
    val bg = Color(0xFF0A0A0A)
    val neon = Color(0xFF39FF14)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Anonymous-VPN", color = neon, fontSize = 26.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {}) {
            Text("Connect")
        }

        Button(onClick = {}) {
            Text("Settings")
        }
    }
}k
