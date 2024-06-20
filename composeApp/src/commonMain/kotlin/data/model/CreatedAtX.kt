package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class CreatedAtX(
    val date: String = "",
    val timezone: String = "",
    val timezone_type: Int = 0
)