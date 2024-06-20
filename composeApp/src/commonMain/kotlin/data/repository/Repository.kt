package data.repository


import com.kind.smartpay20android.data.model.gov.GovAllPayslipResponse
import com.kind.smartpay20android.data.model.gov.GovEmployeeProfileResponse
import com.kind.smartpay20android.data.model.gov.GovLoginBody
import com.kind.smartpay20android.data.model.gov.GovLoginResponse
import com.kind.smartpay20android.data.model.gov.GovLogoutResponse
import com.kind.smartpay20android.data.model.gov.GovNewPasswordBody
import com.kind.smartpay20android.data.model.gov.GovSinglePayslipResponse
import com.kind.smartpay20android.data.model.gov.GovUserValidationResponse
import com.kind.smartpay20android.data.model.gov.GovValidateAnAccountBody
import com.kind.smartpay20android.data.model.gov.GovValidateAnAccountResponce
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.timeout
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.InternalAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.serializer

class Repository {



    val client = HttpClient {
        engine {
            request { timeout { HttpTimeout.INFINITE_TIMEOUT_MS } }
        }
        val json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }

        install(ContentNegotiation) {
            json(json, contentType = ContentType.Any)
        }


    }


    val base = "https://smartpay.thesmartapps.org/api/mobile/v1/"



    companion object {
        var employmentNo = ""
        var token = ""
        var me: GovLoginResponse? = null
    }





    fun login(govLoginBody: GovLoginBody, success: (GovLoginResponse) -> Unit, error: (String) -> Unit){
        CoroutineScope(Dispatchers.Default).launch {

            try {//
                val resp: HttpResponse = client.post(base + "login"){
                    contentType(ContentType.Application.Json)
                    headers {
                        append(HttpHeaders.ContentType, "application/json")
                        append("SERVICE_ID", "234009")
                        append(HttpHeaders.Accept, "application/json")
                    }
                    setBody(govLoginBody)
                }

                if (resp.status.value in 200..299) {

                    val json = Json {
                        ignoreUnknownKeys = true
                        coerceInputValues = true
                    }
                    val response = json.decodeFromString<GovLoginResponse>(resp.body())

                    if (response.status) {
                        CoroutineScope(Dispatchers.Main).launch {
                            me = response
                            token = "Bearer ${response.data.token}"
                            employmentNo = govLoginBody.username
                            success(response)
                        }
                    } else {
                        CoroutineScope(Dispatchers.Main).launch {
                            error(response.message)
                        }
                    }

                } else {
                    CoroutineScope(Dispatchers.Main).launch {
                        error("Incorrect password")
                    }
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    error("Network error: ${e.message}")

                }
            }

        }
    }





    fun govCheckValidation(email: String,success: (Boolean) -> Unit, error: (String) -> Unit){
        CoroutineScope(Dispatchers.Default).launch {

            try {
                val resp: HttpResponse = client.get(base + "validation/$email"){
                    contentType(ContentType.Application.Json)
                    headers {
                        append(HttpHeaders.ContentType, "application/json")
                        append("SERVICE_ID", "234009")
                        append(HttpHeaders.Accept, "application/json")
                    }

                }

                if (resp.status.value in 200..299) {

                    val response = Json.decodeFromString<GovUserValidationResponse>(resp.body())

                    if (response.status) {
                        CoroutineScope(Dispatchers.Main).launch {
                            success(response.status)
                        }
                    } else {
                        CoroutineScope(Dispatchers.Main).launch {
                            error(response.message)
                        }
                    }

                } else {
                    CoroutineScope(Dispatchers.Main).launch {
                        success(false)
                    }
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    error("Network error")

                }
            }

        }
    }



    fun govNewPassword(govNewPasswordBody: GovNewPasswordBody, success: (GovUserValidationResponse) -> Unit, error: (String) -> Unit){
        CoroutineScope(Dispatchers.Default).launch {

            try {
                val resp: HttpResponse = client.post(base + "change-password"){
                    contentType(ContentType.Application.Json)
                    headers {
                        append(HttpHeaders.ContentType, "application/json")
                        append("SERVICE_ID", "234009")
                        append(HttpHeaders.Accept, "application/json")
                        append(HttpHeaders.Authorization, token)
                    }
                    setBody(govNewPasswordBody)
                }

                if (resp.status.value in 200..299) {

                    val response = Json.decodeFromString<GovUserValidationResponse>(resp.body())

                    if (response.status) {
                        CoroutineScope(Dispatchers.Main).launch {
                            success(response)
                        }
                    } else {
                        CoroutineScope(Dispatchers.Main).launch {
                            error(response.message)
                        }
                    }

                } else {
                    CoroutineScope(Dispatchers.Main).launch {
                        error("Error: ${resp.status.description}")
                    }
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    error("Network error")

                }
            }

        }
    }



    fun govValidateAnAccount(govValidateAnAccountBody: GovValidateAnAccountBody, success: (Boolean) -> Unit, error: (String) -> Unit){
        CoroutineScope(Dispatchers.Default).launch {

            try {
                val resp: HttpResponse = client.post(base + "validation"){
                    contentType(ContentType.Application.Json)
                    headers {
                        append(HttpHeaders.ContentType, "application/json")
                        append("SERVICE_ID", "234009")
                        append(HttpHeaders.Accept, "application/json")
                        append(HttpHeaders.Authorization, token)
                    }
                    setBody(govValidateAnAccountBody)
                }

                if (resp.status.value in 200..299) {

                    val response = Json.decodeFromString<GovValidateAnAccountResponce>(resp.body())

                    if (response.status) {
                        CoroutineScope(Dispatchers.Main).launch {
                            success(response.status)
                        }
                    } else {
                        CoroutineScope(Dispatchers.Main).launch {
                            error(response.message)
                        }
                    }

                } else {
                    CoroutineScope(Dispatchers.Main).launch {
                        error("Error: Invalid details")
                    }
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    error("Network error")

                }
            }

        }
    }




    fun getAllPayslips(startYear: String, month: String, year: String, success: (GovAllPayslipResponse) -> Unit, error: (String) -> Unit){
        CoroutineScope(Dispatchers.Default).launch {

            try {
                val resp: HttpResponse = client.get(base + "payslips?paginate=10&per_page=1&from=$startYear-01-01 10:19:30&to=$year-12-31 10:19:30&search=$month"){
                    contentType(ContentType.Application.Json)
                    headers {
                        append(HttpHeaders.ContentType, "application/json")
                        append("SERVICE_ID", "234009")
                        append(HttpHeaders.Accept, "application/json")
                        append(HttpHeaders.Authorization, token)
                    }

                }

                if (resp.status.value in 200..299) {

                    val response = Json.decodeFromString<GovAllPayslipResponse>(resp.body())

                    if (response.status) {
                        CoroutineScope(Dispatchers.Main).launch {
                            success(response)
                        }
                    } else {
                        CoroutineScope(Dispatchers.Main).launch {
                            error(response.message)
                        }
                    }

                } else {
                    CoroutineScope(Dispatchers.Main).launch {
                        error("Unknown error")
                    }
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    error("Network error")

                }
            }

        }
    }






    fun getSinglePayslip(prid: Int, success: (GovSinglePayslipResponse) -> Unit, error: (String) -> Unit){
        CoroutineScope(Dispatchers.Default).launch {

            try {
                val resp: HttpResponse = client.get(base + "payslips/$prid"){
                    contentType(ContentType.Application.Json)
                    headers {
                        append(HttpHeaders.ContentType, "application/json")
                        append("SERVICE_ID", "234009")
                        append(HttpHeaders.Accept, "application/json")
                        append(HttpHeaders.Authorization, token)
                    }
                }
                if (resp.status.value in 200..299) {

                    val json = Json {
                        ignoreUnknownKeys = true
                        coerceInputValues = true
                    }

                    val response = json.decodeFromString<GovSinglePayslipResponse>(resp.body())

                    if (response.status) {
                        CoroutineScope(Dispatchers.Main).launch {
                            success(response)
                        }
                    } else {
                        CoroutineScope(Dispatchers.Main).launch {
                            error(response.message)
                        }
                    }

                } else {
                    CoroutineScope(Dispatchers.Main).launch {
                        error("Unknown error $prid")
                    }
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    error("Network error")

                }
            }

        }
    }







    fun getMyInfo(success: (GovEmployeeProfileResponse) -> Unit, error: (String) -> Unit){
        CoroutineScope(Dispatchers.Default).launch {

            try {
                val resp: HttpResponse = client.get(base + "user"){
                    contentType(ContentType.Application.Json)
                    headers {
                        append(HttpHeaders.ContentType, "application/json")
                        append("SERVICE_ID", "234009")
                        append(HttpHeaders.Accept, "application/json")
                        append(HttpHeaders.Authorization, token)
                    }
                }
                if (resp.status.value in 200..299) {
                    val json = Json {
                        ignoreUnknownKeys = true
                        coerceInputValues = true
                    }

                    val response = json.decodeFromString<GovEmployeeProfileResponse>(resp.body())

                    if (response.status) {
                        CoroutineScope(Dispatchers.Main).launch {
                            success(response)
                        }
                    } else {
                        CoroutineScope(Dispatchers.Main).launch {
                            error(response.message)
                        }
                    }

                } else {
                    CoroutineScope(Dispatchers.Main).launch {
                        error("Unknown error")
                    }
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    error("Network error ${e.message}")

                }
            }

        }
    }





    fun logout(success: (GovLogoutResponse) -> Unit, error: (String) -> Unit) {
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val resp: HttpResponse = client.get(base + "logout"){
                    contentType(ContentType.Application.Json)
                    headers {
                        append(HttpHeaders.ContentType, "application/json")
                        append("SERVICE_ID", "234009")
                        append(HttpHeaders.Accept, "application/json")
                        append(HttpHeaders.Authorization, token)
                    }
                }
                if (resp.status.value in 200..299) {

                    val response = Json.decodeFromString<GovLogoutResponse>(resp.body())

                    if (response.status) {
                        CoroutineScope(Dispatchers.Main).launch {
                            success(response)
                        }
                    } else {
                        CoroutineScope(Dispatchers.Main).launch {
                            error(response.message)
                        }
                    }

                } else {
                    CoroutineScope(Dispatchers.Main).launch {
                        error("Unknown error")
                    }
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    error("Network error")

                }
            }

        }
    }






}