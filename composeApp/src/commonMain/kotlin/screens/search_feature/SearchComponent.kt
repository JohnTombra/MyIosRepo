package screens.search_feature

import androidx.compose.ui.text.toLowerCase
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
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


class SearchComponent(
    componentContext: ComponentContext,
    val repository: Repository,
    private val navigation: (String) -> Unit,
): ComponentContext by componentContext {


    private var _uiState = MutableValue(SearchUiState())
    val uiState: Value<SearchUiState> = _uiState


    var list = listOf("Payslips","My Info","Chat bot","Phone call","Social media","Notification", "Logout","PrivacyPolicy")



    fun onEvent(event: SearchUiEvent) {

        when (event) {
            SearchUiEvent.Back -> {
                navigation(Routes.Back.route)
            }



            is SearchUiEvent.UpdateQuery -> {
                _uiState.update { it.copy(query = event.value) }
                search()
            }

            is SearchUiEvent.Navigate -> {

                when(event.value){
                    "Payslips" -> {
                        navigation(Routes.AllPayslip.route)
                    }
                    "My Info" -> {
                        navigation(Routes.MyInfo.route)
                    }
                    "Chat bot" -> {
                        navigation(Routes.ChatBot.route)
                    }
                    "Phone call" -> {
                        navigation(Routes.PhoneCall.route)
                    }
                    "Social media" -> {
                        navigation(Routes.SocialMedia.route)
                    }
                    "Notification" -> {
                        navigation(Routes.Notification.route)
                    }
                    "Logout" -> {
                        navigation(Routes.Login.route)
                    }
                    "PrivacyPolicy" -> {
                        navigation(Routes.PrivacyPolicy.route)
                    }
                }


            }
        }

    }

    fun search(){

        if(_uiState.value.query.isEmpty()){
            _uiState.update { it.copy(result = emptyList()) }
            return
        }

        val result = list.filter { it.lowercase().contains(_uiState.value.query.lowercase()) }
        _uiState.update { it.copy(result = result) }

    }


}