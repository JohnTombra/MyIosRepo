package screens.all_payslips_feature

import com.kind.smartpay20android.data.model.gov.DataXXXX

data class AllPayslipsUiState(
    val payslips: List<DataXXXX> = listOf(),
    val error: String? = null,
    val loading: Boolean = false,
    val years:List<String> = emptyList(),
    val startYear: String = "",
    val year: String = "Year",
    val months: List<String> = emptyList(),
    val month: String = "Month",
)
