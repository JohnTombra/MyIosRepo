package screens.phone_call_feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import androidx.compose.material.Card
import androidx.compose.material.Text
import com.jetbrains.kmpapp.multiple.dialer
import mainColor
import org.jetbrains.compose.resources.painterResource
import screens.social_media_feature.SocialMediaUiEvent
import textColorDark
import textColorLight


@OptIn(ExperimentalResourceApi::class)
@Composable
fun PhoneCallScreenComposable(uiState: State<PhoneCallUiState>,
                          onEvent: (PhoneCallUiEvent) -> Unit = {},
                          modifier: Modifier = Modifier)  {

    Column {

        Row(modifier = modifier.padding(top = 15.dp, start = 10.dp,end = 10.dp).clickable {
            onEvent(PhoneCallUiEvent.Back)
        }, verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource("round_arrow_back_ios_new_24.xml"),modifier = modifier.size(14.dp), contentDescription = null)
            Spacer(modifier = modifier.width(10.dp))
            Text(text = "Phone call", modifier = modifier.weight(1f), fontSize = 15.sp, fontWeight = FontWeight.Bold)
        }

        Text(
            "Contact us via phone call for help, information and tips on how to use this mobile app",
            fontSize = 12.sp,
            modifier = modifier.padding(top = 10.dp, start = 10.dp),
            color = textColorLight
        )

        Spacer(modifier = modifier.height(30.dp))



        Box(modifier = modifier
            .padding(start = 10.dp)
            .height(50.dp)
            .width(180.dp)
            .clip(RoundedCornerShape(5.dp)).background(mainColor).clickable {
                dialer("+2348100666308")
            }, contentAlignment = Alignment.Center){

            Row{
                Text(text ="Call support now", color = Color.White, fontSize = 14.sp)
                Spacer(modifier = modifier.size(13.dp))
              Image(painter = painterResource("baseline_phone_enabled_24.xml"), contentDescription = null)
            }

        }







    }

}