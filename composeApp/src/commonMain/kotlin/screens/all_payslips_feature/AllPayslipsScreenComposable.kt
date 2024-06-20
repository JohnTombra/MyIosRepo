package screens.all_payslips_feature

import ErrorMessage
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kind.smartpay20android.data.model.gov.DataXXXX
import mainColor
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import screens.social_media_feature.SocialMediaUiEvent


@OptIn(ExperimentalResourceApi::class)
@Composable
fun AllPayslipsScreenComposable(uiState: State<AllPayslipsUiState>,
                                onEvent: (AllPayslipsUiEvent) -> Unit = {},
                                modifier: Modifier = Modifier
)  {


    //show loading
    //show no item available


    Column(modifier = modifier.fillMaxSize()){

        Row(modifier = modifier
            .fillMaxWidth()
            .padding(top = 5.dp), verticalAlignment = Alignment.CenterVertically){

            Row(modifier = modifier.padding(top = 10.dp, start = 5.dp,end = 5.dp), verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource("round_arrow_back_ios_new_24.xml"),modifier = modifier.size(14.dp).padding(top = 3.dp).clickable {
                    onEvent(AllPayslipsUiEvent.Back)
                }, contentDescription = null)
                Spacer(modifier = modifier.width(5.dp))
                Text(text = "Payslips", modifier = modifier.weight(1f).clickable {
                    onEvent(AllPayslipsUiEvent.Back)
                }, fontSize = 18.sp, fontWeight = FontWeight.Bold)


                Spacer(modifier = modifier.weight(1f))


                Box(
                    modifier = modifier
                        .height(35.dp)
                        .width(85.dp)
                        .padding(top = 5.dp)
                        .clip(
                            RoundedCornerShape(5.dp)
                        )
                        .background(mainColor).clickable {
                            onEvent(AllPayslipsUiEvent.Search)
                        }, contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Search",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = modifier.width(0.dp))

            }





        }

        Spacer(modifier = modifier.height(15.dp))



        Row{

            Spacer(modifier = modifier.width(10.dp))

            Text(text = "Years to search", fontSize = 8.5.sp)

            Spacer(modifier = modifier.weight(1f))

            Text(text = "Month to search", fontSize = 8.5.sp)

            Spacer(modifier = modifier.width(10.dp))
        }

        Spacer(modifier = modifier.height(5.dp))


        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxWidth()){
            Spacer(modifier = modifier.width(10.dp))

            MyDropDown3(
                label = uiState.value.startYear,
                value = uiState.value.startYear,
                items = uiState.value.years,
                callback = { x, y ->
                    onEvent(AllPayslipsUiEvent.UpdateStartYear(y))
                })

            Spacer(modifier = modifier.width(3.dp))

            MyDropDown3(
                label = uiState.value.year,
                value = uiState.value.year,
                items = uiState.value.years,
                callback = { x, y ->
                    onEvent(AllPayslipsUiEvent.UpdateYear(y))
                })
//
//            Image(
//                painter = painterResource("baseline_filter_list_alt_24.xml"),
//                contentDescription = null,
//                modifier = modifier.size(15.dp).padding(start = 15.dp)
//            )

            Spacer(modifier = modifier.weight(1f))

            MyDropDown2(
                value = uiState.value.month,
                items = uiState.value.months,
                label = uiState.value.month,
                callback = { x, y ->
                    onEvent(AllPayslipsUiEvent.UpdateMonth(y))
                })

            Spacer(modifier = modifier.width(5.dp))
        }


        Spacer(modifier = modifier.height(30.dp))



        if(!uiState.value.loading) {
            if(uiState.value.payslips.isNotEmpty()) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp), modifier =modifier.fillMaxSize()) {
                itemsIndexed(uiState.value.payslips) { index, s ->
                    PaySlip(data = s, callback = {
                        onEvent(AllPayslipsUiEvent.Navigate(it))
                    })
                }
            }
            }
        }


        if(uiState.value.loading){
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    color = Color.DarkGray
                )
            }

        }else {


            if(uiState.value.payslips.isEmpty()){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier.fillMaxSize(),
                ) {
                    Image(
                        painter = painterResource("baseline_satellite_alt_24.xml"),
                        contentDescription = null,
                        modifier = modifier.size(60.dp)
                    )
                    Spacer(
                        modifier = modifier.height(15.dp)
                    )
                    Text(text = "No payslip for this month", fontSize = 11.sp)
                }
            }

        }


        ErrorMessage(text = uiState.value.error){
            onEvent(AllPayslipsUiEvent.ClearError)
        }

    }



}



