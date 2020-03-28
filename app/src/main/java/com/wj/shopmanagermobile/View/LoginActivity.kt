package com.wj.shopmanagermobile.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.wj.shopmanagermobile.Presenter.LoginPresenter
import com.wj.shopmanagermobile.R

class LoginActivity : AppCompatActivity() {

    lateinit var btnLogin : Button
    lateinit var btnCreateAcc : Button
    lateinit var etUserName : EditText
    lateinit var etPassword : EditText

    lateinit var loginPresenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val intentRegisterActivity = Intent(this, RegisterActivity::class.java)

        loginPresenter = LoginPresenter()

        btnLogin = findViewById(R.id.btnLogin_activity_login) as Button
        btnCreateAcc = findViewById(R.id.btnCreateAcc_activity_login) as Button
        etUserName = findViewById(R.id.etUserName_activity_login) as EditText
        etPassword = findViewById(R.id.etPassword_activity_login) as EditText

        btnLogin.setOnClickListener {
            loginPresenter.signIn(etUserName, etPassword)
        }

        btnCreateAcc.setOnClickListener {
            startActivity(intentRegisterActivity)
        }
    }



}
