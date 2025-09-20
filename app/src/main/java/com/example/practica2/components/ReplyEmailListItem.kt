package com.example.practica2.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.unit.dp

data class Email(
    val id: Int,
    val sender: Sender,
    val isImportant: Boolean,
    val createdAt: String,
    val subject: String,
    val body: String
)

data class Sender(
    val firstName: String
)

@Composable
fun ReplyEmailListItem(
    email: Email,
    isSelected: Boolean,
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .semantics { selected = isSelected }
            .clickable { navigateToDetail(email.id) },
        colors = CardDefaults.cardColors(
            containerColor = if (email.isImportant)
                MaterialTheme.colorScheme.secondaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = email.sender.firstName,
                style = MaterialTheme.typography.labelMedium
            )

            Text(
                text = email.createdAt,
                style = MaterialTheme.typography.labelMedium
            )

            Text(
                text = email.subject,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 12.dp, bottom = 8.dp)
            )

            Text(
                text = email.body,
                maxLines = 2,
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
