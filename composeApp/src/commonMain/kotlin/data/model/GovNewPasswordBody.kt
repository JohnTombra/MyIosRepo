package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class GovNewPasswordBody(
    val current_password: String,
    val new_password: String,
    val new_password_confirmation: String
)
