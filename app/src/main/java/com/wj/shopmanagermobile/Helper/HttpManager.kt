package com.wj.shopmanagermobile.Helper


import android.os.AsyncTask
import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.json.JSONObject
import java.io.IOException


enum class HttpMethod{
    GET,
    POST,
    PUT,
    PATCH,
    DELETE
}

fun getHttpMethod(url: String) : String? {
    val request = Request.Builder().url(url).build()
    val client = OkHttpClient()
    val response = client.newCall(request).execute()
    val jsonResponse = response.body?.string()
    return jsonResponse
}

fun postHttpMethod(url: String) {
}

fun putHttpMethod(url: String) {

}

fun deleteHttpMethod(url: String) {

}
