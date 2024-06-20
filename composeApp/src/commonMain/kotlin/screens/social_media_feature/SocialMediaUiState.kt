package screens.social_media_feature

data class SocialMediaUiState(
    val email: String = "",
    val password: String = "",
    val error: String? = null,
    val success: Boolean = false,
    val loading: Boolean = false
)
