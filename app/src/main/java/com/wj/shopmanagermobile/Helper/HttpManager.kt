package com.wj.shopmanagermobile.Helper


import android.os.AsyncTask
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.MediaType.Companion.parse
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.json.JSONObject
import java.io.IOException
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray


enum class HttpMethod{
    GET,
    POST,
    PUT,
    PATCH,
    DELETE
}
enum class HttpResponseCode(val responseCode : Int){
    OK(200),
    CREATED(201),
    NO_CONTENT(204),
    CONFLICT(409)
}

fun getHttpMethod(url: String) : String? {
    val request = Request.Builder().url(url).build()
    val client = OkHttpClient()
    val response = client.newCall(request).execute()
    val stringResponse = response.body?.string()
    return stringResponse
}

fun postHttpMethod(url: String, jsonArray: JSONArray) : HttpResponse? {
    /* Do API ma być przekazywany obiekt JSONArray a nie jeden element z niego,
        dlatego trzeba będzie troche pozmieniać w tym API, chyba że przyjmujemy ze można wysłać tylko
        i wyłącznie jeden obiekt, to wtedy JSONArray zamieniamy na JSONObject
     */
    val stringBody: String = jsonArray[0].toString()
    val requestBody = stringBody.toRequestBody()
////    val request = Request.Builder().method(HttpMethod.POST.toString(), requestBody).url(url).build()
    val request = Request.Builder().url(url).post(requestBody).build()
    val client = OkHttpClient()
    val response = client.newCall(request).execute()
    val stringResponse = response.body?.string()
    val responseCode = response.code
    var httpResponse = HttpResponse(stringResponse, responseCode)
    return httpResponse
}

fun putHttpMethod(url: String) {

}

fun deleteHttpMethod(url: String) {

}
