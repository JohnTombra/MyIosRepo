package navigation



import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.pushNew
import data.repository.Repository

import kotlinx.serialization.Serializable
import screens.activate_feature.ActivateComponent
import screens.all_payslips_feature.AllPayslipsComponent
import screens.change_password_feature.ChangePasswordComponent
import screens.chatbot_feature.ChatBotComponent
import screens.home_feature.HomeScreenComponent

import screens.login_feature.LoginComponent
import screens.my_info_feature.MyInfoComponent
import screens.notification_feature.NotificationComponent
import screens.payslip_feature.PayslipComponent
import screens.phone_call_feature.PhoneCallComponent
import screens.privacy_policy.PrivacyPolicyComponent
import screens.search_feature.SearchComponent
import screens.social_media_feature.SocialMediaComponent

var MESSAGE = ""

class RootComponent(
    componentContext:ComponentContext,
): ComponentContext by componentContext{

    val repository = Repository()

    private val navigation = StackNavigation<Configuration>()
    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.LoginScreen,
        handleBackButton = true,
        childFactory = ::createChild
    )



    private fun createChild(
        config: Configuration,
        context: ComponentContext,
    ): Child {
        return when(config){


            Configuration.LoginScreen -> Child.LoginScreen(
                LoginComponent(componentContext = context, repository = repository){

                    when(it){
                        Routes.Home.route -> {
                                navigation.pushNew(Configuration.HomeScreen)
                        }
                        Routes.PrivacyPolicy.route -> {
                            navigation.pushNew(Configuration.PrivacyPolicy)
                        }
                        Routes.Acivate.route -> {
                            navigation.pushNew(Configuration.Activate)
                        }
                    }
                }
            )

            Configuration.Activate -> Child.Activate(
                ActivateComponent(componentContext = context, repository = repository){

                    when(it){
                        Routes.Login.route -> {
                                 navigation.popTo(0)
                        }
                        Routes.Back.route -> {
                            navigation.pop()
                        }
                    }
                }
            )
            Configuration.AllPayslips -> Child.AllPayslips(
                AllPayslipsComponent(componentContext = context, repository = repository){ route,prid->

                    when(route){
                        Routes.Payslip.route -> {
                            //     navigation.pop()
                                 navigation.pushNew(Configuration.Payslip(prid))
                        }
                        Routes.Back.route -> {
                            navigation.pop()
                        }
                    }
                }
            )
            Configuration.ChatBot -> Child.ChatBot(
                ChatBotComponent(componentContext = context, repository = repository){

                    when(it){
                        Routes.AllPayslip.route -> {
                            navigation.pushNew(Configuration.AllPayslips)
                        }
                        Routes.MyInfo.route -> {
                            navigation.pushNew(Configuration.MyInfo)
                        }
                        Routes.PhoneCall.route -> {
                            navigation.pushNew(Configuration.PhoneCall)
                        }
                        Routes.SocialMedia.route -> {
                            navigation.pushNew(Configuration.SocialMedia)
                        }
                        Routes.Login.route -> {
                            navigation.popTo(0)
                        }
                        Routes.Back.route -> {
                            navigation.pop()
                        }
                    }
                }
            )

            Configuration.HomeScreen -> Child.HomeScreen(
                HomeScreenComponent(componentContext = context, repository = repository){

                    when(it){
                        Routes.AllPayslip.route -> {
                            navigation.pushNew(Configuration.AllPayslips)
                        }
                        Routes.MyInfo.route -> {
                            navigation.pushNew(Configuration.MyInfo)
                        }
                        Routes.SocialMedia.route -> {
                            navigation.pushNew(Configuration.SocialMedia)
                        }
                        Routes.PhoneCall.route -> {
                            navigation.pushNew(Configuration.PhoneCall)
                        }
                        Routes.ChatBot.route -> {
                            navigation.pushNew(Configuration.ChatBot)
                        }
                        Routes.Notification.route -> {
                            navigation.pushNew(Configuration.Notification)
                        }
                        Routes.Search.route -> {
                            navigation.pushNew(Configuration.Search)
                        }

                    }
                }
            )
            Configuration.MyInfo -> Child.MyInfo(
                MyInfoComponent(componentContext = context, repository = repository){

                    when(it){
                        Routes.Login.route -> {
                            navigation.popTo(0)
                        }
                        Routes.ChangePassword.route -> {
                            navigation.pushNew(Configuration.ChangePassword)
                        }
                        Routes.Back.route -> {
                            navigation.pop()
                        }
                    }
                }
            )
            Configuration.Notification -> Child.Notification(
                NotificationComponent(componentContext = context, repository = repository){

                    when(it){
                        Routes.Home.route -> {
                            //     navigation.pop()
                            //     navigation.pushNew(Configuration.HomeScreen(""))
                        }
                        Routes.Back.route -> {
                            navigation.pop()
                        }
                    }
                }
            )
           is Configuration.Payslip -> Child.Payslip(
                PayslipComponent(prid = config.prid,componentContext = context, repository = repository){

                    when(it){
                        Routes.Home.route -> {
                            //     navigation.pop()
                            //     navigation.pushNew(Configuration.HomeScreen(""))
                        }
                        Routes.Back.route -> {
                            navigation.pop()
                        }
                    }
                }
            )
            Configuration.PhoneCall -> Child.PhoneCall(
                PhoneCallComponent(componentContext = context, repository = repository){

                    when(it){
                        Routes.Home.route -> {
                            //     navigation.pop()
                            //     navigation.pushNew(Configuration.HomeScreen(""))
                        }
                        Routes.Back.route -> {
                            navigation.pop()
                        }
                    }
                }
            )
            Configuration.Search -> Child.Search(
                SearchComponent(componentContext = context, repository = repository){

                    when(it){
                        Routes.Back.route -> {
                            navigation.pop()
                        }
                        Routes.AllPayslip.route -> {
                            navigation.pushNew(Configuration.AllPayslips)
                        }
                        Routes.MyInfo.route -> {
                            navigation.pushNew(Configuration.MyInfo)
                        }
                        Routes.SocialMedia.route -> {
                            navigation.pushNew(Configuration.SocialMedia)
                        }
                        Routes.PhoneCall.route -> {
                            navigation.pushNew(Configuration.PhoneCall)
                        }
                        Routes.ChatBot.route -> {
                            navigation.pushNew(Configuration.ChatBot)
                        }
                        Routes.Notification.route -> {
                            navigation.pushNew(Configuration.Notification)
                        }
                        Routes.Login.route -> {
                            navigation.popTo(0)
                        }
                        Routes.PrivacyPolicy.route -> {
                            navigation.pushNew(Configuration.PrivacyPolicy)
                        }

                    }
                }
            )
            Configuration.SocialMedia ->Child.SocialMedia(
                SocialMediaComponent(componentContext = context, repository = repository){

                    when(it){
                        Routes.Home.route -> {
                            //     navigation.pop()
                            //     navigation.pushNew(Configuration.HomeScreen(""))
                        }
                        Routes.Back.route -> {
                            navigation.pop()
                        }
                    }
                }
            )

            Configuration.PrivacyPolicy ->Child.PrivacyPolicy(
                PrivacyPolicyComponent(componentContext = context, repository = repository){
                    when(it){
                        Routes.Back.route -> {
                            navigation.pop()
                        }
                    }
                }
            )

            Configuration.ChangePassword ->Child.ChangePassword(
               ChangePasswordComponent(componentContext = context, repository = repository){
                    when(it){
                        Routes.Back.route -> {
                            navigation.pop()
                        }
                        Routes.Login.route -> {
                            navigation.popTo(0)
                        }
                    }
                }
            )
        }
    }



    sealed class Child {
        data class LoginScreen(val component: LoginComponent): Child()
        data class HomeScreen(val component: HomeScreenComponent): Child()
        data class AllPayslips(val component: AllPayslipsComponent): Child()
        data class Payslip(val component: PayslipComponent): Child()
        data class MyInfo(val component: MyInfoComponent): Child()
        data class Search(val component: SearchComponent): Child()
        data class Notification(val component: NotificationComponent): Child()
        data class SocialMedia(val component: SocialMediaComponent): Child()
        data class PhoneCall(val component: PhoneCallComponent): Child()
        data class ChatBot(val component: ChatBotComponent): Child()
        data class Activate(val component: ActivateComponent): Child()
        data class PrivacyPolicy(val component: PrivacyPolicyComponent): Child()
        data class ChangePassword(val component: ChangePasswordComponent): Child()
    }



    @Serializable
    sealed class Configuration{
        @Serializable
        data object LoginScreen: Configuration()
        @Serializable
        data object HomeScreen: Configuration()
        @Serializable
        data object AllPayslips: Configuration()
        @Serializable
        data class Payslip(val prid: Int): Configuration()
        @Serializable
        data object MyInfo: Configuration()
        @Serializable
        data object Search: Configuration()
        @Serializable
        data object Notification: Configuration()
        @Serializable
        data object SocialMedia: Configuration()
        @Serializable
        data object PhoneCall: Configuration()
        @Serializable
        data object ChatBot: Configuration()
        @Serializable
        data object Activate: Configuration()
        @Serializable
        data object PrivacyPolicy: Configuration()
        @Serializable
        data object ChangePassword: Configuration()
    }





}