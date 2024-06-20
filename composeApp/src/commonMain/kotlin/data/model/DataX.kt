package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class DataX(
    val expiry: Int,
    val token: String,
    val type: String
)