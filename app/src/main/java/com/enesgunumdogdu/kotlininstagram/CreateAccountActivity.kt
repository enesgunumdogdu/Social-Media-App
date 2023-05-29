package com.enesgunumdogdu.kotlininstagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.enesgunumdogdu.kotlininstagram.databinding.ActivityCreateAccountBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCreateAccountBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth

        binding.usernameEditText.addTextChangedListener(textWatcher)
        binding.emailEditText.addTextChangedListener(textWatcher)
        binding.passwordEditText.addTextChangedListener(textWatcher)
        println("CreateAccount Activity çağırıldı")
    }


    fun createClicked(view:View){
        val username = binding.usernameEditText.text.toString()
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        if(username.isEmpty()){
            binding.usernameEditText.error = "Username cannot be empty!"
            return
        }

        if(password.isEmpty()){
            binding.passwordEditText.error = "Password cannot be empty!"
            return
        }

        if(!isEmailValid(email)){
            binding.emailEditText.error = "Invalid email adress!"
            return
        }
        else{
            // all of them valid
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                Toast.makeText(this@CreateAccountActivity,"Your account successfully created!",Toast.LENGTH_LONG).show()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this@CreateAccountActivity,it.localizedMessage,Toast.LENGTH_LONG).show()
            }

        }
    }


    private fun isEmailValid(email:String):Boolean{
        val pattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}".toRegex()
        return email.matches(pattern)
    }


    private val textWatcher = object: TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            val username = binding.usernameEditText.text.toString().trim()
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()
            binding.button4.isEnabled = isFieldsValid(username, email, password)
            }
        }
        private fun isFieldsValid(username: String, email: String, password: String): Boolean {
            return username.isNotEmpty() && isEmailValid(email) && password.isNotEmpty()
        }
    }
