package screens.search_feature

import screens.activate_feature.ActivateUiEvent

sealed class SearchUiEvent {


    data object Back: SearchUiEvent()

    data class UpdateQuery(val value: String): SearchUiEvent()

    data class Navigate(val value: String): SearchUiEvent()
}