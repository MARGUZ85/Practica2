package com.example.practica2

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica2.ui.theme.Practica2Theme
import com.example.practica2.ui.components.*

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
                        ReplyListContent(
                            emails = sampleEmails,
                            onEmailSelected = { },
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

val sampleEmails = listOf(
    Email(1, Sender("Google"), true, "20 mins ago", "Package shipped!", "Cucumber Mask Facial has shipped."),
    Email(2, Sender("Ali"), false, "40 mins ago", "Brunch this weekend?", "I'll be in your neighborhood doing errands."),
    Email(3, Sender("Allison"), false, "1 hour ago", "Bonjour from Paris", "Here are some great shots from my trip."),
    Email(4, Sender("Kim"), false, "2 hours ago", "High school reunion?", "Hi friends, hope you are doing well!")
)

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
                ReplyListContent(
                    emails = sampleEmails,
                    onEmailSelected = { },
                    modifier = Modifier.padding(innerPadding)
                )
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
