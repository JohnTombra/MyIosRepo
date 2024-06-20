package screens.change_password_feature

import screens.activate_feature.ActivateUiEvent

sealed class ChangePasswordUiEvent {

    data object ClearError: ChangePasswordUiEvent()

    data class Navigate(val value: String): ChangePasswordUiEvent()

    data object ValidateForm: ChangePasswordUiEvent()


    data class UpdateOldPassword(val value: String) : ChangePasswordUiEvent()


    data class UpdateNewPassword(val value: String) : ChangePasswordUiEvent()


    data class UpdateConfirmNewPassword(val value: String) : ChangePasswordUiEvent()


    data object Back: ChangePasswordUiEvent()
}