package screens.privacy_policy

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
import screens.search_feature.SearchUiState


class PrivacyPolicyComponent(
    componentContext: ComponentContext,
    val repository: Repository,
    private val navigation: (String) -> Unit,
): ComponentContext by componentContext {



    private var _uiState = MutableValue(PrivacyPolicyUiState())
    val uiState: Value<PrivacyPolicyUiState> = _uiState



    fun onEvent(event: PrivacyPolicyUiEvent) {
        when (event) {
            PrivacyPolicyUiEvent.Back -> {
                navigation(Routes.Back.route)
            }
        }
    }


}