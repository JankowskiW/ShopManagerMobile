package com.wj.shopmanagermobile.Presenter

import android.os.AsyncTask
import android.widget.EditText
import com.wj.shopmanagermobile.Contract.ILoginContract
import com.wj.shopmanagermobile.Helper.HttpResponse
import com.wj.shopmanagermobile.Model.User

class LoginPresenter : ILoginContract.Presenter {


    var user : User
    var contractView : ILoginContract.View

    init {
        user = User()
    }

    constructor(contractView : ILoginContract.View) {
        this.contractView = contractView
    }

    fun signIn(etUserName: EditText, etPassword: EditText) {
        if (userNameValidation(etUserName) && passwordValidation(etPassword))
        {
            var userName = etUserName.text.toString().trim()
            var password = etPassword.text.toString().trim()
            user.Usr_Name = userName
            user.Usr_Password = password
            LoginTask(this).execute(user)
        }
//        return (userNameValidation(etUserName) && passwordValidation(etPassword))
    }

    private fun userNameValidation(userName: EditText) : Boolean {
        if(userName.text.toString().trim().length == 0) {
            userName.setError("User name cannot be empty.")
            return false
        }
        return true
    }

    private fun passwordValidation(password: EditText) : Boolean {
        if(password.text.toString().length == 0){
            password.setError("Password cannot be empty.")
            return false
        }
        return true
    }

    class LoginTask() : AsyncTask<User, Void, HttpResponse?>() {
        lateinit var loginPresenter: LoginPresenter

        constructor(loginPresenter : LoginPresenter) : this() {
            this.loginPresenter = loginPresenter
        }
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg users: User?): HttpResponse? {

            var httpResponse : HttpResponse? = users[0]?.login()
            return httpResponse
//            var stringResult = users[0]?.login()
//            println(stringResult)
//            // make gsonBody from hashMap<key, value>
////            var jsonResult = users[0].login(gsonBody)
//            return null
        }

        override fun onPostExecute(httpResponse: HttpResponse?) {
            super.onPostExecute(httpResponse)
            if(httpResponse?.responseCode == 200) {
                var userName = httpResponse?.jsonResponseBody.getString("Usr_Login")
                loginPresenter.contractView.userLoggedIn(userName)
            } else if(httpResponse?.responseCode == 401) {
                loginPresenter.contractView.userNotLoggedIn(httpResponse?.jsonResponseBody.getString("Usr_Login"))
            }
        }
    }
}