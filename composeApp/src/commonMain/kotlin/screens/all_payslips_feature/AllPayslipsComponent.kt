package screens.all_payslips_feature

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import com.jetbrains.kmpapp.multiple.getMonthAndYear
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


class AllPayslipsComponent(
    componentContext: ComponentContext,
    val repository: Repository,
    private val navigation: (String, Int) -> Unit,
): ComponentContext by componentContext {

    private var _uiState = MutableValue(AllPayslipsUiState())
    val uiState: Value<AllPayslipsUiState> = _uiState




    init {

        _uiState.update { it.copy(loading = true) }

        var monthList = listOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")


        var yearList = listOf("2020","2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032","Other")



        _uiState.update {
            it.copy(
                months = monthList,
                years = yearList
            )
        }


        val month = getMonthAndYear().split(",")[0]
        val year = getMonthAndYear().split(",")[1]

        _uiState.update { it.copy(month = month, year = year, startYear = "2020") }

        _uiState.update { it.copy(loading = true) }
        repository.getAllPayslips("2020",month, year, { payslips ->
            _uiState.update { it.copy(payslips = payslips.data.data, loading = false) }
        }) { error ->
            _uiState.update { it.copy(error = error, loading = false) }
        }


    }




    fun onEvent(event: AllPayslipsUiEvent){


        when(event){
            AllPayslipsUiEvent.ClearError -> {
                CoroutineScope(Dispatchers.Default).launch {
                    delay(3500)
                    _uiState.update { it.copy(error = null) }
                }
            }
            AllPayslipsUiEvent.Search -> {
                if (_uiState.value.startYear == "Year") {
                    _uiState.update { it.copy(error = "Select start year") }
                }
                else if (_uiState.value.year == "Year") {
                    _uiState.update { it.copy(error = "Select end year") }
                }
                else if (_uiState.value.month == "Month") {
                    _uiState.update { it.copy(error = "Select month") }
                } else {
                    _uiState.update { it.copy(loading = true) }
                    repository.getAllPayslips( _uiState.value.startYear,_uiState.value.month, _uiState.value.year, { payslips ->
                        _uiState.update { it.copy(payslips = payslips.data.data, loading = false) }
                    }) { error ->
                        _uiState.update { it.copy(error = error, loading = false) }
                    }

                }
            }
            is AllPayslipsUiEvent.UpdateMonth -> {
                _uiState.update { it.copy(month = event.value) }
            }
            is AllPayslipsUiEvent.UpdateStartYear -> {
                _uiState.update { it.copy(startYear = event.value) }
            }
            is AllPayslipsUiEvent.UpdateYear -> {
                _uiState.update { it.copy(year = event.value) }
            }

            is AllPayslipsUiEvent.Navigate -> {
                navigation(Routes.Payslip.route,event.value)
            }
            AllPayslipsUiEvent.Back -> {
                navigation(Routes.Back.route,0)
            }
        }

    }





}