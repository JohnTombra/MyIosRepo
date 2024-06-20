package screens.notification_feature

data class NotificationUiState(
    val email: String = "",
    val password: String = "",
    val error: String? = null,
    val success: Boolean = false,
    val loading: Boolean = false
)
