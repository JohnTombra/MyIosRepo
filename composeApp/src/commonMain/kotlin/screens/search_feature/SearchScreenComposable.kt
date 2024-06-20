package screens.search_feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import backgroundColor
import mainColor
import org.jetbrains.compose.resources.painterResource
import screens.social_media_feature.SocialMediaUiEvent
import textColorDark


@OptIn(ExperimentalResourceApi::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchScreenComposable(uiState: State<SearchUiState>,
                          onEvent: (SearchUiEvent) -> Unit = {},
                          modifier: Modifier = Modifier)  {

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(modifier = modifier.fillMaxSize().background(backgroundColor)) {


        Row(modifier = modifier.padding(top = 15.dp, start = 10.dp,end = 10.dp).clickable {
            onEvent(SearchUiEvent.Back)
        }, verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource("round_arrow_back_ios_new_24.xml"),modifier = modifier.size(14.dp).clickable {
                onEvent(SearchUiEvent.Back)
            }, contentDescription = null)
            Spacer(modifier = modifier.width(10.dp))
            Text(text = "Search", modifier = modifier.weight(1f).clickable {
                onEvent(SearchUiEvent.Back)
            }, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = modifier.height(30.dp))


        Box(modifier  = modifier.fillMaxWidth().height(55.dp).padding(start = 10.dp, end = 10.dp).border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(10.dp))){

            TextField(
                value = uiState.value.query,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    cursorColor = mainColor
                ),
                placeholder = {
                    Text("Type here")
                },
                trailingIcon = {
                    Image(painter = painterResource("search3.xml"), contentDescription = null, modifier  = modifier.size(18.dp))
                },

                onValueChange = {
                    onEvent(SearchUiEvent.UpdateQuery(it))
                }, modifier = modifier.fillMaxSize(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                })
            )


        }



        LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp), modifier = modifier.padding(top = 50.dp, start = 10.dp, end = 10.dp)) {
            itemsIndexed(uiState.value.result) { index, s ->
                Text(s,modifier = modifier.padding(start = 10.dp).clickable {
                        onEvent(SearchUiEvent.Navigate(s))
                }, fontSize =  13.sp)
            }
        }


    }


}