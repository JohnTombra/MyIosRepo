package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class PayslipDetails(
    val ALLOWANCES: String,
    val BASIC_SALARY: String,
    val DEDUCTIONS: String,
    val MONTH: String,
    val MONTHLY_GROSS: String,
    val MONTHLY_PAY: String,
    val MONTHLY_PAY_B4_CHECKINDEDUCTION: String,
    val PRID: Int,
    val TOTAL_MONTHLY_ALLOWANCES: String,
    val TOTAL_MONTHLY_DEDUCTIONS: String,
    val YEAR: Int,
    val account_number: String,
    val account_type: String,
    val age: Int,
    val audit: Int,
    val bank_branch: String,
    val bank_name: String,
    val batch_no: String,
    val branch_name: String,
    val category: String,
    val checkin_deduction_amount: String,
    val checkin_deduction_names: String?,
    val current_designation: String,
    val current_grade_level: String,
    val current_step: String,
    val department: String?,
    val employee_no: String?,
    val entry_establishment: String,
    val generated_on: String,
    val locked: Int,
    val locked_on: String?,
    val ministry: String,
    val non_taxable_allowances: String,
    val overpayment: String,
    val payment_status: String,
    val payment_status_description: String?,
    val payment_update_at: String?,
    val salary_structure: String,
    val service_id: String,
    val session_id: String?,
    val total_non_taxable_allowances: String
)