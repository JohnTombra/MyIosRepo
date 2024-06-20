package screens.my_info_feature

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
import navigation.MESSAGE
import navigation.Routes
import screens.activate_feature.ActivateUiEvent
import screens.login_feature.LoginUiEvent
import screens.login_feature.LoginUiState
import screens.payslip_feature.PayslipUiEvent


class MyInfoComponent(
    componentContext: ComponentContext,
    val repository: Repository,
    private val navigation: (String) -> Unit,
): ComponentContext by componentContext {

    private var _uiState = MutableValue(MyInfoUiState())
    val uiState: Value<MyInfoUiState> = _uiState



    init {

        _uiState.update { it.copy(loading = true) }


        repository.getMyInfo({ myInfo->
            _uiState.update { it.copy(myInfo = myInfo.data,loading = false) }
        }){error->
            _uiState.update { it.copy(error = error,loading = false) }
        }


    }


    fun onEvent(event: MyInfoUiEvent){
            when(event){
                MyInfoUiEvent.Back -> {
                    navigation(Routes.Back.route)
                }
                MyInfoUiEvent.ClearError -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        delay(2000)
                        _uiState.update { it.copy(error = null) }
                    }
                }
                MyInfoUiEvent.Logout -> {

                    _uiState.update { it.copy(loading = true) }

                    repository.logout({
                        MESSAGE = "Good Bye!"
                        navigation(Routes.Login.route)
                    }){error->
                        _uiState.update { it.copy(error = error,loading = true) }
                    }

                }
                MyInfoUiEvent.ClearMessage -> {
                    CoroutineScope(Dispatchers.Default).launch {
                        delay(3500)
                        _uiState.update { it.copy(message = null) }
                    }
                }
                MyInfoUiEvent.Navigate -> {
                    navigation(Routes.ChangePassword.route)
                }


                is MyInfoUiEvent.Download -> {
                    _uiState.update { it.copy(message = "Info Downloaded") }
                }
            }
    }

}