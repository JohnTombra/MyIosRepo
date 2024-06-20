package screens.notification_feature

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


class NotificationComponent(
    componentContext: ComponentContext,
    val repository: Repository,
    private val navigation: (String) -> Unit,
): ComponentContext by componentContext {


    private var _uiState = MutableValue(NotificationUiState())
    val uiState: Value<NotificationUiState> = _uiState





    fun onEvent(event: NotificationUiEvent){
        when(event){
            NotificationUiEvent.Back -> {
                navigation(Routes.Back.route)
            }
            NotificationUiEvent.ClearError -> TODO()
            is NotificationUiEvent.UpdateEmail -> TODO()
            is NotificationUiEvent.UpdatePassword -> TODO()
            NotificationUiEvent.ValidateForm -> TODO()
        }
    }



}