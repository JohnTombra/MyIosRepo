package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class GovSinglePayslipResponse(
    val `data`: DataXXXXXXXXX,
    val message: String,
    val status: Boolean
)