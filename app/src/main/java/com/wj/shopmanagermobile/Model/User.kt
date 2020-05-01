package com.wj.shopmanagermobile.Model

import com.wj.shopmanagermobile.Helper.HttpResponse
import com.wj.shopmanagermobile.Helper.postHttpMethod
import org.json.JSONArray
import org.json.JSONObject
import java.sql.Date

class User {
    val SERVER_SOCKET = "http://192.168.0.105:81"
    val API_URL = SERVER_SOCKET + "/shopmanagerapi/public/index.php/api"

    val ADDRESSES = API_URL + "/addresses"
    val USERS = API_URL + "/users"
    val USER_REGISTER = USERS + "/register"
    val USER_LOGIN = USERS + "/login"


    var Usr_Id : Int = 0
    var Usr_Name : String = ""
    var Usr_Password : String = ""
    lateinit var Usr_CreatedAt : Date
    lateinit var Usr_UpdatedAt : Date

    constructor()

    constructor(Usr_Name : String, Usr_Password : String) {
        this.Usr_Name = Usr_Name
        this.Usr_Password = Usr_Password
    }

    fun register() : HttpResponse? {
        var jsonArray = JSONArray()
        var jsonObject = JSONObject()
        jsonObject.put("Usr_Login", this.Usr_Name)
        jsonObject.put("Usr_Password", this.Usr_Password)
        jsonArray.put(jsonObject)
        var httpResponse = postHttpMethod(USER_REGISTER, jsonArray)
        return httpResponse
    }

    fun login() : HttpResponse? {
        var jsonArray = JSONArray()
        var jsonObject = JSONObject()
        jsonObject.put("Usr_Login", this.Usr_Name)
        jsonObject.put("Usr_Password", this.Usr_Password)
        jsonArray.put(jsonObject)
        var httpResponse : HttpResponse? = postHttpMethod(USER_LOGIN, jsonArray)
        return httpResponse
    }
}