package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class GovUserDetailsResponse(
    val `data`: DataXXXXXX,
    val message: String,
    val status: Boolean
)