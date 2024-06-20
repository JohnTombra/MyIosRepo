package screens.chatbot_feature

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import com.jetbrains.kmpapp.multiple.timestamp
import data.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import navigation.Routes
import screens.activate_feature.ActivateUiEvent
import screens.login_feature.LoginUiEvent
import screens.login_feature.LoginUiState


class ChatBotComponent(
    componentContext: ComponentContext,
    val repository: Repository,
    private val navigation: (String) -> Unit,
): ComponentContext by componentContext {




    private var _uiState = MutableValue(ChatBotUiState())
    val uiState: Value<ChatBotUiState> = _uiState


    init {


        val message1 = Message(
            timestamp(),
            "Hi. I am your personal chat-bot here to assist you through your journey on this app.",
            true,
            true,
            true
        )





        val message2 = Message(
            timestamp(),
            "Select the service you need and I will help you\n\n" +
                    "- To view payslips type '1'\n" +
                    "- To download payslips type '2'\n" +
                    "- To view your info type '3'\n" +
                    "- To call our support team type '4'\n" +
                    "- to visit our social media pages click 5\n" +
                    "- to logout click 6",
            true,
            true,
            true,
            "chatbot"
        )


        sendMessage(message1)
        sendMessage(message2)



    }




    fun sendMessage(message: Message){



        val newList = _uiState.value.messages.toMutableList() + mutableListOf(message)


        _uiState.update { it.copy(messages = newList) }


        _uiState.update { it.copy(scrollDown = true) }


        //This creates a response to the sent message
        if(message.sender == "Me"){

            when(message.message){

                "1" -> {

                    val message = Message(
                        timestamp(),
                        "Okay",
                        true,
                        true,
                        true,
                        "chatbot"
                    )

                    sendMessage(message)

                    navigation(Routes.AllPayslip.route)

//                    CoroutineScope(Dispatchers.Default).launch {
//                        delay(500)
//                        _uiState.update { it.copy(navigate = "AllPayslipsScreen") }
//                    }




                }
                "2" -> {
                    val message = Message(
                        timestamp(),
                        "Okay. To download a payslip, you need to: \n- Visit your home page\n- Click on the 'View payslips' button\nSelect a specific month and year\n- Click on the payslip you want to download\n- Click on the download button on the payslip info screen. \n\nThank you",
                        true,
                        true,
                        true,
                        "chatbot"
                    )
                    sendMessage(message)
                }
                "3" -> {
                    val message = Message(
                        timestamp(),
                        "Okay",
                        true,
                        true,
                        true,
                        "chatbot"
                    )

                    sendMessage(message)
                    navigation(Routes.MyInfo.route)
//                    CoroutineScope(Dispatchers.Default).launch {
//                        delay(500)
//                        _uiState.update { it.copy(navigate = "ProfileScreen") }
//                    }


                }
                "4" -> {
                    val message = Message(
                        timestamp(),
                        "Okay",
                        true,
                        true,
                        true,
                        "chatbot"
                    )

                    sendMessage(message)

                    navigation(Routes.PhoneCall.route)
//                    CoroutineScope(Dispatchers.Default).launch {
//                        delay(500)
//                        _uiState.update { it.copy(navigate = "SupportScreen") }
//                    }

                }
                "5" -> {
                    val message = Message(
                        timestamp(),
                        "Okay",
                        true,
                        true,
                        true,
                        "chatbot"
                    )

                    sendMessage(message)
                    navigation(Routes.SocialMedia.route)
//                    CoroutineScope(Dispatchers.Default).launch {
//                        delay(500)
//                        _uiState.update { it.copy(navigate = "LoanScreen") }
//                    }

                }
                "6" -> {
                    val message = Message(
                        timestamp(),
                        "Okay",
                        true,
                        true,
                        true,
                        "chatbot"
                    )

                    sendMessage(message)
                    navigation(Routes.Login.route)
//                    CoroutineScope(Dispatchers.Default).launch {
//                        delay(500)
//                        _uiState.update { it.copy(navigate = "LeaveScreen") }
//                    }



                }









                else ->{

                    val message = Message(
                        timestamp(),
                        "Invalid response. \n\n" +
                                "- To view payslips type '1'\n" +
                                "- To download payslips type '2'\n" +
                                "- To view your info type '3'\n" +
                                "- To call our support team type '4'\n" +
                                "- to visit our social media pages click 5\n" +
                                "- to logout click 6",
                        true,
                        true,
                        true,
                        "chatbot"
                    )


                    sendMessage(message)




                }

            }




        }

    }


    fun onEvent(event: ChatBotUiEvent){
        when(event){
            ChatBotUiEvent.Back -> {
                navigation(Routes.Back.route)
            }
            is ChatBotUiEvent.UpdateMessage -> {
                _uiState.update { it.copy(message = event.value) }
            }

            ChatBotUiEvent.SendMessage -> {
                if(_uiState.value.messages.isNotEmpty()){
                    val message = Message(timestamp =  timestamp(), message = _uiState.value.message,
                        sent = true,
                        received = false,
                        read = false,
                        "Me"
                    )

                    _uiState.update { it.copy(message = "") }
                    sendMessage(message)
                }
            }

            ChatBotUiEvent.ClearNavigation -> {
                _uiState.update { it.copy(navigate = null) }
            }

            ChatBotUiEvent.ClearScroll -> {
                _uiState.update { it.copy(scrollDown = false) }
            }
        }
    }

}