package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class GovLoginResponse(
    val `data`: DataXXXXXXXX,
    val message: String,
    val status: Boolean
)