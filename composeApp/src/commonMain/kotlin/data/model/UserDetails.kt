package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class UserDetails(
    val admin_ministry_id: String?,
    val allowdesktoplogin: Int,
    val allowmobilelogin: Int,
    val business_id: String?,
    val category_id: String?,
    val created_at: String,
    val created_by: String,
    val department_id: String?,
    val email: String,
    val first_use: Int,
    val firstname: String,
    val group_id: Int,
    val id: Int,
    val inactive: Int,
    val is_admin: Int,
    val is_supervisor: Int,
    val middlename: String,
    val ministry_admin: Int,
    val ministry_supervisor: Int,
    val name: String,
    val prev_username: String?,
    val registered_on: String,
    val reset_expiry_date: String,
    val reset_token: String?,
    val service_code: String,
    val service_id: String,
    val supervisor_ministry_id: String?,
    val surname: String,
    val updated_at: String,
    val updated_by: String,
    val user_phone: String,
    val username: String
)