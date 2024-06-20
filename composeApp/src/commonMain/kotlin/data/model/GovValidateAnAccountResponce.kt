package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class GovValidateAnAccountResponce(
    val `data`: DataXXXXX,
    val message: String,
    val status: Boolean
)