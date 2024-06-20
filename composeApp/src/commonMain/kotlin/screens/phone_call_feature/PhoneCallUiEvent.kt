package screens.phone_call_feature

import screens.activate_feature.ActivateUiEvent

sealed class PhoneCallUiEvent {

    data object ClearError: PhoneCallUiEvent()

    data object ValidateForm: PhoneCallUiEvent()

    data class UpdateEmail(val value: String) : PhoneCallUiEvent()

    data class UpdatePassword(val value: String) : PhoneCallUiEvent()
    data object Back: PhoneCallUiEvent()
}