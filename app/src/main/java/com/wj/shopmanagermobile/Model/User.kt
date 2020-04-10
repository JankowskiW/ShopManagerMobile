package com.wj.shopmanagermobile.Model

import com.wj.shopmanagermobile.Helper.getHttpMethod
import java.sql.Date

class User {
    val SERVER_SOCKET = "http://192.168.0.105:81"
    val API_URL = SERVER_SOCKET + "/shopmanagerapi/public/index.php/api"
    val ADDRESSES = API_URL + "/addresses"

    var Usr_Id : Int = 0
    var Usr_Login : String = ""
    var Usr_Password : String = ""
    lateinit var Usr_CreatedAt : Date
    lateinit var Usr_UpdatedAt : Date

    constructor()

    constructor(Usr_Login : String, Usr_Password : String) {
        this.Usr_Login = Usr_Login
        this.Usr_Password = Usr_Password
    }

    fun register() : String? {
        var jsonResponse = getHttpMethod(ADDRESSES+"/13")
        return jsonResponse
    }
}