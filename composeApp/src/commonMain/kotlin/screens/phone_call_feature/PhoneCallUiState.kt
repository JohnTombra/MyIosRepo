package screens.phone_call_feature

data class PhoneCallUiState(
    val email: String = "",
    val password: String = "",
    val error: String? = null,
    val success: Boolean = false,
    val loading: Boolean = false
)
