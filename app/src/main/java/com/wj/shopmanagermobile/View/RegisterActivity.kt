package com.wj.shopmanagermobile.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.wj.shopmanagermobile.Presenter.LoginPresenter
import com.wj.shopmanagermobile.Presenter.RegisterPresenter
import com.wj.shopmanagermobile.R

class RegisterActivity : AppCompatActivity() {

    lateinit var btnRegister : Button
    lateinit var etUserName : EditText
    lateinit var etEmail : EditText
    lateinit var etPassword : EditText
    lateinit var etPasswordConfirmation : EditText

    lateinit var registerPresenter : RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerPresenter = RegisterPresenter()

        btnRegister = findViewById(R.id.btnRegister_activity_register) as Button
        etUserName = findViewById(R.id.etUserName_activity_register) as EditText
        etEmail = findViewById(R.id.etEmail_activity_register) as EditText
        etPassword = findViewById(R.id.etPassword_activity_register) as EditText
        etPasswordConfirmation = findViewById(R.id.etPasswordConfirmation_activity_register) as EditText

        btnRegister.setOnClickListener {
            registerPresenter.signUp(etUserName, etEmail, etPassword, etPasswordConfirmation)
        }
    }
}
