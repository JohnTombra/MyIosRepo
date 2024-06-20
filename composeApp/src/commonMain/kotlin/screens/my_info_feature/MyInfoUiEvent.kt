package screens.my_info_feature

import screens.activate_feature.ActivateUiEvent

sealed class MyInfoUiEvent {

    data object ClearError: MyInfoUiEvent()

    data object ClearMessage: MyInfoUiEvent()

    data object Download: MyInfoUiEvent()

    data object Navigate: MyInfoUiEvent()

    data object Logout: MyInfoUiEvent()
    data object Back: MyInfoUiEvent()
}