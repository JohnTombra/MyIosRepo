package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class GovRefreshTokenResponse(
    val `data`: DataX,
    val message: String,
    val status: Boolean
)