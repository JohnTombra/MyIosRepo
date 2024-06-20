import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.RootComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import screens.activate_feature.ActivateScreenComposable
import screens.all_payslips_feature.AllPayslipsScreenComposable
import screens.change_password_feature.ChangePasswordComposable
import screens.chatbot_feature.ChatBotScreenComposable
import screens.home_feature.HomeScreenComposable
import screens.login_feature.LoginScreenComposable
import screens.my_info_feature.MyInfoScreenComposable
import screens.notification_feature.NotificationScreenComposable
import screens.payslip_feature.PayslipScreenComposable
import screens.phone_call_feature.PhoneCallScreenComposable
import screens.privacy_policy.PrivacyPolicyComposable
import screens.search_feature.SearchScreenComposable
import screens.social_media_feature.SocialMediaScreenComposable

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(root: RootComponent) {
    MaterialTheme {




        val childStack by root.childStack.subscribeAsState()



        Children(
            stack = childStack,
            animation = stackAnimation(slide())
        ) { child ->
            when (val instance = child.instance) {
                is RootComponent.Child.PrivacyPolicy -> {
                    val component = instance.component
                    val uiState = component.uiState.subscribeAsState()
                    PrivacyPolicyComposable(uiState, component::onEvent)
                }

                is RootComponent.Child.LoginScreen -> {
                    val component = instance.component
                    val uiState = component.uiState.subscribeAsState()
                    LoginScreenComposable(uiState, component::onEvent)
                }

                is RootComponent.Child.ChangePassword -> {
                    val component = instance.component
                    val uiState = component.uiState.subscribeAsState()
                    ChangePasswordComposable(uiState, component::onEvent)
                }

                is RootComponent.Child.Activate -> {
                    val component = instance.component
                    val uiState = component.uiState.subscribeAsState()
                    ActivateScreenComposable(uiState, component::onEvent)
                }
                is RootComponent.Child.AllPayslips -> {
                    val component = instance.component
                    val uiState = component.uiState.subscribeAsState()
                    AllPayslipsScreenComposable(uiState, component::onEvent)
                }
                is RootComponent.Child.ChatBot -> {
                    val component = instance.component
                    val uiState = component.uiState.subscribeAsState()
                    ChatBotScreenComposable(uiState, component::onEvent)
                }
                is RootComponent.Child.HomeScreen -> {
                    val component = instance.component
                    val uiState = component.uiState.subscribeAsState()
                    HomeScreenComposable(uiState, component::onEvent)
                }
                is RootComponent.Child.MyInfo -> {
                    val component = instance.component
                    val uiState = component.uiState.subscribeAsState()
                    MyInfoScreenComposable(uiState, component::onEvent)
                }
                is RootComponent.Child.Notification -> {
                    val component = instance.component
                    val uiState = component.uiState.subscribeAsState()
                    NotificationScreenComposable(uiState, component::onEvent)
                }
                is RootComponent.Child.Payslip -> {
                    val component = instance.component
                    val uiState = component.uiState.subscribeAsState()
                    PayslipScreenComposable(uiState, component::onEvent)
                }
                is RootComponent.Child.PhoneCall -> {
                    val component = instance.component
                    val uiState = component.uiState.subscribeAsState()
                    PhoneCallScreenComposable(uiState, component::onEvent)
                }
                is RootComponent.Child.Search -> {
                    val component = instance.component
                    val uiState = component.uiState.subscribeAsState()
                    SearchScreenComposable(uiState, component::onEvent)
                }
                is RootComponent.Child.SocialMedia -> {
                    val component = instance.component
                    val uiState = component.uiState.subscribeAsState()
                    SocialMediaScreenComposable(uiState, component::onEvent)
                }
            }

        }




//        var showContent by remember { mutableStateOf(false) }
//        val greeting = remember { Greeting().greet() }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource("myxml.xml"), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
    }
}