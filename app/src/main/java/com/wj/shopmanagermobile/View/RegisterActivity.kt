package com.wj.shopmanagermobile.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.wj.shopmanagermobile.Contract.IRegisterContract
import com.wj.shopmanagermobile.Helper.HttpResponse
import com.wj.shopmanagermobile.Presenter.LoginPresenter
import com.wj.shopmanagermobile.Presenter.RegisterPresenter
import com.wj.shopmanagermobile.R

class RegisterActivity : AppCompatActivity(), IRegisterContract.View {

    lateinit var btnRegister : Button
    lateinit var etUserName : EditText
//    lateinit var etEmail : EditText
    lateinit var etPassword : EditText
    lateinit var etPasswordConfirmation : EditText

    lateinit var registerPresenter : RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerPresenter = RegisterPresenter(this)

        btnRegister = findViewById(R.id.btnRegister_activity_register) as Button
        etUserName = findViewById(R.id.etUserName_activity_register) as EditText
//        etEmail = findViewById(R.id.etEmail_activity_register) as EditText
        etPassword = findViewById(R.id.etPassword_activity_register) as EditText
        etPasswordConfirmation = findViewById(R.id.etPasswordConfirmation_activity_register) as EditText

        btnRegister.setOnClickListener {
//            registerPresenter.signUp(etUserName, etEmail, etPassword, etPasswordConfirmation)
            registerPresenter.signUp(etUserName, etPassword, etPasswordConfirmation)
        }
    }

    override fun userRegistered(userLogin : String) {
        // change view
        val intentLoginActivity = Intent(this, LoginActivity::class.java)
        startActivity(intentLoginActivity)
        Toast.makeText(this,"User "+userLogin+" has been created.", Toast.LENGTH_LONG).show()
    }

    override fun userExists(userLogin : String) {
        this.etUserName.setError("User "+userLogin+" already exists.")
        Toast.makeText(this,"User "+userLogin+" already exists.", Toast.LENGTH_LONG).show()
    }
}
