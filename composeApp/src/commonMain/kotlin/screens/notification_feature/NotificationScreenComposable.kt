package screens.notification_feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import textColorDark
import androidx.compose.material.Text
import screens.social_media_feature.SocialMediaUiEvent

@OptIn(ExperimentalResourceApi::class)
@Composable
fun NotificationScreenComposable(uiState: State<NotificationUiState>,
                          onEvent: (NotificationUiEvent) -> Unit = {},
                          modifier: Modifier = Modifier)  {

    Box(modifier = modifier.fillMaxSize()) {

        Row(modifier = modifier.padding(top = 15.dp, start = 10.dp,end = 10.dp).clickable {
            onEvent(NotificationUiEvent.Back)
        }, verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource("round_arrow_back_ios_new_24.xml"),modifier = modifier.size(14.dp), contentDescription = null)
            Spacer(modifier = modifier.width(10.dp))
            Text(text = "Notifications", modifier = modifier.weight(1f), fontSize = 15.sp, fontWeight = FontWeight.Bold)
        }



        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.align(Alignment.Center)
        ) {
            Image(
                painter = painterResource("baseline_satellite_alt_24.xml"),
                contentDescription = null,
                modifier = modifier.size(60.dp)
            )
            Spacer(modifier = modifier.height(20.dp))
            Text(
                text = "No notification",
                fontSize = 12.5.sp,
                color = textColorDark
            )
        }


    }

}