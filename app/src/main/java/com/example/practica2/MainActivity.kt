package com.example.practica2

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica2.ui.theme.Practica2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica2Theme {
                Surface(tonalElevation = 5.dp) {
                    Scaffold(
                        floatingActionButton = {
                            LargeFloatingActionButton(
                                onClick = { },
                                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                            ) {
                                Icon(Icons.Default.Create, contentDescription = "Nuevo mensaje")
                            }
                        },
                        modifier = Modifier.fillMaxSize()
                    ) { innerPadding ->
                        MessageList(
                            messages = sampleMessages,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

data class Message(
    val sender: String,
    val time: String,
    val content: String,
    val isStarred: Boolean = false,
    val isImportant: Boolean = false
)

val sampleMessages = listOf(
    Message("Google", "20 mins ago", "Package shipped! Cucumber Mask Facial has shipped.", isImportant = true),
    Message("Ali", "40 mins ago", "Brunch this weekend? I'll be in your neighborhood doing errands."),
    Message("Allison", "1 hour ago", "Bonjour from Paris. Here are some great shots from my trip."),
    Message("Kim", "2 hours ago", "High school reunion? Hi friends, hope you are doing well!")
)

@Composable
fun MessageList(messages: List<Message>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(messages) { msg ->
            MessageCard(msg)
        }
    }
}

@Composable
fun MessageCard(message: Message) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (message.isImportant)
                MaterialTheme.colorScheme.secondaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = message.sender, style = MaterialTheme.typography.titleMedium)
                Icon(
                    imageVector = if (message.isStarred) Icons.Filled.Star else Icons.Outlined.Star,
                    contentDescription = "Starred"
                )
            }
            Text(text = message.time, style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = message.content, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewReplyApp() {
    Practica2Theme {
        Surface(tonalElevation = 5.dp) {
            Scaffold(
                floatingActionButton = {
                    LargeFloatingActionButton(
                        onClick = { },
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                    ) {
                        Icon(Icons.Default.Create, contentDescription = "Nuevo mensaje")
                    }
                }
            ) { innerPadding ->
                MessageList(sampleMessages, modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun ReplyAppPreview() {
    Practica2Theme {
        Surface(tonalElevation = 5.dp) {}
    }
}
