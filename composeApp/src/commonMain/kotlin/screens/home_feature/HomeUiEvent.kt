package screens.home_feature

import screens.activate_feature.ActivateUiEvent

sealed class HomeUiEvent {

    data object ClearError: HomeUiEvent()

    data class Navigate(val value: String): HomeUiEvent()

    data class ShowMessage(val value: String): HomeUiEvent()

    data object Initialize: HomeUiEvent()
    data object Back: HomeUiEvent()
}