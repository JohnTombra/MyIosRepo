package screens.chatbot_feature

data class Message(
    val timestamp: String = "",
    val message: String = "",
    val sent: Boolean = false,
    val received: Boolean = false,
    val read: Boolean = false,
    val sender: String = ""
)
