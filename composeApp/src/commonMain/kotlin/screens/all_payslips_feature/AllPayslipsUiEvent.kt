package screens.all_payslips_feature

import screens.activate_feature.ActivateUiEvent

sealed class AllPayslipsUiEvent {

    data object ClearError: AllPayslipsUiEvent()


    data class UpdateMonth(val value: String) : AllPayslipsUiEvent()

    data class UpdateYear(val value: String) : AllPayslipsUiEvent()

    data class UpdateStartYear(val value: String) : AllPayslipsUiEvent()

    data class Navigate(val value: Int) : AllPayslipsUiEvent()

    data object Search: AllPayslipsUiEvent()

    data object Back: AllPayslipsUiEvent()
}