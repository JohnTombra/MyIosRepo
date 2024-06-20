package screens.phone_call_feature

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


class PhoneCallComponent(
    componentContext: ComponentContext,
    val repository: Repository,
    private val navigation: (String) -> Unit,
): ComponentContext by componentContext {

    private var _uiState = MutableValue(PhoneCallUiState())
    val uiState: Value<PhoneCallUiState> = _uiState





    fun onEvent(event: PhoneCallUiEvent){
            when(event){
               PhoneCallUiEvent.Back -> {
                    navigation(Routes.Back.route)
                }
                PhoneCallUiEvent.ClearError -> TODO()
                is PhoneCallUiEvent.UpdateEmail -> TODO()
                is PhoneCallUiEvent.UpdatePassword -> TODO()
                PhoneCallUiEvent.ValidateForm -> TODO()
            }
    }


}