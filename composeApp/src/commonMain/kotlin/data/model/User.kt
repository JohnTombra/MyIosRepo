package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class User(
    val email: String = "",
    val firstname: String = "",
    val group_id: Int = 0,
    val id: Int = 0,
    val middlename: String = "",
    val name: String = "",
    val service_code: String = "",
    val service_id: String = "",
    val surname: String = "",
    val user_phone: String = "",
    val username: String = ""
)