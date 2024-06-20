package com.jetbrains.kmpapp.multiple

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import com.novaapps.rupeepaymultiplatform.MAIN_CONTEXT
import java.util.Calendar

actual fun getMonthAndYear(): String {
    var monthList = listOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")

    val calender = Calendar.getInstance()

    val mainMonth = monthList[calender.get(Calendar.MONTH)]
    val mainYear = calender.get(Calendar.YEAR).toString()

    return "$mainMonth,$mainYear"
}

actual fun timestamp(): String {
    return System.currentTimeMillis().toString()
}

//
//actual fun saveViewAsPdf(view: Any, fileName: String, completion:(Boolean)->Unit): Unit {
//
//}
//
//
//
actual fun dialer(number: String) {

    val intent = Intent(Intent.ACTION_DIAL)
    intent.setData(Uri.parse("tel:$number"))
    MAIN_CONTEXT!!.startActivity(intent)

}


actual fun whatsapp(number: String): Unit{

}


actual fun facebook(pageId: String): Unit {

}


actual fun instagram(pageId: String): Unit {

}

actual fun twitter(pageId: String): Unit {

}


//actual class ImagePicker {
//    actual fun pickImage(completion: (String?, ByteArray?) -> Unit){
//
//
//
//
//
//    }
//}
//
//
//
//@Composable
//actual fun rememberBitmapFromString(modifier: Modifier,callback: ()->Unit, byteArray: ByteArray?) {
//
//    //convert to base 64 and use
//    byteArray?.let {
//    val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
//
//    Image(
//        bitmap = bitmap!!.asImageBitmap(),
//        contentDescription = "Photo",
//        modifier = modifier.fillMaxSize(),
//        contentScale = ContentScale.Crop,
//    )
//    }
//}
//
//actual fun base64ToByteArray(str: String): ByteArray?{
//    return TODO()
//}