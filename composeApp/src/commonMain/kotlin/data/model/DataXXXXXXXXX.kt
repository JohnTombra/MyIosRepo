package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class DataXXXXXXXXX(
    val allowances: List<List<String>>,
    val deductions: List<List<String>>,
    val non_tax_allowances: List<String>,
    val payslip_details: PayslipDetailsXX,
    val retirement_date: String,
    val retirement_days: Int
)