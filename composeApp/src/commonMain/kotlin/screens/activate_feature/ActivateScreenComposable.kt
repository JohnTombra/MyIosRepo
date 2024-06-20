package screens.activate_feature

import ErrorMessage
import androidx.compose.material.Card
import androidx.compose.material.Text
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
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
import mainColor
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import screens.all_payslips_feature.AllPayslipsUiEvent
import screens.login_feature.LoginUiEvent


@OptIn(ExperimentalResourceApi::class, ExperimentalComposeUiApi::class)
@Composable
fun ActivateScreenComposable(uiState: State<ActivateUiState>,
                             onEvent: (ActivateUiEvent) -> Unit = {},
                             modifier: Modifier = Modifier)  {

    val keyboardController = LocalSoftwareKeyboardController.current

    val scrollState2 = rememberScrollState()
    Box(modifier = modifier
        .fillMaxSize()
        .background(Color.DarkGray).verticalScroll(scrollState2)){


        Image(painter = painterResource("round_arrow_back_ios_new_242.xml"),modifier = modifier.padding(top = 20.dp, start = 10.dp).size(14.dp).clickable {
            onEvent(ActivateUiEvent.Back)
        }, contentDescription = null)


        Column(modifier = modifier.align(Alignment.Center)) {

            Spacer(modifier = modifier.height(0.dp))

            Text(
                text = "Validate Your Account",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = modifier.height(20.dp))


            Box(modifier = modifier
                .fillMaxWidth()
                .height(560.dp)
                .padding(start = 20.dp, end = 20.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.White)
            ) {




                Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

                    Spacer(modifier = modifier.height(50.dp))

                 //   Image(painter = painterResource(id = R.drawable.jos), contentDescription = null, modifier = modifier.size(80.dp))

                    Column(modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp)) {

                        Text(text = "Employee number",modifier = modifier.padding(start = 10.dp), fontSize = 12.sp)
                        Spacer(modifier = modifier.height(3.dp))

                        TextField(
                            value = uiState.value.employeeNumber,
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White,
                                focusedIndicatorColor = mainColor,
                                cursorColor = mainColor
                            ),
                           placeholder = {
                                Text("Enter your employee number", fontSize = 12.sp)
                            },
                            onValueChange = {
                                onEvent(ActivateUiEvent.UpdateEmployeeNumber(it))
                            }, modifier = modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(onDone = {
                                keyboardController?.hide()
                            }),
                        )

                    }


                    Spacer(modifier = modifier.height(30.dp))
                    Column(modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp)) {

                        Text(text = "Account Number",modifier = modifier.padding(start = 10.dp), fontSize = 12.sp)
                        Spacer(modifier = modifier.height(3.dp))

                        TextField(
                            value = uiState.value.accountNumber,
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White,
                                focusedIndicatorColor = mainColor,
                                cursorColor = mainColor
                            ),
                            placeholder = {
                                Text("Enter your account number", fontSize = 12.sp)
                            },
                            onValueChange = {
                                onEvent(ActivateUiEvent.UpdateAccountNumber(it))
                            }, modifier = modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(onDone = {
                                keyboardController?.hide()
                            }),
                        )

                    }

                    Spacer(modifier = modifier.height(30.dp))
                    Column(modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp)) {
                        var shown by remember { mutableStateOf(true) }
                        Text(text = "New Password",modifier = modifier.padding(start = 10.dp), fontSize = 12.sp)
                        Spacer(modifier = modifier.height(3.dp))

                        TextField(
                            value = uiState.value.newPassword,
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White,
                                focusedIndicatorColor = mainColor,
                                cursorColor = mainColor
                            ),
                            placeholder = {
                                Text("Enter your new password", fontSize = 12.sp)
                            },
                            onValueChange = {
                                onEvent(ActivateUiEvent.UpdateNewPassword(it))
                            }, modifier = modifier.fillMaxWidth(),
                            visualTransformation = if(shown) PasswordVisualTransformation() else VisualTransformation.None,
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType =  KeyboardType.Password,imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(onDone = {
                                keyboardController?.hide()
                            }),
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


                    Spacer(modifier = modifier.height(30.dp))
                    Column(modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp)) {

                        Text(text = "Confirm Password",modifier = modifier.padding(start = 10.dp), fontSize = 12.sp)
                        Spacer(modifier = modifier.height(3.dp))
                        var shown by remember { mutableStateOf(true) }
                        TextField(
                            value = uiState.value.confirmPassword,
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White,
                                focusedIndicatorColor = mainColor,
                                cursorColor = mainColor
                            ),
                            placeholder = {
                                Text("Confirm your password", fontSize = 12.sp)
                            },
                            onValueChange = {
                                            onEvent(ActivateUiEvent.UpdateConfirmPassword(it))
                            }, modifier = modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType =  KeyboardType.Password,imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(onDone = {
                                keyboardController?.hide()
                            }),
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
                            .background(mainColor).clickable {
                                                             onEvent(ActivateUiEvent.ValidateForm)
                            }, contentAlignment = Alignment.Center
                    ) {
                        Row(modifier = modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){

                            Text(
                                text = "Validate Account",
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



        }


        ErrorMessage(text = uiState.value.error, modifier = modifier){
            onEvent(ActivateUiEvent.ClearError)}


    }


}