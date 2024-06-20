package screens.activate_feature

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import com.kind.smartpay20android.data.model.gov.GovValidateAnAccountBody
import data.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import navigation.MESSAGE
import navigation.Routes
import screens.login_feature.LoginUiEvent
import screens.login_feature.LoginUiState

var VALIDATION = 0

class ActivateComponent(
    componentContext: ComponentContext,
    val repository: Repository,
    private val navigation: (String) -> Unit,
): ComponentContext by componentContext {



    private var _uiState = MutableValue(ActivateUiState())
    val uiState: Value<ActivateUiState> = _uiState





    fun onEvent(event: ActivateUiEvent){
        when(event){
            ActivateUiEvent.ClearError -> {
                CoroutineScope(Dispatchers.IO).launch {
                    delay(2000)
                    _uiState.update { it.copy(error = null) }
                }
            }
            is ActivateUiEvent.UpdateAccountNumber -> {
                _uiState.update { it.copy(accountNumber = event.value) }
            }
            is ActivateUiEvent.UpdateConfirmPassword -> {
                _uiState.update { it.copy(confirmPassword = event.value) }
            }
            is ActivateUiEvent.UpdateEmployeeNumber -> {
                _uiState.update { it.copy(employeeNumber = event.value) }
            }
            is ActivateUiEvent.UpdateNewPassword -> {
                _uiState.update { it.copy(newPassword = event.value) }
            }
            ActivateUiEvent.ValidateForm -> {
                if(_uiState.value.employeeNumber.isEmpty()){
                    _uiState.update { it.copy(error = "Enter your employee number") }
                }else if(_uiState.value.accountNumber.isEmpty()){
                    _uiState.update { it.copy(error = "Enter your account number") }
                }
                else if(_uiState.value.newPassword.isEmpty()){
                    _uiState.update { it.copy(error = "Enter your new password") }
                }
                else if(_uiState.value.confirmPassword.isEmpty()){
                    _uiState.update { it.copy(error = "Confirm your password") }
                }
                else if(!_uiState.value.newPassword.equals(_uiState.value.confirmPassword)){
                    _uiState.update { it.copy(error = "Passwords do not match") }
                }else {

                    val detail = GovValidateAnAccountBody(
                        account_number = _uiState.value.accountNumber,
                        employee_no = _uiState.value.employeeNumber,
                        new_password = _uiState.value.newPassword,
                        new_password_confirmation = _uiState.value.confirmPassword
                    )

                    _uiState.update { it.copy(loading = true) }

                    repository.govValidateAnAccount(detail, {
                        VALIDATION = 1
                        MESSAGE = "Account Validated"
                        navigation(Routes.Login.route)
                    }) { error ->
                        _uiState.update { it.copy(error = error, loading = false) }
                    }
                }
            }

            ActivateUiEvent.Back -> {
                navigation(Routes.Back.route)
            }
        }
    }



}