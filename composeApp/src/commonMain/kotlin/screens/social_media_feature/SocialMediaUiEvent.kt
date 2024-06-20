package screens.social_media_feature

import screens.activate_feature.ActivateUiEvent

sealed class SocialMediaUiEvent {

    data object ClearError: SocialMediaUiEvent()

    data object ValidateForm: SocialMediaUiEvent()

    data class UpdateEmail(val value: String) : SocialMediaUiEvent()

    data class UpdatePassword(val value: String) : SocialMediaUiEvent()
    data object Back: SocialMediaUiEvent()
}