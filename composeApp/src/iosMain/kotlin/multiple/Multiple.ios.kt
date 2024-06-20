package com.jetbrains.kmpapp.multiple

//import GLOBAL_VIEW_CONTROLLER
import GLOBAL_VIEW_CONTROLLER
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.layout.ContentScale
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.COpaquePointerVar
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.usePinned
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.jetbrains.skia.Image
import platform.CoreGraphics.CGRectMake


import platform.Foundation.NSCalendar
import platform.Foundation.NSCalendarUnitMonth
import platform.Foundation.NSCalendarUnitYear
import platform.Foundation.NSData
import platform.Foundation.NSDataBase64EncodingOptions
import platform.Foundation.NSDataWritingAtomic
import platform.Foundation.NSDate
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSLocale
import platform.Foundation.NSMutableData
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSSelectorFromString
import platform.Foundation.NSURL
import platform.Foundation.NSURLSessionConfiguration
import platform.Foundation.NSUserDomainMask
import platform.Foundation.base64EncodedStringWithOptions
import platform.Foundation.create
import platform.Foundation.currentLocale
import platform.Foundation.getBytes
import platform.Foundation.timeIntervalSince1970
import platform.Foundation.writeToFile
import platform.UIKit.UIAlertAction
import platform.Foundation.*
import platform.UIKit.UIAlertActionStyle
import platform.UIKit.UIAlertActionStyleCancel
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyle
import platform.UIKit.UIAlertControllerStyleActionSheet
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIApplication
import platform.UIKit.UIControlEventValueChanged
import platform.UIKit.UIDatePicker
import platform.UIKit.UIDatePickerMode
import platform.UIKit.UIDocumentInteractionController
import platform.UIKit.UIGraphicsBeginImageContextWithOptions
import platform.UIKit.UIGraphicsBeginPDFContextToData
import platform.UIKit.UIGraphicsBeginPDFPage
import platform.UIKit.UIGraphicsEndImageContext
import platform.UIKit.UIGraphicsEndPDFContext
import platform.UIKit.UIGraphicsGetCurrentContext
import platform.UIKit.UIGraphicsGetImageFromCurrentImageContext
import platform.UIKit.UIImage
import platform.UIKit.UIImagePNGRepresentation
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerDelegateProtocol
import platform.UIKit.UIImagePickerControllerOriginalImage
import platform.UIKit.UIImagePickerControllerSourceType
import platform.UIKit.UINavigationControllerDelegateProtocol
import platform.UIKit.UIScreen
import platform.UIKit.UIView
import platform.UIKit.UIViewController
import platform.darwin.NSObject
import kotlin.experimental.ExperimentalNativeApi
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.native.ref.WeakReference

actual fun getMonthAndYear(): String {

    var monthList = listOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")

    val currentDate = NSDate()
    val calendar = NSCalendar.currentCalendar
    val _month = calendar.components(NSCalendarUnitMonth, fromDate = currentDate).month
    val month = monthList[_month.toInt()-1]
    val year = calendar.components(NSCalendarUnitYear, fromDate = currentDate).year.toInt()

    return "$month,$year"
}

actual fun timestamp(): String {
    return (NSDate().timeIntervalSince1970 * 1000).toLong().toString()
}






actual fun dialer(number: String) {

//    CoroutineScope(Dispatchers.Main).launch {
//        saveByteArrayAsPDF("payslip1")
//    }


    val url = NSURL(string = "tel://$number")
    UIApplication.sharedApplication.openURL(url)


}


actual fun whatsapp(number: String): Unit {
    try {
        val whatsappURL = "https://wa.me/$number"
        UIApplication.sharedApplication.openURL(NSURL.URLWithString(whatsappURL)!!)
    }catch (e: Exception){

    }
}


actual fun facebook(pageId: String): Unit {
    try {
        val facebookURL = "fb:/page/$pageId"
        UIApplication.sharedApplication.openURL(NSURL.URLWithString(facebookURL)!!)
    }catch (e: Exception){

    }
}


actual fun instagram(pageId: String): Unit {

    try {
        val instagramURL = "instagram://user?username=$pageId"
        UIApplication.sharedApplication.openURL(NSURL.URLWithString(instagramURL)!!)
    }catch (e: Exception){


        try{
            val instagramURL = "https://www.instagram.com/smartappsit/"
            UIApplication.sharedApplication.openURL(NSURL.URLWithString(instagramURL)!!)
        }catch (e: Exception){

        }


    }


}

actual fun twitter(pageId: String): Unit {

    try {
    val twitterURL = "twitter://user?screen_name=$pageId"
    UIApplication.sharedApplication.openURL(NSURL.URLWithString(pageId)!!)
}catch (e: Exception){

}
}

fun convertHTMLtoPDF(html: String){



}


@OptIn(ExperimentalForeignApi::class)
fun saveByteArrayAsPDF(/*byteArray: ByteArray, */fileName: String){

    val byteArray = byteArrayOf()

    val data = memScoped {
        byteArray.usePinned { pinned ->
            NSData.create(
                bytes = pinned.addressOf(0).reinterpret<COpaquePointerVar>(),
                length = byteArray.size.toULong()
            )
        }
    }


    val documentPath = NSSearchPathForDirectoriesInDomains(
        NSDocumentDirectory,
        NSUserDomainMask,
        true
    ).firstOrNull()




    documentPath?.let {

        val filePath = "$it/$fileName.pdf"

        data.writeToFile(filePath, true)


        val fileURL = NSURL.fileURLWithPath(filePath)

        val documentController = UIDocumentInteractionController.interactionControllerWithURL(fileURL)

        documentController.UTI = "com.adobe.pdf"

        documentController.presentOptionsMenuFromRect(CGRectMake(0.0,0.0,0.0,0.0),  GLOBAL_VIEW_CONTROLLER!!.view,true)


    } ?: run {
        println("Documents directory not found")
    }




}


