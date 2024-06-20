package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class Message(
    val timestamp: String = "",
    val message: String = "",
    val sent: Boolean = false,
    val received: Boolean = false,
    val read: Boolean = false,
    val sender: String = ""
)
