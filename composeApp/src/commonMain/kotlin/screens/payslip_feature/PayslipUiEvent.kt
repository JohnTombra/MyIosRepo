package screens.payslip_feature

import screens.activate_feature.ActivateUiEvent

sealed class PayslipUiEvent {

    data object ClearError: PayslipUiEvent()

    data object ClearMessage: PayslipUiEvent()

    data object Download: PayslipUiEvent()

    data object Back: PayslipUiEvent()

}