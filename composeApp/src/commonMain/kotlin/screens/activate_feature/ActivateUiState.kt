package screens.activate_feature

data class ActivateUiState(
    val employeeNumber: String = "",
    val accountNumber: String = "",
    val newPassword: String = "",
    val confirmPassword: String = "",
    val error: String? = null,
    val loading: Boolean = false
)
