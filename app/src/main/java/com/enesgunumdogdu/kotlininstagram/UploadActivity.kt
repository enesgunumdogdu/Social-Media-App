package com.enesgunumdogdu.kotlininstagram

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.enesgunumdogdu.kotlininstagram.databinding.ActivityFeedBinding
import com.enesgunumdogdu.kotlininstagram.databinding.ActivityUploadBinding

class UploadActivity : AppCompatActivity() {
    private lateinit var binding : ActivityUploadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun share(view: View) {

    }

    fun selectImage(view: View) {

    }
}