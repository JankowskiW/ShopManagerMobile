package com.wj.shopmanagermobile.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.wj.shopmanagermobile.R

class MainActivity : AppCompatActivity() {

    lateinit var btnOpenLoginForm : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentLoginActivity = Intent(this, LoginActivity::class.java)

        btnOpenLoginForm = findViewById(R.id.btnOpenLoginForm) as Button

        btnOpenLoginForm.setOnClickListener {
            startActivity(intentLoginActivity)
        }
    }
}
