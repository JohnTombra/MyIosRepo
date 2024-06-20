package screens.payslip_feature

import ErrorMessage
import androidx.compose.foundation.Image
import androidx.compose.material.Card
import androidx.compose.material.Text
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.repository.Repository
import mainColor
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import payslipHeaderColor
import payslipTopTextColor
import screens.all_payslips_feature.AllPayslipsUiEvent
import screens.home_feature.HomeUiEvent
import screens.home_feature.SuccessMessage
import screens.social_media_feature.SocialMediaUiEvent
import textColorDark


@OptIn(ExperimentalResourceApi::class)
@Composable
fun PayslipScreenComposable(uiState: State<PayslipUiState>,
                          onEvent: (PayslipUiEvent) -> Unit = {},
                          modifier: Modifier = Modifier)  {

    val scrollState = rememberScrollState()

    Box(modifier = modifier.fillMaxSize().verticalScroll(scrollState)) {


    Column(modifier = modifier.fillMaxSize().padding(top = 10.dp)) {


            Column {

                Row(modifier = modifier.padding(top = 10.dp, start = 5.dp,end = 5.dp), verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource("round_arrow_back_ios_new_24.xml"),modifier = modifier.size(14.dp).padding(top = 1.dp).clickable {
                        onEvent(PayslipUiEvent.Back)
                    }, contentDescription = null)
                    Spacer(modifier = modifier.width(5.dp))
                    Text(text = "Payslip Info", modifier = modifier.weight(1f).clickable {
                        onEvent(PayslipUiEvent.Back)
                    }, fontSize = 16.sp, fontWeight = FontWeight.Bold)  }

                Spacer(modifier = modifier.height(10.dp))

                if (!uiState.value.loading) {



                    if(uiState.value.myInfo != null && uiState.value.payslip != null) {

                        Card(
                            modifier = modifier
                                .fillMaxWidth().height(700.dp)
                                .padding(top = 20.dp, start = 8.dp, end = 8.dp),
                            shape = RoundedCornerShape(5.dp),
                            elevation = 2.dp,
                            backgroundColor = Color.White
                        ) {

                            val it = uiState.value.payslip!!
                            val itt = uiState.value.myInfo!!



                            Column(modifier = modifier.fillMaxWidth()) {

                                Column(
                                    modifier = modifier.fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "PLATEAU STATE PAYROLL",
                                        modifier = modifier.padding(top = 20.dp),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp,
                                        color = payslipTopTextColor
                                    )
                                }



                                Text(
                                    itt.employee_details.fullname,
                                    modifier = modifier.padding(top = 30.dp, start = 15.dp),
                                    fontSize = 9.sp
                                )
                                Text(
                                    it.payslip_details.ministry,
                                    modifier = modifier.padding(top = 5.dp, start = 15.dp),
                                    fontSize = 9.sp
                                )
                                Text(
                                    "Payment Date: ${it.payslip_details.generated_on}",
                                    modifier = modifier.padding(top = 5.dp, start = 15.dp),
                                    fontSize = 9.sp
                                )





                                Row(
                                    modifier = modifier.padding(
                                        top = 30.dp,
                                        start = 15.dp,
                                        end = 15.dp
                                    )
                                ) {

                                    Column(modifier = modifier.weight(1F)) {

                                        Text(
                                            "Employment Information:",
                                            fontSize = 10.sp,
                                            color = payslipHeaderColor,
                                            fontWeight = FontWeight.Bold
                                        )

                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Employment No:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text(Repository.employmentNo, fontSize = 9.sp)
                                        }
                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Verification No:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text(
                                                itt.employee_details.employee_no,
                                                fontSize = 9.sp
                                            )
                                        }
                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Designation:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text(
                                                itt.employee_details.current_designation,
                                                fontSize = 9.sp
                                            )
                                        }
                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Salary Structure:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text(
                                                itt.employee_details.salary_structure,
                                                fontSize = 9.sp
                                            )
                                        }
                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Salary Step:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text(
                                                itt.employee_details.current_step.toString(),
                                                fontSize = 9.sp
                                            )
                                        }
                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Grade Level:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text(
                                                itt.employee_details.current_grade_level,
                                                fontSize = 9.sp
                                            )
                                        }
                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Days To Retirement:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text(it.retirement_days.toString(), fontSize = 9.sp)
                                        }
                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Retirement Date:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text(it.retirement_date, fontSize = 9.sp)
                                        }


                                    }

                                    Column {

                                        Text(
                                            "Payment Summary:", fontSize = 10.sp,
                                            color = payslipHeaderColor,
                                            fontWeight = FontWeight.Bold
                                        )


                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Basic Salary:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text(
                                                "${it.payslip_details.BASIC_SALARY}",
                                                fontSize = 9.sp
                                            )
                                        }

                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Allowance:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text(
                                                "${it.payslip_details.TOTAL_MONTHLY_ALLOWANCES}",
                                                fontSize = 9.sp
                                            )
                                        }

                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Monthly Gross:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text(
                                                "${it.payslip_details.MONTHLY_GROSS}",
                                                fontSize = 9.sp
                                            )
                                        }

                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Net Pay:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text("50257.97", fontSize = 9.sp)
                                        }

                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Bank:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text(it.payslip_details.bank_name, fontSize = 9.sp)
                                        }

                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Account Type:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text(
                                                it.payslip_details.account_type,
                                                fontSize = 9.sp
                                            )
                                        }

                                        Row(modifier = modifier.padding(top = 10.dp)) {
                                            Text(
                                                "Account Number:",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                modifier = modifier.padding(end = 5.dp)
                                            )
                                            Text(
                                                it.payslip_details.account_number,
                                                fontSize = 9.sp
                                            )
                                        }

                                    }
                                }





                                Box(
                                    modifier = modifier
                                        .padding(top = 30.dp)
                                        .height(30.dp)
                                        .fillMaxWidth()
                                        .background(Color(0xFF858585)),
                                    contentAlignment = Alignment.CenterStart
                                ) {

                                    Text(
                                        text = "Payment Details",
                                        modifier = modifier
                                            .padding(start = 15.dp),
                                        fontSize = 13.sp,
                                        color = Color.White,
                                        fontWeight = FontWeight.SemiBold,
                                        textAlign = TextAlign.Start
                                    )

                                }


                                Row(
                                    modifier = modifier
                                        .padding(top = 10.dp, start = 15.dp)
                                ) {
                                    Text(
                                        "Deduction(s)",
                                        modifier = modifier.weight(1f),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Text(
                                        "Amount",
                                        modifier = modifier.weight(1f),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }





                                LazyColumn(
                                    modifier = modifier
                                        .padding(top = 5.dp, start = 15.dp)
                                ) {
                                    itemsIndexed(it.deductions) { index, s ->

                                        Row(modifier = modifier.padding(top = 5.dp)) {
                                            Text(
                                                s[0],
                                                modifier = modifier.weight(1f),
                                                fontSize = 9.sp
                                            )
                                            Text(
                                                s[1],
                                                modifier = modifier.weight(1f),
                                                fontSize = 9.sp
                                            )
                                        }


                                    }

                                }



                                Row(
                                    modifier = modifier
                                        .padding(top = 20.dp, start = 15.dp)
                                ) {
                                    Text(
                                        "Allowance(s)",
                                        modifier = modifier.weight(1f),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Text(
                                        "Amount",
                                        modifier = modifier.weight(1f),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }

                                LazyColumn(
                                    modifier = modifier
                                        .padding(top = 5.dp, start = 15.dp, bottom = 30.dp)
                                ) {
                                    itemsIndexed(it.allowances) { index, s ->

                                        Row(modifier = modifier.padding(top = 5.dp)) {
                                            Text(
                                                s[0],
                                                modifier = modifier.weight(1f),
                                                fontSize = 9.sp
                                            )
                                            Text(
                                                s[1],
                                                modifier = modifier.weight(1f),
                                                fontSize = 9.sp
                                            )
                                        }
                                        if(index == it.allowances.size -1){
                                            Spacer(modifier = modifier.height(10.dp))
                                        }
                                    }
                                }


                            }

                            Spacer(modifier = modifier.height(20.dp))
                        }

                        Spacer(modifier = modifier.height(20.dp))

                        Box(
                            modifier = modifier.fillMaxWidth().height(65.dp)
                                .padding(bottom = 20.dp, start = 10.dp, end = 10.dp).clip(
                                    RoundedCornerShape(9.dp)
                                ).background(mainColor).clickable{
                                                                 onEvent(PayslipUiEvent.Download)
                                }, contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Download Payslip",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                }


            }


        }


        ErrorMessage(text = uiState.value.error){
            onEvent(PayslipUiEvent.ClearError)
        }

        if (uiState.value.loading) {
            Box(modifier = modifier.height(700.dp).fillMaxWidth(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    color = Color.DarkGray
                )
            }
        }



        Column{
            Spacer(modifier = modifier.height(90.dp))
            SuccessMessage(text = uiState.value.message, modifier = modifier){
                onEvent(PayslipUiEvent.ClearMessage)
            }
        }



    }
}


