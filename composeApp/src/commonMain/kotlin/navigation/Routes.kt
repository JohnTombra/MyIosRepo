package navigation

sealed class Routes(val route: String){
    object Login: Routes("login")
    object Home: Routes("home")
    object Acivate: Routes("activate")
    object PhoneCall: Routes("phone_call")
    object AllPayslip: Routes("all_payslip")
    object Payslip: Routes("payslip")
    object Notification: Routes("notification")
    object Search: Routes("search")
    object MyInfo: Routes("my_info")
    object SocialMedia: Routes("social_media")
    object ChatBot: Routes("chat_bot")
    object PrivacyPolicy: Routes("privacy_policy")
    object ChangePassword: Routes("change_password")
    object Back: Routes("back")
}
