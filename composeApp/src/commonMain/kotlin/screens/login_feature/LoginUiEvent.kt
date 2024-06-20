package screens.login_feature

import screens.activate_feature.ActivateUiEvent

sealed class LoginUiEvent {

    data object ClearError: LoginUiEvent()

    data class Navigate(val value: String): LoginUiEvent()

    data object Initialize: LoginUiEvent()

    data object ValidateForm: LoginUiEvent()

    data class UpdateEmail(val value: String) : LoginUiEvent()

    data class UpdatePassword(val value: String) : LoginUiEvent()
    data object Back: LoginUiEvent()
}