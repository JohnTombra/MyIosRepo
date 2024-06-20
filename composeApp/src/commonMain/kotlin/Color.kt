import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val mainColor = Color(0xFF89C16F) ///val mainColor = Color(0xFF254acd)
val mainColor2 = Color(0xFF84E9C4)
val textColorDark = Color(0xFF343434)

val errorColor = Color(0xFFFC6C85)
val lightProfileStrips = Color(0xFFF4F4F4)

val applicationColor1 =Color(0xFF343434)
val applicationColor2 =Color(0xFFBABABA)

val payslipTopTextColor =Color(0xFF535353)
val payslipHeaderColor =Color(0xFF9E9E9E)

val homeTextHead = Color(0xFF343434)
val homeTextHead2 = Color(0xFF828282)

val zigzag= Color(0xFF999999)

val homeBg = Color(0xFFF8F8F8)

val circles = Color(0xFFC3DEB6)

val serviceColor = Color(0xFFeeeeee)


val textColorLight = Color(0xFFBBBBBB)
val textColorLight1 = Color(0xFF999999)
val textColorLight2 = Color(0xFF555555)
val textColorLight3 = Color(0xFFC6C6C6)
val textColorLight4 = Color(0xFFD3D3D3)

val backgroundColor = Color(0xFFF5F5F5)

val backgroundColor2 = Color(0xFFF1F1F1)




@Composable
fun ErrorMessage(modifier: Modifier = Modifier, text: String?, clear: ()->Unit = {}) {


    AnimatedVisibility(
        visible = text != null,
        enter = slideInVertically(
            initialOffsetY = {-it}
        ) + EnterTransition.None,
        exit = slideOutVertically(
            targetOffsetY = {-it}
        ) + ExitTransition.None
    ){

        Box(modifier = modifier.fillMaxWidth().height(110.dp).padding(start = 13.dp, end = 13.dp, top = 26.dp).clip(
            RoundedCornerShape(15.dp)
        ).background(
            errorColor
        )){


            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = null,
                tint = Color.White,
                modifier = modifier
                    .size(95.dp).align(Alignment.CenterStart).alpha(0.2f)
            )

            Text(text ?: "",fontSize = 13.sp,fontWeight = FontWeight.Bold, color = Color.White, textAlign = TextAlign.Center, modifier = modifier.align(
                Alignment.Center))






        }

    }
    if(text!=null){
        clear()}
}