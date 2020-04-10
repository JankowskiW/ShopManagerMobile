package com.wj.shopmanagermobile.Presenter

import android.os.AsyncTask
import android.widget.EditText
import com.wj.shopmanagermobile.Helper.getHttpMethod

class LoginPresenter {

    init {
        // init jest wykonywany przed wykonaniem każdego konstruktora
    }

    fun signIn(etUserName: EditText, etPassword: EditText) {
        if (userNameValidation(etUserName) && passwordValidation(etPassword))
        {
            LoginTask().execute()
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

    class LoginTask() : AsyncTask<Void, Void, Void>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: Void?): Void? {
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
        }
    }
}