@Composable
private fun PaySlip(modifier: Modifier = Modifier, data: DataXXXX, callback: (Int) -> Unit){



    Card(
        backgroundColor = Color.White,
        elevation = 2.5.dp,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp, top = 3.dp).clickable {
                callback(data.PRID)
            }) {

        Row(modifier = modifier.fillMaxSize()){

            Column( verticalArrangement = Arrangement.spacedBy(10.dp), modifier = modifier.padding(top = 20.dp)) {


                Row(modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp, start = 20.dp, end = 10.dp)){
                    Text(text = "Generated on:",modifier = modifier.width(130.dp), fontSize = 13.sp)
                    Spacer(modifier = modifier.width(30.dp))
                    Text(text = try{data.generated_on.split(" ")[0]}catch(e:Exception){"N/A"}, fontSize = 13.sp)
                }

                Row(modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 10.dp)){
                    Text(text = "Month:",modifier = modifier.width(130.dp), fontSize = 13.sp)
                    Spacer(modifier = modifier.width(30.dp))
                    Text(text = data.MONTH, fontSize = 13.sp)
                }

                Row(modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 10.dp)){
                    Text(text = "Basic salary:",modifier = modifier.width(130.dp), fontSize = 13.sp)
                    Spacer(modifier = modifier.width(30.dp))
                    Text(text = data.BASIC_SALARY, fontSize = 13.sp)
                }

                Row(modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 10.dp)){
                    Text(text = "Monthly pay:",modifier = modifier.width(130.dp), fontSize = 13.sp)
                    Spacer(modifier = modifier.width(30.dp))
                    Text(text = data.MONTHLY_PAY, fontSize = 13.sp)
                }

                Row(modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 10.dp)){
                    Text(text = "Monthly allowance:",modifier = modifier.width(130.dp), fontSize = 13.sp)
                    Spacer(modifier = modifier.width(30.dp))
                    Text(text = data.TOTAL_MONTHLY_ALLOWANCES, fontSize = 13.sp)
                }

                Row(modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 10.dp)){
                    Text(text = "Monthly gross:",modifier = modifier.width(130.dp), fontSize = 13.sp)
                    Spacer(modifier = modifier.width(30.dp))
                    Text(text = data.MONTHLY_GROSS, fontSize = 13.sp)
                }

                Row(modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 10.dp)){
                    Text(text = "Monthly deductions:",modifier = modifier.width(130.dp), fontSize = 13.sp)
                    Spacer(modifier = modifier.width(30.dp))
                    Text(text = data.TOTAL_MONTHLY_DEDUCTIONS, fontSize = 13.sp)
                }

                Row(modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 10.dp)){
                    Text(text = "Over payments:",modifier = modifier.width(130.dp), fontSize = 13.sp)
                    Spacer(modifier = modifier.width(30.dp))
                    Text(text = data.overpayment, fontSize = 13.sp)
                }

                Row(modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 10.dp)){
                    Text(text = "Account number:",modifier = modifier.width(130.dp), fontSize = 13.sp)
                    Spacer(modifier = modifier.width(30.dp))
                    Text(text = data.account_number, fontSize = 13.sp)
                }

                Spacer(modifier = modifier.height(50.dp))

            }


        }

    }




}





@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyDropDown2(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    items: List<String>,
    callback: (Int, String) -> Unit
) {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    var text by remember {
        mutableStateOf("")
    }

    var focused by remember { mutableStateOf(false) }


    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { newValue ->
            isExpanded = newValue
        }, modifier = modifier.width(120.dp)
    ) {



        Row(modifier = modifier.width(120.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {

            Text(text = if(text.isEmpty()){label}else{text}, textAlign = TextAlign.End, fontSize = 12.5.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = modifier.width(2.dp))
            Icon(
                imageVector = if (isExpanded) {
                    Icons.Default.ArrowDropDown
                } else {
                    Icons.Default.ArrowDropDown
                }, contentDescription = null,
                tint = Color(0xFFC6C6C6),
                modifier = modifier.size(22.dp)
            )
        }


        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = {
                isExpanded = false
            },
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {

            items.forEachIndexed { index, s ->
                DropdownMenuItem(
                    onClick = {
                        text = s
                        isExpanded = false
                        callback(index, s)
                    }
                ){
                    Text(text = s, fontWeight = FontWeight.Normal, color = Color.DarkGray)

                }
            }

        }


    }


}



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyDropDown3(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    items: List<String>,
    callback: (Int, String) -> Unit
) {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    var text by remember {
        mutableStateOf("")
    }

    var focused by remember { mutableStateOf(false) }


    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { newValue ->
            isExpanded = newValue
        }, modifier = modifier.width(55.dp)
    ) {



        Row(modifier = modifier.width(55.dp), verticalAlignment = Alignment.CenterVertically) {

            Text(text = if(text.isEmpty()){label}else{text}, fontSize = 12.5.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = modifier.width(2.dp))
            Icon(
                imageVector = if (isExpanded) {
                    Icons.Default.ArrowDropDown
                } else {
                    Icons.Default.ArrowDropDown
                }, contentDescription = null,
                tint = Color(0xFFC6C6C6),
                modifier = modifier.size(22.dp)
            )
        }


        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = {
                isExpanded = false
            },
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {

            items.forEachIndexed { index, s ->
                DropdownMenuItem(
                    onClick = {
                        text = s
                        isExpanded = false
                        callback(index, s)
                    }
                ){
                    Text(text = s, fontWeight = FontWeight.Normal,  color = Color.DarkGray)

                }
            }

        }


    }


}



