package com.wj.shopmanagermobile.Helper

import org.json.JSONObject

class HttpResponse {
    var jsonResponseBody : JSONObject
    var responseCode : Int

    constructor(stringResponseBody : String?, responseCode : Int) {
        this.jsonResponseBody = parseStringToJSON(stringResponseBody)
        this.responseCode = responseCode
    }

}