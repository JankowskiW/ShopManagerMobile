package com.wj.shopmanagermobile.Helper

import org.json.JSONObject

fun parseStringToJSON(jsonString : String?) : JSONObject {
    var stringBuilder = StringBuilder()
    stringBuilder.append(jsonString)
    var jsonObject = JSONObject(stringBuilder.toString())
    return jsonObject
}