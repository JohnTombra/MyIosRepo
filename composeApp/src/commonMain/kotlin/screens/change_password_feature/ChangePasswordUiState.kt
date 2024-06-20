package screens.change_password_feature

data class ChangePasswordUiState(
    val oldPassword: String = "",
    val newPassword: String = "",
    val confirmNewPassword: String = "",
    val error: String? = null,
    val success: Boolean = false,
    val loading: Boolean = false
)
