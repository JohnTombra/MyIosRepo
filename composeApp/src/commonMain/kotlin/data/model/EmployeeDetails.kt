package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class EmployeeDetails(
    val account_email: String?,
    val account_firstname: String,
    val account_middle_name: String,
    val account_number: String,
    val account_phone_number: String,
    val account_surname: String,
    val account_type: String,
    val acting_appointment_1st_emp: String?,
    val acting_appointment_current_emp: String?,
    val active: Int,
    val appointment_status_1st_emp: String?,
    val appointment_status_current_emp: String,
    val bank: String,
    val bank_branch: String,
    val biometric_by: String?,
    val bvn: String,
    val bvn_verified_status: Int,
    val city: String,
    val community: String?,
    val confirmation_date_1st_emp: String,
    val confirmation_date_current_emp: String,
    val created_at: CreatedAt,
    val created_by: String,
    val current_category: String,
    val current_designation: String,
    val current_grade_level: String,
    val current_step: Int,
    val date_of_birth: String,
    val date_of_last_promotion_1st_emp: String?,
    val date_of_last_promotion_current_emp: String?,
    val department: String,
    val dl_expiry_date: String?,
    val drivers_license_number: String?,
    val email: String,
    val emp_info_id: Int,
    val employee_no: String,
    val employment_number: String?,
    val enable_payroll: Int,
    val entry_designation_1st_emp: String?,
    val entry_establishment: String,
    val entry_grade_level_1st_emp: String,
    val entry_step_1st_emp: String,
    val first_date_of_current_employment: String,
    val first_date_of_first_employment: String,
    val first_name: String,
    val full_fathers_name: String?,
    val fullname: String,
    val gender: String,
    val group_id: String?,
    val international_passport_number: String?,
    val lga: String,
    val maiden_name: String?,
    val marital_status: String,
    val middle_name: String,
    val ministry: String,
    val mobile_phone: String,
    val mothers_name: String?,
    val national_id_cardno: String?,
    val nationality: String?,
    val nhf_code: String?,
    val nhf_number: String?,
    val nhis_administrator: String?,
    val nhis_number: String?,
    val pension_pin_number: String?,
    val pension_status: Int,
    val permanent_city_address: String?,
    val permanent_country: String?,
    val permanent_state: String?,
    val permanent_street_address: String?,
    val photo_capture: Int,
    val photo_url: String,
    val place_of_1st_employment: String,
    val postal_address: String?,
    val residential_city: String,
    val residential_country: String,
    val residential_lga: String,
    val residential_state: String,
    val residential_street: String,
    val salary_structure: String,
    val service_id: String,
    val spouse_name: String?,
    val state_of_origin: String,
    val surname: String,
    val time_of_activation: String,
    val title: String,
    val type_of_accom: String,
    val user_id: String?,
    val verified: Int,
    val verified_account_name: String?,
    val verified_accountno: String?,
    val verified_bankname: String?,
    val verified_bvn: String?,
    val village: String?
)