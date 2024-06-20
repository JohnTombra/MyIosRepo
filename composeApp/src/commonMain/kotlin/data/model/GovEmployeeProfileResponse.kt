package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class GovEmployeeProfileResponse(
    val `data`: DataXXXXXXX,
    val message: String,
    val status: Boolean
)