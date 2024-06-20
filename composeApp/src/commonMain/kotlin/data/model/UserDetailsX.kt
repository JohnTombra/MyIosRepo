package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class UserDetailsX(
    val admin_ministry_id: String? = "",
    val allowdesktoplogin: Int = 0,
    val allowmobilelogin: Int = 0,
    val business_id: String? = "",
    val category_id: String? = "",
    val created_at: String = "",
    val created_by: String = "",
    val department_id: String? = "",
    val email: String = "",
    val first_use: Int = 0,
    val firstname: String = "",
    val group_id: Int = 0,
    val id: Int = 0,
    val inactive: Int = 0,
    val is_admin: Int = 0,
    val is_supervisor: Int = 0,
    val middlename: String = "",
    val ministry_admin: Int = 0,
    val ministry_supervisor: Int = 0,
    val name: String = "",
    val prev_username: String? = "",
    val registered_on: String = "",
    val reset_expiry_date: String = "",
    val reset_token: String? = "",
    val service_code: String = "",
    val service_id: String = "",
    val supervisor_ministry_id: String? = "",
    val surname: String = "",
    val updated_at: String = "",
    val updated_by: String = "",
    val user_phone: String = "",
    val username: String = "",
)