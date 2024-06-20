package screens.notification_feature

import screens.activate_feature.ActivateUiEvent

sealed class NotificationUiEvent {

    data object ClearError: NotificationUiEvent()

    data object ValidateForm: NotificationUiEvent()

    data class UpdateEmail(val value: String) : NotificationUiEvent()

    data class UpdatePassword(val value: String) : NotificationUiEvent()
    data object Back: NotificationUiEvent()
}