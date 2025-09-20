package com.example.practica2.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ReplyListContent(
    emails: List<Email>,
    onEmailSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(emails) { email ->
            ReplyEmailListItem(
                email = email,
                isSelected = false,
                navigateToDetail = onEmailSelected
            )
        }
    }
}
