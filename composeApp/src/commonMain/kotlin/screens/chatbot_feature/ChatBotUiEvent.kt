package screens.chatbot_feature

import screens.activate_feature.ActivateUiEvent

sealed class ChatBotUiEvent {

    data class UpdateMessage(val value: String): ChatBotUiEvent()

    data object SendMessage: ChatBotUiEvent()

    data object ClearNavigation: ChatBotUiEvent()

    data object ClearScroll: ChatBotUiEvent()
    data object Back: ChatBotUiEvent()
}