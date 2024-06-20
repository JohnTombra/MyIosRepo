package screens.social_media_feature

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


class SocialMediaComponent(
    componentContext: ComponentContext,
    val repository: Repository,
    private val navigation: (String) -> Unit,
): ComponentContext by componentContext {

    private var _uiState = MutableValue(SocialMediaUiState())
    val uiState: Value<SocialMediaUiState> = _uiState





    fun onEvent(event: SocialMediaUiEvent){
when(event){
    SocialMediaUiEvent.Back -> {
        navigation(Routes.Back.route)
    }
    SocialMediaUiEvent.ClearError -> TODO()
    is SocialMediaUiEvent.UpdateEmail -> TODO()
    is SocialMediaUiEvent.UpdatePassword -> TODO()
    SocialMediaUiEvent.ValidateForm -> TODO()
}
    }


}