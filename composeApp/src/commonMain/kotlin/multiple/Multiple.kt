package com.jetbrains.kmpapp.multiple

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

expect fun getMonthAndYear():String

expect fun timestamp(): String

//
//
//expect fun saveViewAsPdf(view: Any, fileName: String, completion:(Boolean)->Unit): Unit
//
//
expect fun dialer(number: String): Unit

expect fun whatsapp(number: String): Unit

expect fun facebook(pageId: String): Unit

expect fun instagram(pageId: String): Unit

expect fun twitter(pageId: String): Unit
//
//expect fun timestamp(): String
//
//expect class ImagePicker(){
//    fun pickImage(completion: (String?, ByteArray?) -> Unit)
//}
//
//
//@Composable
//expect fun rememberBitmapFromString(modifier: Modifier,callback: ()->Unit, byteArray: ByteArray?)
//
//
//expect fun base64ToByteArray(str: String): ByteArray?