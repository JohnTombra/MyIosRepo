package screens.payslip_feature

import com.kind.smartpay20android.data.model.gov.DataXXXXXXX
import com.kind.smartpay20android.data.model.gov.DataXXXXXXXXX

data class PayslipUiState(
    val payslip: DataXXXXXXXXX? = null,
    val myInfo: DataXXXXXXX? = null,
    val error: String? = null,
    val message: String? = null,
    val loading: Boolean = false
)
