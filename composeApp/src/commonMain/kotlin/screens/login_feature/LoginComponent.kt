package screens.login_feature

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import com.kind.smartpay20android.data.model.gov.GovLoginBody
import data.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import navigation.MESSAGE
import navigation.Routes


class LoginComponent(
    componentContext: ComponentContext,
    val repository: Repository,
    private val navigation: (String) -> Unit,
): ComponentContext by componentContext {

    var once = true

    private var _uiState = MutableValue(LoginUiState())
    val uiState: Value<LoginUiState> = _uiState



    init{
    }


    fun onEvent(event: LoginUiEvent){
        when(event){
            LoginUiEvent.Back -> {
                navigation(Routes.Back.route)
            }
            LoginUiEvent.ClearError -> {
                CoroutineScope(Dispatchers.IO).launch {
                    delay(2000)
                    _uiState.update { it.copy(error = null) }
                }
            }
            LoginUiEvent.ValidateForm -> {
               if(_uiState.value.email.isEmpty()){
                    _uiState.update { it.copy(error = "Enter your username") }
                }else if(_uiState.value.password.isEmpty()){
                    _uiState.update { it.copy(error = "Enter your password") }
                }else{

                   _uiState.update { it.copy(loading = true) }

                    val login = GovLoginBody(
                        username = _uiState.value.email,
                        password = _uiState.value.password
                    )


                   //check if validated
                   repository.govCheckValidation(login.username,{


                       if(it) {

                           repository.login(login, {

                               _uiState.update { it.copy(loading = false, email = "", password = "") }

                               navigation(Routes.Home.route)
                           }) { error ->
                               _uiState.update { it.copy(error = error, loading = false) }
                           }

                       }else{
                           navigation(Routes.Acivate.route)
                       }


                   }){ error ->
                       _uiState.update { it.copy(error = error, loading = false) }
                   }


                }
            }
            is LoginUiEvent.UpdateEmail -> {
                _uiState.update { it.copy(email = event.value) }
            }
            is LoginUiEvent.UpdatePassword -> {
                _uiState.update { it.copy(password = event.value) }
            }
            is LoginUiEvent.Initialize -> {
                if(once){
                    CoroutineScope(Dispatchers.IO).launch {
                        delay(2000)
                        _uiState.update { it.copy(error = MESSAGE) }
                        once = false
                    }}
            }

            is LoginUiEvent.Navigate -> {
                navigation(Routes.PrivacyPolicy.route)
            }
        }
    }


}