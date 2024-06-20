package screens.privacy_policy

import screens.activate_feature.ActivateUiEvent

sealed class PrivacyPolicyUiEvent {

    data object Back: PrivacyPolicyUiEvent()
}