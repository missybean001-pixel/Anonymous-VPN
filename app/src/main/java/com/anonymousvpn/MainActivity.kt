package com.anonymousvpn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anonymousvpn.github.GitHubClient
import com.anonymousvpn.github.Repo
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CyberHome()
        }
    }
}

@Composable
fun CyberHome() {

    val scope = rememberCoroutineScope()
    var token by remember { mutableStateOf("") }
    var repos by remember { mutableStateOf<List<Repo>>(emptyList()) }
    var loading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("ANONYMOUS VPN", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = token,
            onValueChange = { token = it },
            label = { Text("GitHub Token") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                scope.launch {
                    loading = true
                    try {
                        repos = GitHubClient.api.getRepos("Bearer $token")
                    } catch (e: Exception) {
                        repos = emptyList()
                    }
                    loading = false
                }
            }
        ) {
            Text("CONNECT")
        }

        if (loading) {
            CircularProgressIndicator()
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text("REPOSITORIES:")

        repos.forEach { repo ->
            Text("• ${repo.name}")
        }
    }
}
