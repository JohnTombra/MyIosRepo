package screens.payslip_feature

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


class PayslipComponent(
    val prid: Int,
    componentContext: ComponentContext,
    val repository: Repository,
    private val navigation: (String) -> Unit,
): ComponentContext by componentContext {


    private var _uiState = MutableValue(PayslipUiState())
    val uiState: Value<PayslipUiState> = _uiState



    init{

        _uiState.update { it.copy(loading = true) }
        println("MYPRINT 0:")
        repository.getSinglePayslip(prid,{ payslip->


            println("MYPRINT 1: $payslip")

            repository.getMyInfo({myInfo ->

                println("MYPRINT 2: $payslip")

                if(myInfo == null || payslip == null){
                    _uiState.update { it.copy(error = "Incorrect data $myInfo..$payslip", loading = false) }
                }else {
                    _uiState.update {
                        it.copy(
                            payslip = payslip.data,
                            myInfo = myInfo.data,
                            loading = false
                        )
                    }
                }

            }){error->
                _uiState.update { it.copy(error = error, loading = false) }
            }




        }){ error->
            _uiState.update { it.copy(error = error, loading = false) }
        }
    }




    fun onEvent(event: PayslipUiEvent){

        when(event){
            PayslipUiEvent.ClearError -> {
                CoroutineScope(Dispatchers.Default).launch {
                    delay(3500)
                    _uiState.update { it.copy(error = null) }
                }
            }
            PayslipUiEvent.ClearMessage -> {
                CoroutineScope(Dispatchers.Default).launch {
                    delay(3500)
                    _uiState.update { it.copy(message = null) }
                }
            }
            is PayslipUiEvent.Download -> {
                _uiState.update { it.copy(message = "Payslip Downloaded") }
            }
            PayslipUiEvent.Back -> {
                navigation(Routes.Back.route)
            }
        }


    }


}