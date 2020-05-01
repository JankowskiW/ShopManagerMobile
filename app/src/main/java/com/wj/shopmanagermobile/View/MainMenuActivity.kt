package com.wj.shopmanagermobile.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wj.shopmanagermobile.Contract.IMainMenuContract
import com.wj.shopmanagermobile.R

class MainMenuActivity : AppCompatActivity(), IMainMenuContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }
}
