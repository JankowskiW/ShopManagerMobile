package com.wj.shopmanagermobile.Presenter

import android.os.AsyncTask
import android.util.Patterns
import android.widget.EditText
import com.wj.shopmanagermobile.Contract.IRegisterContract
import com.wj.shopmanagermobile.Helper.HttpResponse
import com.wj.shopmanagermobile.Model.User

class RegisterPresenter : IRegisterContract.Presenter {

    // (?=.*[0-9])      -   at least one digit
    // (?=.*[a-z])      -   at least one lower case letter
    // (?=.*[A-Z])      -   at least one upper case letter
    // (?=.*[!@#$%^&*]) -   at least one special character
    // (?=\S+$)         -   no whitespace allowed
    // .{8, 30}         -   at least 8 and maximum 30 of any signs
    val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{8,30}$".toRegex()

    var user : User
    var contractView : IRegisterContract.View

    init {
        user = User()
    }

    constructor(contractView : IRegisterContract.View) {
        this.contractView = contractView
    }

//    fun signUp(etUserName: EditText, etEmail: EditText, etPassword: EditText, etPasswordConfirmation: EditText) {
    fun signUp(etUserName: EditText, etPassword: EditText, etPasswordConfirmation: EditText) {

//        if( emailAddressValidation(etEmail) && userNameValidation(etUserName) &&
//            passwordValidation(etPassword, etPasswordConfirmation)) {
        if(userNameValidation(etUserName) && passwordValidation(etPassword, etPasswordConfirmation)) {
            var userName = etUserName.text.toString().trim()
            var password = etPassword.text.toString().trim()
            user.Usr_Name = userName
            user.Usr_Password = password
            RegisterTask(this).execute(user)
        }
    }

    private fun emailAddressValidation(emailAddress: EditText) : Boolean {
        if(!Patterns.EMAIL_ADDRESS.matcher(emailAddress.text.toString().trim()).matches()) {
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
        if(!PASSWORD_PATTERN.matches(password.text.toString().trim())){
            password.setError("Password must be between 8 and 30 characters, must contain at least: one digit, one " +
                    "lower case letter, one upper case letter and one special character. No whitespaces allowed.")
            return false
        }
        if(!password.text.toString().trim().equals(passwordConfirmation.text.toString().trim())) {
            passwordConfirmation.setError("Passwords do not match.")
            return false
        }
        return true
    }



    class RegisterTask() : AsyncTask<User, Void, HttpResponse?>() {
        lateinit var registerPresenter : RegisterPresenter

        constructor(registerPresenter : RegisterPresenter) : this() {
            this.registerPresenter = registerPresenter
        }

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg users: User): HttpResponse? {

            var httpResponse : HttpResponse? = users[0]?.register()
            return httpResponse
        }

        override fun onPostExecute(httpResponse: HttpResponse?) {
            super.onPostExecute(httpResponse)
            if(httpResponse?.responseCode == 201) {
                var userLogin = httpResponse?.jsonResponseBody.getString("Usr_Login")
                registerPresenter.contractView.userRegistered(userLogin)
            } else if(httpResponse?.responseCode == 409) {

                registerPresenter.contractView.userExists(httpResponse?.jsonResponseBody.getString("Usr_Login"))
            }
        }
    }
}