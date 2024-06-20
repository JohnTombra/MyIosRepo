package screens.social_media_feature

import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetbrains.kmpapp.multiple.facebook
import com.jetbrains.kmpapp.multiple.instagram
import com.jetbrains.kmpapp.multiple.twitter
import com.jetbrains.kmpapp.multiple.whatsapp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import textColorDark
import textColorLight


@OptIn(ExperimentalResourceApi::class)
@Composable
fun SocialMediaScreenComposable(uiState: State<SocialMediaUiState>,
                          onEvent: (SocialMediaUiEvent) -> Unit = {},
                          modifier: Modifier = Modifier)  {

    Column {

        Row(modifier = modifier.padding(top = 15.dp, start = 10.dp,end = 10.dp).clickable {
                                                                                          onEvent(SocialMediaUiEvent.Back)
        }, verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource("round_arrow_back_ios_new_24.xml"),modifier = modifier.size(14.dp), contentDescription = null)
            Spacer(modifier = modifier.width(10.dp))
            Text(text = "Social media", modifier = modifier.weight(1f), fontSize = 15.sp, fontWeight = FontWeight.Bold)
        }


        Text(
            "Contact us via our social media pages for help, information and tips on how to use this mobile app",
            fontSize = 12.sp,
            modifier = modifier.padding(top = 10.dp, start = 10.dp),
            color = textColorLight
        )

        Spacer(modifier = modifier.height(40.dp))

        Row(modifier = modifier.padding(start = 10.dp)){

            Image(painter = painterResource("whatsapp.xml"), contentDescription = null, contentScale = ContentScale.FillBounds, modifier = modifier.size(30.dp).clip(
                CircleShape
            ).clickable {
                whatsapp("+2348100666308")
            })

            Spacer(modifier = modifier.width(15.dp))

            Image(painter = painterResource("facebook.xml"),contentScale = ContentScale.FillBounds, contentDescription = null, modifier = modifier.size(30.dp).clip(
                CircleShape
            ).clickable {
                facebook("SmartAppsIT?mibextid=LQQJ4d")
            })

            Spacer(modifier = modifier.width(15.dp))

            Image(painter = painterResource("instagram.xml"),contentScale = ContentScale.FillBounds, contentDescription = null, modifier = modifier.size(30.dp).clip(
                CircleShape
            ).clickable {
                instagram("smartappsit?igsh=MTJzOTYwMGw5MjR1ZA==")
            })

            Spacer(modifier = modifier.width(15.dp))

            Image(painter = painterResource("x.xml"), contentScale = ContentScale.FillBounds,contentDescription = null, modifier = modifier.size(30.dp).clip(
                CircleShape
            ).clickable {
                twitter("https://x.com/smartapps_i?s=11&t=aus9ExeDRJdlECbWR3YsGw")
            })

        }





    }

}