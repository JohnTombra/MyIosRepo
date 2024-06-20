import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import navigation.RootComponent
import platform.UIKit.UIViewController

var GLOBAL_VIEW_CONTROLLER: UIViewController? = null

fun MainViewController(): UIViewController {




    val vc = ComposeUIViewController {

        val root = remember {
            RootComponent(DefaultComponentContext(LifecycleRegistry()))
        }



        App(root)



    }




    GLOBAL_VIEW_CONTROLLER = vc


    return vc
}