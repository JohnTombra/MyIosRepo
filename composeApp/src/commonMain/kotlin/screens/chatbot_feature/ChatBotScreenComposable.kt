package screens.chatbot_feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import backgroundColor
import mainColor
import org.jetbrains.compose.resources.painterResource
import screens.social_media_feature.SocialMediaUiEvent
import textColorDark
import textColorLight

@OptIn(ExperimentalResourceApi::class, ExperimentalComposeUiApi::class)
@Composable
fun ChatBotScreenComposable(uiState: State<ChatBotUiState>,
                            onEvent: (ChatBotUiEvent) -> Unit = {},
                            modifier: Modifier = Modifier)  {

    val keyboardController = LocalSoftwareKeyboardController.current

    Box(modifier = modifier.fillMaxSize().background(backgroundColor)){

        Column(modifier = modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(start = 10.dp, top = 10.dp).clickable {
                    onEvent(ChatBotUiEvent.Back)
                }
            ) {

                Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.clickable {
                    onEvent(ChatBotUiEvent.Back)
                }) {
                    Image(painter = painterResource("round_arrow_back_ios_new_24.xml"),modifier = modifier.size(14.dp), contentDescription = null)
                    Spacer(modifier = modifier.width(10.dp))
                    Box(
                        modifier = modifier
                            .size(35.dp)
                            .clip(
                                CircleShape
                            )
                            .background(mainColor), contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource("baseline_person_24.xml"),
                            contentScale = ContentScale.FillBounds,
                            contentDescription = null,
                            modifier = modifier.size(20.dp)
                        )
                    } }


                Spacer(modifier = modifier.width(10.dp))

                Text(
                    "Smart-Bot",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColorDark
                )
            }

            Spacer(modifier = modifier.height(10.dp))

            Box(modifier = modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)) {

            }
        }




        val scrollState = rememberLazyListState()
        var items: List<Message> = uiState.value.messages

        LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp), modifier = modifier.padding(top = 90.dp, start = 10.dp, end = 10.dp, bottom = 50.dp), state = scrollState) {
            itemsIndexed(uiState.value.messages) { index, s ->
                if (s.sender == "Me") {
                    ChatRight(text = s.message)
                }else{
                    ChatLeft(text = s.message)
                }
                if(index == items.size -1){
                    Spacer(modifier = modifier.height(30.dp))
                }
            }
        }

      //  Spacer(modifier = modifier.height(50.dp))


        if(uiState.value.scrollDown){
            LaunchedEffect(Unit){
            scrollState.animateScrollToItem(items.size - 1)
            onEvent(ChatBotUiEvent.ClearScroll)
        }
        }







        Column(modifier = modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)){

            Box(modifier = modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)){}


            Row(verticalAlignment = Alignment.CenterVertically, modifier  = modifier.fillMaxWidth().background(
                Color.White)){

                TextField(value = uiState.value.message,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        unfocusedIndicatorColor = Color.White,
                        focusedIndicatorColor = Color.White,
                        cursorColor = mainColor
                    ),

                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {
                        keyboardController?.hide()
                    }),

                    placeholder = {
                        Text("Type a message")
                    },
                    onValueChange = {
                                    onEvent(ChatBotUiEvent.UpdateMessage(it))
                    }, modifier = modifier.weight(1f))

                Spacer(modifier = modifier.width(10.dp))

                Box(
                    modifier = modifier
                        .size(35.dp)
                        .clip(
                            CircleShape
                        )
                        .background(mainColor).clickable {
                            onEvent(ChatBotUiEvent.SendMessage)
                        }, contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource("round_send_24.xml"),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = null,
                        modifier = modifier.size(20.dp)
                    )
                }
                Spacer(modifier = modifier.width(10.dp))

            }





        }





    }



}






@Composable
fun ChatRight(modifier: Modifier = Modifier, text: String) {
    Box(modifier = modifier.fillMaxWidth(),contentAlignment = Alignment.TopEnd) {

        Box(modifier = modifier.widthIn(max = 200.dp, min = 80.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White),contentAlignment = Alignment.Center){
            Text(
                modifier = modifier.padding(10.dp),
                textAlign = TextAlign.Center,
                text = text,
                fontSize = 13.sp
            )
        }
    }
}


@Composable
fun ChatLeft(modifier: Modifier = Modifier, text: String) {
    Box(modifier = modifier.fillMaxWidth(),contentAlignment = Alignment.TopStart){

        Box (modifier = modifier.widthIn(max = 200.dp, min = 80.dp).clip(RoundedCornerShape(10.dp))
            .background(mainColor),contentAlignment = Alignment.Center){

            Text(
                modifier = modifier.padding(10.dp),
                textAlign = TextAlign.Start,
                text = text,
                fontSize = 13.sp
            )
        }

    }
}