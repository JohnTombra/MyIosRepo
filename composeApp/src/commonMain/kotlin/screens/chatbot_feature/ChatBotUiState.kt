package screens.chatbot_feature

data class ChatBotUiState(
    val message: String = "",
    val messages: List<Message> = listOf(),
    val error: String? = null,
    val navigate: String? = null,
    val scrollDown: Boolean = false,
)
