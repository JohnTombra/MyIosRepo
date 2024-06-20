package screens.change_password_feature

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import com.kind.smartpay20android.data.model.gov.GovChangePasswordBody
import com.kind.smartpay20android.data.model.gov.GovLoginBody
import com.kind.smartpay20android.data.model.gov.GovNewPasswordBody
import data.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import navigation.MESSAGE
import navigation.Routes
import screens.activate_feature.ActivateUiEvent
import screens.activate_feature.VALIDATION
import screens.home_feature.HomeUiEvent


class ChangePasswordComponent(
    componentContext: ComponentContext,
    val repository: Repository,
    private val navigation: (String) -> Unit,
): ComponentContext by componentContext {


    private var _uiState = MutableValue(ChangePasswordUiState())
    val uiState: Value<ChangePasswordUiState> = _uiState






    fun onEvent(event: ChangePasswordUiEvent){
        when(event){
            ChangePasswordUiEvent.Back -> {
                navigation(Routes.Back.route)
            }
            ChangePasswordUiEvent.ClearError -> {
                CoroutineScope(Dispatchers.IO).launch {
                    delay(2000)
                    _uiState.update { it.copy(error = null) }
                }
            }
            ChangePasswordUiEvent.ValidateForm -> {
               if(_uiState.value.oldPassword.isEmpty()){
                    _uiState.update { it.copy(error = "Enter current password") }
                }else if(_uiState.value.newPassword.isEmpty()){
                    _uiState.update { it.copy(error = "Enter new password") }
                }
                else if(_uiState.value.newPassword.isEmpty()){
                   _uiState.update { it.copy(error = "Confirm new password") }
               }else{

                   _uiState.update { it.copy(loading = true) }

                    val passwordBody = GovNewPasswordBody(
                        current_password = _uiState.value.oldPassword,
                        new_password = _uiState.value.newPassword,
                        new_password_confirmation = _uiState.value.confirmNewPassword
                    )


                   repository.govNewPassword(passwordBody,{

                       VALIDATION = 1
                       MESSAGE = "Password changed"
                    navigation(Routes.Login.route)


                   }){ error ->
                       _uiState.update { it.copy(error = error, loading = false) }
                   }

                }
            }
            is ChangePasswordUiEvent.UpdateOldPassword -> {
                _uiState.update { it.copy(oldPassword = event.value) }
            }
            is ChangePasswordUiEvent.UpdateNewPassword -> {
                _uiState.update { it.copy(newPassword = event.value) }
            }
            is ChangePasswordUiEvent.UpdateConfirmNewPassword -> {
                _uiState.update { it.copy(confirmNewPassword = event.value) }
            }
            is ChangePasswordUiEvent.Navigate -> {
                navigation(Routes.PrivacyPolicy.route)
            }
        }
    }


}