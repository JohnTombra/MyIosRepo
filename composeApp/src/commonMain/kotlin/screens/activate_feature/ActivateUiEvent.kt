package screens.activate_feature

sealed class ActivateUiEvent {

    data object ClearError: ActivateUiEvent()

    data object ValidateForm: ActivateUiEvent()

    data class UpdateEmployeeNumber(val value: String) : ActivateUiEvent()

    data class UpdateAccountNumber(val value: String) : ActivateUiEvent()

    data class UpdateNewPassword(val value: String) : ActivateUiEvent()

    data class UpdateConfirmPassword(val value: String) : ActivateUiEvent()

    data object Back: ActivateUiEvent()

}