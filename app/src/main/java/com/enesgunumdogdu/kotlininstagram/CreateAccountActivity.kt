package com.enesgunumdogdu.kotlininstagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        println("CreateAccount Activity çağırıldı")
    }
}