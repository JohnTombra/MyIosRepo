package screens.login_feature

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val error: String? = null,
    val success: Boolean = false,
    val loading: Boolean = false
)
