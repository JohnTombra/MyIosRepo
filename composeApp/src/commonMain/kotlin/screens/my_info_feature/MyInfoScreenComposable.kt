package screens.my_info_feature

import ErrorMessage
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.ui.graphics.vector.ImageVector
import lightProfileStrips
import mainColor
import org.jetbrains.compose.resources.painterResource
import screens.all_payslips_feature.AllPayslipsUiEvent
import screens.home_feature.SuccessMessage
import screens.payslip_feature.PayslipUiEvent
import screens.social_media_feature.SocialMediaUiEvent
import textColorLight2

@OptIn(ExperimentalResourceApi::class, ExperimentalComposeUiApi::class)
@Composable
fun MyInfoScreenComposable(uiState: State<MyInfoUiState>,
                          onEvent: (MyInfoUiEvent) -> Unit = {},
                          modifier: Modifier = Modifier)  {




    val scrollState = rememberScrollState()

    Box(modifier = modifier.fillMaxSize().verticalScroll(scrollState)) {


        Column(modifier = modifier.background(Color.White)) {

            Row(modifier = modifier.padding(top = 15.dp, start = 10.dp,end = 10.dp).clickable {
                onEvent(MyInfoUiEvent.Back)
            }, verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource("round_arrow_back_ios_new_24.xml"),modifier = modifier.size(14.dp).padding(top = 1.5.dp), contentDescription = null)
                Spacer(modifier = modifier.width(5.dp))
                Text(text = "My Info", modifier = modifier.weight(1f).clickable {
                    onEvent(MyInfoUiEvent.Back)
                }, fontSize = 16.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = modifier.weight(1f))

                Box(
                    modifier = modifier.width(120.dp).height(40.dp).clip(
                        CircleShape
                    ).background(mainColor).clickable {
                        onEvent(MyInfoUiEvent.Download)
                    }, contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Download Info",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = modifier.width(0.dp))

            }

            if (uiState.value.loading) {
                Box(modifier = modifier.height(700.dp).fillMaxWidth(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(
                        color = Color.DarkGray
                    )
                }
            } else {
                if (uiState.value.myInfo != null) {

                    Column() {
                        val profile = uiState.value.myInfo!!.employee_details
                        Box(
                            modifier = modifier
                                .padding(top = 20.dp)
                                .height(1.dp)
                                .background(Color.LightGray)
                        )


                        Column(
                            modifier = modifier
                                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                                .align(alignment = Alignment.CenterHorizontally),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {


                            Box(
                                modifier = modifier
                                    .size(55.dp)
                                    .clip(
                                        CircleShape
                                    )
                                    .background(Color(0xFFeeeeee))
                            ) {
                Image(
                    modifier = modifier.size(22.dp).align(Alignment.Center),
                    painter = painterResource("baseline_person_24.xml"),
                    contentDescription = null,
                )
                            }



                            Text(
                                text = profile.fullname,
                                textAlign = TextAlign.Center,
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = modifier.padding(top = 15.dp)
                            )
                            Spacer(modifier = modifier.height(5.dp))
                            Text(
                                text = profile.email,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                color = mainColor
                            )
                        }

                        Row(
                            modifier = modifier.padding(top = 25.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Phone number: " + profile.mobile_phone,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }



                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Employee no: ${profile.employee_no}",
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }





                        Spacer(
                            modifier = modifier.padding(top = 15.dp, bottom = 10.dp).height(7.5.dp)
                                .fillMaxWidth()
                                .background(lightProfileStrips)
                        )






                        Row(
                            modifier = modifier.padding(
                                top = 25.dp,
                                start = 10.dp,
                                bottom = 20.dp
                            )
                        ) {
                            Text(
                                text = "Personal Info",
                                fontWeight = FontWeight.Bold,
                                modifier = modifier.weight(1f)
                            )

                        }






                        Row(
                            modifier = modifier.padding(start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Date of birth: " + profile.date_of_birth,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }

                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Marital status: " + profile.marital_status,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }


                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MyOutLinedTextField3(
                                text = "",
                                label = "Gender: " + profile.gender,
                                onValueChanged = {
                                },
                                icon = null
                            )
                        }

                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MyOutLinedTextField3(
                                text = "",
                                label = "State of origin: " + profile.state_of_origin,
                                onValueChanged = {
                                },
                                icon = null
                            )
                        }


                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MyOutLinedTextField3(
                                text = "",
                                label = "Residential street: " + profile.residential_street,
                                onValueChanged = {
                                },
                                icon = null
                            )
                        }

                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MyOutLinedTextField3(
                                text = "",
                                label = "Residential city: " + profile.residential_city,
                                onValueChanged = {
                                },
                                icon = null
                            )
                        }

                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MyOutLinedTextField3(
                                text = "",
                                label = "Residential state: " + profile.residential_state,
                                onValueChanged = {
                                },
                                icon = null
                            )
                        }

                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MyOutLinedTextField3(
                                text = "",
                                label = "Residential lga: " + profile.residential_lga,
                                onValueChanged = {
                                },
                                icon = null
                            )
                        }

                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MyOutLinedTextField3(
                                text = "",
                                label = "Residential country: " + profile.residential_country,
                                onValueChanged = {
                                },
                                icon = null
                            )
                        }

                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MyOutLinedTextField3(
                                text = "",
                                label = "Type of accommodation: " + profile.type_of_accom,
                                onValueChanged = {
                                },
                                icon = null
                            )
                        }



                        Spacer(
                            modifier = modifier.padding(top = 15.dp, bottom = 10.dp).height(7.5.dp)
                                .fillMaxWidth()
                                .background(lightProfileStrips)
                        )


                        Row(
                            modifier = modifier.padding(
                                top = 25.dp,
                                start = 10.dp,
                                bottom = 20.dp
                            )
                        ) {
                            Text(
                                text = "Employment Info",
                                fontWeight = FontWeight.Bold,
                                modifier = modifier.weight(1f)
                            )
                        }


                        Row(
                            modifier = modifier.padding(start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Employee department: " + profile.department,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }


                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Current category: " + profile.current_category,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }


                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Ministry: " + profile.ministry,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }


                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Current designation: " + profile.current_designation,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }

                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Salary structure: " + profile.salary_structure,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }



                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Current grade level: " + profile.current_grade_level,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }



                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Current step: " + profile.current_step.toString(),
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }


                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Time of activation: " + profile.time_of_activation,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }


                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            MyOutLinedTextField3(
                                text = "",
                                label = "First date of current employment: " + profile.first_date_of_first_employment,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }

                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            MyOutLinedTextField3(
                                text = "",
                                label = "Confirmation date of current employment: " + profile.confirmation_date_1st_emp,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }


                        Row(
                            modifier = modifier.padding(top = 0.dp, start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            MyOutLinedTextField3(
                                text = "",
                                label = "Place of first employment: " + profile.place_of_1st_employment,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }




                        Spacer(
                            modifier = modifier.padding(top = 15.dp, bottom = 10.dp).height(7.5.dp)
                                .fillMaxWidth()
                                .background(lightProfileStrips)
                        )


                        Row(
                            modifier = modifier.padding(
                                top = 25.dp,
                                start = 10.dp,
                                bottom = 20.dp
                            )
                        ) {
                            Text(
                                text = "Bank Info",
                                fontWeight = FontWeight.Bold,
                                modifier = modifier.weight(1f)
                            )
                        }


                        Row(
                            modifier = modifier.padding(start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Bank: " + profile.bank,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }


                        Row(
                            modifier = modifier.padding(start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Bank branch: " + profile.bank_branch,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }


                        Row(
                            modifier = modifier.padding(start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Account number: " + profile.account_number,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }


                        Row(
                            modifier = modifier.padding(start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Account type: " + profile.account_type,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }


                        Row(
                            modifier = modifier.padding(start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            MyOutLinedTextField3(
                                text = "",
                                label = "Account name: " + profile.account_firstname + " " + profile.account_middle_name + " " + profile.account_surname,
                                onValueChanged = {
                                },
                                icon = null
                            )

                        }



                        Spacer(
                            modifier = modifier.padding(top = 15.dp, bottom = 10.dp).height(7.5.dp)
                                .fillMaxWidth()
                                .background(lightProfileStrips)
                        )


                        Row(
                            modifier = modifier.height(60.dp).clickable {
                                onEvent(MyInfoUiEvent.Navigate)
                            },
                            verticalAlignment = Alignment.CenterVertically
                        ) {

            Image(painter = painterResource("baseline_security_24.xml"), contentDescription = null, modifier  = modifier
                .size(35.dp)
                .padding(start = 15.dp))

                            Spacer(modifier = modifier.width(10.dp))

                            Text(text = "Change your password", fontSize = 13.5.sp, color = textColorLight2, modifier = modifier)


                        }


                        Row(
                            modifier = modifier.height(60.dp).clickable {
                                  onEvent(MyInfoUiEvent.Logout)
                            },
                            verticalAlignment = Alignment.CenterVertically
                        ) {

            Image(painter = painterResource("baseline_logout_24.xml"), contentDescription = null, modifier  = modifier
                .size(35.dp)
                .padding(start = 15.dp))

                            Spacer(modifier = modifier.width(10.dp))


                            Text(text = "Log out", fontSize = 13.5.sp, color = textColorLight2, modifier = modifier)

                        }
                        Spacer(modifier = modifier.height(15.dp))
                    }
                }
            }
        }

        ErrorMessage(text = uiState.value.error){
            onEvent(MyInfoUiEvent.ClearError)
        }

        SuccessMessage(text = uiState.value.message, modifier = modifier){
            onEvent(MyInfoUiEvent.ClearMessage)
        }
    }
}


@Composable
fun MyOutLinedTextField3(
    modifier: Modifier = Modifier,
    text: String,
    onValueChanged: (String) -> Unit,
    label: String,
    icon: ImageVector?
) {



    Column {

        OutlinedTextField(
            readOnly = true,
            value = text,
            enabled = false,
            onValueChange = {
                onValueChanged(it)
            },

            colors = TextFieldDefaults.textFieldColors(
                focusedLabelColor  = Color.DarkGray,
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.White,
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.height(60.dp)
                .fillMaxWidth().padding(start = 5.dp, end = 5.dp),
            label = {
                Text(text = label, fontSize = 13.5.sp, color = textColorLight2)
            }
        )
    }


}
