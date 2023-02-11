package com.example.foody.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foody.MainActivity
import com.example.foody.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        try {
            Thread.sleep(4000)
        }catch (e: Exception){
            e.printStackTrace()
        }

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}