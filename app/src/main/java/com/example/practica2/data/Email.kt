package com.example.practica2.data

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
