package com.enesgunumdogdu.kotlininstagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.enesgunumdogdu.kotlininstagram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    fun signInClicked(view : View){

    }

    fun signUpClicked(view : View){

    }

    fun createAccount(view : View){
        val intent = Intent(this,CreateAccountActivity::class.java)
        startActivity(intent)
    }
}