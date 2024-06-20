package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class GovLogoutResponse(
    val message: String,
    val status: Boolean
)