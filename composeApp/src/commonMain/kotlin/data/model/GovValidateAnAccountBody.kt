package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class GovValidateAnAccountBody(
    val account_number: String,
    val employee_no: String,
    val new_password: String,
    val new_password_confirmation: String
)