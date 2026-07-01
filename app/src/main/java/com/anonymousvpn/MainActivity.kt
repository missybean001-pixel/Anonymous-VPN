package com.anonymousvpn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anonymousvpn.github.GitHubClient
import com.anonymousvpn.github.Repo
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RepoScreen()
        }
    }
}

@Composable
fun RepoScreen() {
    var token by remember { mutableStateOf("") }
    var repos by remember { mutableStateOf<List<Repo>>(emptyList()) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("GitHub Repo Viewer")
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = token,
            onValueChange = { token = it },
            label = { Text("GitHub Token") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            scope.launch {
                try {
                    repos = GitHubClient.api.getRepos("Bearer $token")
                } catch (e: Exception) {
                    repos = emptyList()
                }
            }
        }) {
            Text("Load Repos")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(repos) { repo ->
                Text(repo.name, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
