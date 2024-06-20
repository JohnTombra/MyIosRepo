package screens.home_feature

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


class HomeScreenComponent(
    componentContext: ComponentContext,
    val repository: Repository,
    private val navigation: (String) -> Unit,
): ComponentContext by componentContext {

    var once = true

    private var _uiState = MutableValue(HomeUiState())
    val uiState: Value<HomeUiState> = _uiState



    init {
        _uiState.update { it.copy(me = Repository.me!!.data.user.name) }
    }


    fun onEvent(event: HomeUiEvent){

        when(event){
           HomeUiEvent.Back -> {
                navigation(Routes.Back.route)
            }
            HomeUiEvent.ClearError -> {
                CoroutineScope(Dispatchers.IO).launch {
                    delay(4000)
                    _uiState.update { it.copy(error = null) }
                }
            }
            is HomeUiEvent.Navigate -> {
                navigation(event.value)
            }
            is HomeUiEvent.Initialize -> {
                if(once){
                    CoroutineScope(Dispatchers.IO).launch {
                        delay(2000)
                        _uiState.update { it.copy(error = "Login Successful") }
                        once = false
                    }}
            }

            is HomeUiEvent.ShowMessage ->{ //
                _uiState.update { it.copy(error = event.value) }
            }
        }

    }


}