//
//
//
//@OptIn(ExperimentalForeignApi::class)
//actual fun saveViewAsPdf(view: Any, fileName: String, completion:(Boolean)->Unit): Unit {
//
//
//
//
//
//}
//
//
//class DatePicker{
//
//    @OptIn(ExperimentalForeignApi::class)
//    fun showDatePicker(viewController: UIViewController){
//        val alertController = UIAlertController.alertControllerWithTitle(
//            title = null,
//            message = null,
//            preferredStyle = UIAlertControllerStyleActionSheet
//        )
//
//        val datePicker = UIDatePicker().apply {
//            this.locale = NSLocale.currentLocale
//            this.datePickerMode = UIDatePickerMode.UIDatePickerModeDate
//            this.addTarget(this@DatePicker, NSSelectorFromString("datePickerValueChanged:"), UIControlEventValueChanged)
//        }
//
//        alertController.view.addSubview(datePicker)
//
//        alertController.addAction(
//            UIAlertAction.actionWithTitle(
//                title = "Cancel",
//                style = UIAlertActionStyleCancel,
//                handler = null
//                //okay, how do i get a hard copy, my bank needs it
//            )
//
//        )
//
//        viewController.presentViewController(alertController, true, null)
//
//    }
//
//
//}
//
//
//
//actual fun timestamp(): String {
//  return (NSDate().timeIntervalSince1970 * 1000).toLong().toString()
//}
//
//
//
//fun UIImage.toBase64(): String?{
//
//    val imageData:NSData = UIImagePNGRepresentation(this) ?: return null
//    val base64String =  imageData?.base64EncodedStringWithOptions(NSDataBase64EncodingOptions.MIN_VALUE)
//    return base64String
//
//}
//
//
//
//
//actual class ImagePicker{
//
//    private val picker = UIImagePickerController()
//
//   actual fun pickImage(completion: (String?, ByteArray?) -> Unit){
//
//        picker.sourceType = UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypePhotoLibrary
//        picker.allowsEditing = false
//        picker.delegate = object: UIImagePickerControllerDelegateProtocol,
//            UINavigationControllerDelegateProtocol, NSObject() {
//
//            override fun imagePickerController(
//                picker: UIImagePickerController,
//                didFinishPickingMediaWithInfo: Map<Any?, *>
//            ) {
//                val image = didFinishPickingMediaWithInfo[UIImagePickerControllerOriginalImage] as? UIImage
//              image?.let {
//
//                  getImagesAsStringAndByteArray(image.toBase64()!!){a,b->
//                      completion(a,b)
//                  }
//
//                  picker.dismissViewControllerAnimated(true, null)
//              }
//
//            }
//
//            override fun imagePickerControllerDidCancel(picker: UIImagePickerController) {
//                completion(null, null)
//                picker.dismissViewControllerAnimated(true, null)
//            }
//
//        }
//
//        GLOBAL_VIEW_CONTROLLER!!.presentViewController(picker, true, null)
//
//
//    }
//
//
//}
//
//
//
//@OptIn(ExperimentalEncodingApi::class)
//public fun getImagesAsStringAndByteArray(image: String, completion: (String?, ByteArray?)->Unit){
//    val byteArray = Base64.Default.decode(image)
//    println("conversion complete $byteArray")
//    completion(image, byteArray)
//}
//
//
//
//
//@Composable
//actual fun rememberBitmapFromString(modifier: Modifier,callback: ()->Unit, byteArray: ByteArray?){
//
//    if(byteArray != null) {
//
//
//        println("conversion remember $byteArray")
//
//
//        val bitmap: ImageBitmap = Image.makeFromEncoded(byteArray).toComposeImageBitmap()
//
//
//        Image(
//            bitmap = bitmap,
//            contentDescription = "Photo",
//            modifier = modifier.fillMaxSize().clickable {
//                                                        callback()
//            },
//            contentScale = ContentScale.Crop,
//        )
//    }else{
//        Icon(
//            imageVector = Icons.Default.Add,
//            contentDescription = "Photo",
//            modifier = modifier.fillMaxSize().clickable {
//                callback()
//            }
//        )
//    }
//}
//
//
//
//@OptIn(ExperimentalEncodingApi::class)
//actual fun base64ToByteArray(str: String): ByteArray?{
//    return Base64.Default.decode(str)
//}
//
//
////fun savePdf(bitmap: ImageBitmap, filename: String): String?{
////
////
////    val uiImage = bitmap.config.
////
////}
//
////
////fun openImageSelector(callback: (String)->Unit){
////
////    val delegate = object : UIImagePickerControllerDelegateProtocol, NSObject(){
////        override fun imagePickerController(
////            picker: UIImagePickerController,
////            didFinishPickingMediaWithInfo: Map<Any?, *>
////        ){
////            val image = didFinishPickingMediaWithInfo[UIImagePickerControllerOriginalImage] as? UIImage
////            image?.let {
////
////           callback(image.toBase64()!!)
////
////            }
////
////
////        }
////
////    }
////
////
////    val imagePickerController = UIImagePickerController().apply {
////        sourceType = UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypePhotoLibrary
////        this.delegate = delegate
////    }
////
////    GLOBAL_VIEW_CONTROLLER!!.presentViewController(imagePickerController, true, null)
////
////
////}
////
////@OptIn(ExperimentalForeignApi::class)
////fun NSData.toByteArray(): ByteArray{
////    val length = this.length.toInt()
////    val buffer = ByteArray(length)
////    this.get
////    return buffer
////}
//
//
//
//
//
//
//
//
//
