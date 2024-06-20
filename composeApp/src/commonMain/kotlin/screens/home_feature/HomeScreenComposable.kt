package screens.home_feature



import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.ExperimentalComposeUiApi
import org.jetbrains.compose.resources.ExperimentalResourceApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import homeBg
import circles
import data.repository.Repository
import homeBg
import homeTextHead
import homeTextHead2
import mainColor
import mainColor2
import navigation.Routes
import org.jetbrains.compose.resources.painterResource
import serviceColor
import textColorDark


@OptIn(ExperimentalResourceApi::class, ExperimentalComposeUiApi::class)
@Composable
fun HomeScreenComposable(uiState: State<HomeUiState>,
                          onEvent: (HomeUiEvent) -> Unit = {},
                          modifier: Modifier = Modifier)  {

    onEvent(HomeUiEvent.Initialize)


    Box(modifier = modifier.fillMaxSize().background(Color(0xFFF5f5f5))){

        val scrollState2 = rememberScrollState()
        Box(modifier = modifier.fillMaxSize().verticalScroll(scrollState2)) {


            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(homeBg)
                    .padding(start = 5.dp, end = 5.dp, top = 20.dp)
            ) {

                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, end = 5.dp)
                ) {

                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(50.dp), horizontalArrangement = Arrangement.SpaceBetween
                    ) {


                        Card(
                            shape = CircleShape,
                            backgroundColor = Color.White,
                            modifier = modifier.size(45.dp)
                        ) {
                            Image(
                                painter = painterResource("jos.xml"),
                                contentDescription = null,
                                modifier = modifier
                                    .fillMaxSize()

                            )
                        }

                        Spacer(modifier = modifier.width(15.dp))

                        Row {
                            Row(
                                modifier = modifier
                                    .height(30.dp)
                                    .width(30.dp)
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFB0B0B0),
                                        shape = RoundedCornerShape(9.dp)
                                    ).clickable {
                                        onEvent(HomeUiEvent.Navigate(Routes.Search.route))
                                    },
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource("search.xml"),
                                    contentDescription = null,
                                    modifier = modifier
                                        .size(15.dp)
                                )
                            }

                            Spacer(modifier = modifier.width(10.dp))

                            Row(
                                modifier = modifier
                                    .height(30.dp)
                                    .width(30.dp)
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFB0B0B0),
                                        shape = RoundedCornerShape(9.dp)
                                    ).clickable {
                                                onEvent(HomeUiEvent.Navigate(Routes.Notification.route))
                                    },
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource("notification.xml"),
                                    contentDescription = null,
                                    modifier = modifier
                                        .size(15.dp)
                                )
                            }



                        }
                    }


                    Column {
                        Text(
                            text = "Pay Plateau",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = homeTextHead,
                            modifier = modifier.padding(top = 8.dp)
                        )
                        Spacer(modifier = modifier.height(2.dp))
                        Text(
                            text = "Welcome, ${uiState.value.me}",
                            fontSize = 11.sp,
                            color = homeTextHead2,
                            modifier = modifier.padding(top = 5.dp)
                        )
                    }

                    Spacer(modifier = modifier.height(20.dp))


                }




                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(130.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF89C16F)),
                ) {
                      Image(painter = painterResource("chart2.xml"), contentDescription = null, modifier = modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
                }



                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, end = 5.dp)
                ) {

                    Spacer(modifier = modifier.height(40.dp))


                    Text(
                        text = "Our Services",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColorDark
                    )

                    Spacer(modifier = modifier.height(10.dp))

                    val scrollState = rememberScrollState()
                    Row(
                        modifier = modifier.fillMaxWidth().horizontalScroll(scrollState),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {



                        Box(
                            modifier = modifier
                                .height(95.dp)
                                .weight(1f)
                                .clickable {
                                    onEvent(HomeUiEvent.Navigate(Routes.AllPayslip.route))
                                }.clip(RoundedCornerShape(20.dp)).background(Color.White),

                        ) {

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = modifier.fillMaxSize()
                            ) {
                                Image(
                                    painter = painterResource("money.xml"),
                                    contentDescription = null,
                                    modifier = modifier.size(22.dp)
                                )
                                Spacer(modifier = modifier.height(7.dp))
                                Text(
                                    text = "View Payslips",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = textColorDark
                                )
                            }

                        }


                        Box(
                            modifier = modifier
                                .height(95.dp)
                                .weight(1f)
                                .clickable {
                                    onEvent(HomeUiEvent.Navigate(Routes.MyInfo.route))
                                }.clip(RoundedCornerShape(20.dp)).background(Color.White),
//
                        ) {

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = modifier.fillMaxSize()
                            ) {
                                Image(
                                    painter = painterResource("baseline_person_pin_24.xml"),
                                    contentDescription = null,
                                    modifier = modifier.size(22.dp)
                                )
                                Spacer(modifier = modifier.height(2.dp))
                                Text(
                                    text = "My Info",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = textColorDark
                                )
                            }

                        }


                    }



                    Spacer(modifier = modifier.height(35.dp))


                    Text(
                        text = "Get Support",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColorDark
                    )

                    Spacer(modifier = modifier.height(10.dp))




                    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {







                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .height(55.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(serviceColor).clickable {
                                      onEvent(HomeUiEvent.ShowMessage("Request Made Successfully"))
                                }, verticalAlignment = Alignment.CenterVertically
                        ) {

                            Spacer(modifier = modifier.width(5.dp))

                            Box(
                                modifier = modifier
                                    .size(33.dp)
                                    .clip(CircleShape)
                                    .background(circles), contentAlignment = Alignment.Center
                            ) {

                                Image(
                                    painter = painterResource("outline_credit_card_24.xml"),
                                    contentDescription = null,
                                    modifier = modifier.size(18.dp)
                                )

                            }

                            Spacer(modifier = modifier.width(10.dp))

                            Column(
                                verticalArrangement = Arrangement.Center,
                                modifier = modifier.weight(1f)
                            ) {
                                Text(
                                    text = "Request Metro Card",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp,
                                )
                            }

                            Spacer(modifier = modifier.width(10.dp))

                            Column {
                                Image(
                                    painter = painterResource("arrow.xml"),
                                    contentDescription = null,
                                    modifier = modifier.size(15.dp)
                                )
                            }

                            Spacer(modifier = modifier.width(10.dp))


                        }









                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .height(55.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(serviceColor).clickable {
                                    onEvent(HomeUiEvent.Navigate(Routes.SocialMedia.route))
                                }, verticalAlignment = Alignment.CenterVertically
                        ) {

                            Spacer(modifier = modifier.width(5.dp))

                            Box(
                                modifier = modifier
                                    .size(33.dp)
                                    .clip(CircleShape)
                                    .background(circles), contentAlignment = Alignment.Center
                            ) {

                                Image(
                                    painter = painterResource("baseline_supervised_user_circle_24.xml"),
                                    contentDescription = null,
                                    modifier = modifier.size(18.dp)
                                )

                            }

                            Spacer(modifier = modifier.width(10.dp))

                            Column(
                                verticalArrangement = Arrangement.Center,
                                modifier = modifier.weight(1f)
                            ) {
                                Text(
                                    text = "Social media",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp,
                                )
                            }

                            Spacer(modifier = modifier.width(10.dp))

                            Column {
                                Image(
                                    painter = painterResource("arrow.xml"),
                                    contentDescription = null,
                                    modifier = modifier.size(15.dp)
                                )
                            }

                            Spacer(modifier = modifier.width(10.dp))


                        }

                        Spacer(modifier = modifier.height(0.dp))

                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .height(55.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(serviceColor).clickable {
                                    onEvent(HomeUiEvent.Navigate(Routes.PhoneCall.route))
                                }, verticalAlignment = Alignment.CenterVertically
                        ) {

                            Spacer(modifier = modifier.width(5.dp))
                            Box(
                                modifier = modifier
                                    .size(33.dp)
                                    .clip(CircleShape)
                                    .background(circles), contentAlignment = Alignment.Center
                            ) {


                                Box(
                                    modifier = modifier
                                        .size(18.dp)
                                        .clip(CircleShape)
                                        .background(mainColor), contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource("baseline_phone_enabled_24.xml"),
                                        contentDescription = null,
                                        modifier = modifier.size(10.dp)
                                    ) }


                            }

                            Spacer(modifier = modifier.width(10.dp))

                            Column(
                                verticalArrangement = Arrangement.Center,
                                modifier = modifier.weight(1f)
                            ) {
                                Text(text = "Phone call", fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp)
                            }

                            Spacer(modifier = modifier.width(10.dp))

                            Column {
                                Image(
                                    painter = painterResource("arrow.xml"),
                                    contentDescription = null,
                                    modifier = modifier.size(15.dp)
                                )
                            }

                            Spacer(modifier = modifier.width(10.dp))


                        }

                        Spacer(modifier = modifier.height(0.dp))

                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .height(55.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(serviceColor).clickable {
                                    onEvent(HomeUiEvent.Navigate(Routes.ChatBot.route))
                                }, verticalAlignment = Alignment.CenterVertically
                        ) {

                            Spacer(modifier = modifier.width(5.dp))

                            Box(
                                modifier = modifier
                                    .size(33.dp)
                                    .clip(CircleShape)
                                    .background(circles), contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource("baseline_help_24.xml"),
                                    contentDescription = null,
                                    modifier = modifier.size(18.dp)
                                )
                            }

                            Spacer(modifier = modifier.width(10.dp))

                            Column(
                                verticalArrangement = Arrangement.Center,
                                modifier = modifier.weight(1f)
                            ) {
                                Text(
                                    text = "Chat bot",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                )
                            }

                            Spacer(modifier = modifier.width(10.dp))

                            Column {
                                Image(
                                    painter = painterResource("arrow.xml"),
                                    contentDescription = null,
                                    modifier = modifier.size(15.dp)
                                )
                            }

                            Spacer(modifier = modifier.width(10.dp))


                        }


                        Spacer(modifier = modifier.height(70.dp))

                    }

                }
            }









        }

        Row(modifier = modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(Color.White)
            .padding(start = 10.dp)
            .align(Alignment.BottomCenter), verticalAlignment = Alignment.CenterVertically) {


            Row(modifier = modifier
                .weight(1f)
                .padding(start = 15.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Image(painter = painterResource("home.xml"), contentDescription = null, modifier = modifier.size(22.dp))

                Text(text = "Home",fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = modifier.padding(start = 5.dp), color = mainColor)
            }


            Row(modifier = modifier
                .weight(1f)
                .padding(start = 0.dp).clickable {
                    onEvent(HomeUiEvent.Navigate(Routes.AllPayslip.route))
                }, horizontalArrangement = Arrangement.Center) {
                Image(painter = painterResource("group.xml"), contentDescription = null, modifier = modifier.size(16.dp))
            }

            Row(modifier = modifier.weight(1f).clickable {
                onEvent(HomeUiEvent.Navigate(Routes.MyInfo.route))
            }, horizontalArrangement = Arrangement.Center) {
                Image(painter = painterResource("gravity_ui_person.xml"), contentDescription = null, modifier = modifier.size(18.dp))
            }


        }



        SuccessMessage(text = uiState.value.error, modifier = modifier){
            onEvent(HomeUiEvent.ClearError)
        }



    }



}




@Composable
fun SuccessMessage(modifier: Modifier = Modifier, text: String?, clear: ()->Unit = {}) {


    AnimatedVisibility(
        visible = text != null,
        enter = slideInVertically(
            initialOffsetY = {-it}
        ) + EnterTransition.None,
        exit = slideOutVertically(
            targetOffsetY = {-it}
        ) + ExitTransition.None
    ){

        Box(modifier = modifier.fillMaxWidth().height(115.dp).padding(start = 13.dp, end = 13.dp, top = 26.dp).clip(
            RoundedCornerShape(15.dp)
        ).background(
            mainColor //Color(0xFF46923C)
        )){


            Icon(
                imageVector = Icons.Outlined.Done,
                contentDescription = null,
                tint = Color.White,
                modifier = modifier
                    .size(95.dp).align(Alignment.CenterStart).alpha(0.6f)
            )



            Text(text ?: "",fontSize = 13.sp,fontWeight = FontWeight.Bold, color = Color.White, textAlign = TextAlign.Center, modifier = modifier.align(Alignment.Center))






        }

    }
    if(text!=null){
        clear()}
}