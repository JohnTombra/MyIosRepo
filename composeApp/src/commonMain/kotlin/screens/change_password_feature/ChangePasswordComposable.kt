package screens.change_password_feature



import ErrorMessage
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import errorColor
import mainColor
import navigation.Routes
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import screens.activate_feature.ActivateUiEvent
import screens.activate_feature.VALIDATION
import screens.home_feature.HomeUiEvent
import textColorLight1
import textColorLight3
import textColorLight4


@OptIn(ExperimentalResourceApi::class, ExperimentalComposeUiApi::class)
@Composable
fun ChangePasswordComposable(uiState: State<ChangePasswordUiState>,
                          onEvent: (ChangePasswordUiEvent) -> Unit = {},
                          modifier: Modifier = Modifier)  {



    val keyboardController = LocalSoftwareKeyboardController.current


    //scrollable
    val scrollState = rememberScrollState()

    Box(modifier = modifier.fillMaxSize().verticalScroll(scrollState)
        .background(Color.DarkGray).clickable {
            keyboardController?.hide()
        }){


        Image(painter = painterResource("round_arrow_back_ios_new_242.xml"),modifier = modifier.padding(top = 20.dp, start = 10.dp).size(14.dp).clickable {
            onEvent(ChangePasswordUiEvent.Back)
        }, contentDescription = null)


        Box(modifier = modifier
            .fillMaxWidth()
            .height(580.dp)
            .padding(start = 20.dp, end = 20.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color.White)
            .align(Alignment.Center)) {




            Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

                Spacer(modifier = modifier.height(40.dp))

                Image(painter = painterResource("jos.xml"), contentDescription = null, modifier = modifier.size(90.dp))

                Spacer(modifier = modifier.height(50.dp))
                Column(modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp)) {

                    Text(text = "Current Password",modifier = modifier.padding(start = 3.dp), fontSize = 12.sp)
                    Spacer(modifier = modifier.height(5.dp))
                    var shown by remember { mutableStateOf(true) }
                    TextField(

                        value = uiState.value.oldPassword,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                            focusedIndicatorColor = mainColor,
                            cursorColor = mainColor
                        ),
                        visualTransformation = if(shown) PasswordVisualTransformation() else VisualTransformation.None,
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType =  KeyboardType.Password,imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = {
                            keyboardController?.hide()
                        }),
                        placeholder = {
                            Text("Enter current password", fontSize = 12.sp, color = textColorLight3)
                        },
                        onValueChange = {

                               onEvent(ChangePasswordUiEvent.UpdateOldPassword(it))
                        }, modifier = modifier.fillMaxWidth(),
                        trailingIcon = {

                            Image(
                                painter = if(shown) painterResource("outline_visibility_off_24.xml") else painterResource("outline_visibility_24.xml"),
                                contentDescription = null,
                                modifier = modifier
                                    .size(16.dp)
                                    .clickable {
                                        shown = !shown
                                    }
                            )

                        }
                    )

                }

                Spacer(modifier = modifier.height(20.dp))
                Column(modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp)) {

                    Text(text = "New Password",modifier = modifier.padding(start = 3.dp), fontSize = 12.sp)
                    Spacer(modifier = modifier.height(5.dp))
                    var shown by remember { mutableStateOf(true) }
                    TextField(

                        value = uiState.value.newPassword,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                            focusedIndicatorColor = mainColor,
                            cursorColor = mainColor
                        ),
                        visualTransformation = if(shown) PasswordVisualTransformation() else VisualTransformation.None,
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType =  KeyboardType.Password,imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = {
                            keyboardController?.hide()
                        }),
                        placeholder = {
                            Text("Enter new password", fontSize = 12.sp, color = textColorLight3)
                        },
                        onValueChange = {
 onEvent(ChangePasswordUiEvent.UpdateNewPassword(it))
                        }, modifier = modifier.fillMaxWidth(),
                        trailingIcon = {

                            Image(
                                painter = if(shown) painterResource("outline_visibility_off_24.xml") else painterResource("outline_visibility_24.xml"),
                                contentDescription = null,
                                modifier = modifier
                                    .size(16.dp)
                                    .clickable {
                                        shown = !shown
                                    }
                            )

                        }
                    )

                }


                Spacer(modifier = modifier.height(20.dp))
                Column(modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp)) {

                    Text(text = "Confirm New Password",modifier = modifier.padding(start = 3.dp), fontSize = 12.sp)
                    Spacer(modifier = modifier.height(5.dp))
                    var shown by remember { mutableStateOf(true) }
                    TextField(

                        value = uiState.value.confirmNewPassword,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                            focusedIndicatorColor = mainColor,
                            cursorColor = mainColor
                        ),
                        visualTransformation = if(shown) PasswordVisualTransformation() else VisualTransformation.None,
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType =  KeyboardType.Password,imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = {
                            keyboardController?.hide()
                        }),
                        placeholder = {
                            Text("Confirm new password", fontSize = 12.sp, color = textColorLight3)
                        },
                        onValueChange = {
                               onEvent(ChangePasswordUiEvent.UpdateConfirmNewPassword(it))
                        }, modifier = modifier.fillMaxWidth(),
                        trailingIcon = {

                            Image(
                                painter = if(shown) painterResource("outline_visibility_off_24.xml") else painterResource("outline_visibility_24.xml"),
                                contentDescription = null,
                                modifier = modifier
                                    .size(16.dp)
                                    .clickable {
                                        shown = !shown
                                    }
                            )

                        }
                    )

                }

                Spacer(modifier = modifier.height(40.dp))

                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(65.dp)
                        .padding(bottom = 20.dp, start = 15.dp, end = 15.dp)
                        .clip(
                            RoundedCornerShape(5.dp)
                        )
                        .background(mainColor).clickable{
                             onEvent(ChangePasswordUiEvent.ValidateForm)
                        }, contentAlignment = Alignment.Center
                ) {
                    Row(modifier = modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){

                        Text(
                            text = "Change Password",
                            modifier = modifier,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )



                        if(uiState.value.loading){
                            Spacer(modifier = modifier.width(10.dp))
                            CircularProgressIndicator(
                                color = Color.White,
                                modifier = modifier.size(16.dp),
                                strokeWidth = 1.8.dp
                            )
                        }
                    }

                }


            }


        }


        ErrorMessage(text = uiState.value.error, modifier = modifier){
            onEvent(ChangePasswordUiEvent.ClearError)
        }

    }








}







