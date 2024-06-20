package com.novaapps.rupeepaymultiplatform

import App
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.retainedComponent
import navigation.RootComponent
var MAIN_CONTEXT: Context? = null
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = retainedComponent {
            RootComponent(it)

        }
        MAIN_CONTEXT = this
        Log.d("MYLOG","LOG WELCOME")
        setContent {
            App(root)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
  //  App()
}