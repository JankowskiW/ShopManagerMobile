package com.wj.shopmanagermobile.Presenter

import android.widget.EditText

class LoginPresenter {
    init {
        // init jest wykonywany przed wykonaniem każdego konstruktora
    }

    public fun signIn(etUserName: EditText, etPassword: EditText) : Boolean {
        return (userNameValidation(etUserName) && passwordValidation(etPassword))
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
}