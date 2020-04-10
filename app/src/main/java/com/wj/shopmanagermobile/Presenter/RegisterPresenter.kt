package com.wj.shopmanagermobile.Presenter

import android.app.Activity
import android.content.Context
import android.os.AsyncTask
import android.util.Patterns
import android.view.View
import android.widget.EditText
import com.wj.shopmanagermobile.Contract.IRegisterContract
import com.wj.shopmanagermobile.Model.User

class RegisterPresenter : IRegisterContract.Presenter {

    // (?=.*[0-9])      -   at least one digit
    // (?=.*[a-z])      -   at least one lower case letter
    // (?=.*[A-Z])      -   at least one upper case letter
    // (?=.*[!@#$%^&*]) -   at least one special character
    // (?=\S+$)         -   no whitespace allowed
    // .{8, 30}         -   at least 8 and maximum 30 of any signs
    val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{8,30}$".toRegex()

    lateinit var user : User
    lateinit var contractView : IRegisterContract.View

    init {
        // init jest wykonywany przed wykonaniem każdego konstruktora
        user = User()
    }

    constructor(contractView : IRegisterContract.View) {
        this.contractView = contractView
    }

    public fun signUp(etUserName: EditText, etEmail: EditText, etPassword: EditText, etPasswordConfirmation: EditText) {
        RegisterTask(this).execute(user)
//        emailAddressValidation(etEmail)
//        userNameValidation(etUserName)
//        passwordValidation(etPassword, etPasswordConfirmation)
    }

    private fun emailAddressValidation(emailAddress: EditText) : Boolean {
        if(!Patterns.EMAIL_ADDRESS.matcher(emailAddress.text.toString()).matches()) {
            emailAddress.setError("Email address is invalid.")
            return false
        }
        return true
    }

    private fun userNameValidation(userName: EditText) : Boolean {
        if(userName.text.toString().trim().length == 0) {
            userName.setError("User name cannot be empty.")
            return false
        }
        return true
    }

    private fun passwordValidation(password: EditText, passwordConfirmation: EditText) : Boolean {
        if(!PASSWORD_PATTERN.matches(password.text.toString())){
            password.setError("Password must be between 8 and 30 characters, must contain at least: one digit, one " +
                    "lower case letter, one upper case letter and one special character. No whitespaces allowed.")
            return false
        }
        if(!password.text.toString().equals(passwordConfirmation.text.toString())) {
            passwordConfirmation.setError("Passwords do not match.")
            return false
        }
        return true
    }



    class RegisterTask() : AsyncTask<User, Void, String?>() {
        lateinit var registerPresenter : RegisterPresenter

        constructor(registerPresenter : RegisterPresenter) : this() {
            this.registerPresenter = registerPresenter
        }

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg users: User): String? {
            var jsonResult : String? = users[0]?.register()
            return jsonResult
        }

        override fun onPostExecute(jsonResult: String?) {
            super.onPostExecute(jsonResult)
            registerPresenter.contractView.userRegistered(jsonResult)
        }
    }
}