package screens.my_info_feature

import com.kind.smartpay20android.data.model.gov.DataXXXXXXX

data class MyInfoUiState(
    val myInfo: DataXXXXXXX? = null,
    val error: String? = null,
    val message: String? = null,
    val loading: Boolean = false
)
