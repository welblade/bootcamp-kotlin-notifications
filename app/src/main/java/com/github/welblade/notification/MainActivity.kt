package com.github.welblade.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val btnSend: Button by lazy {
        findViewById(R.id.btn_send)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSend.setOnClickListener {
            this.showNotification("777", "Bootcamp Kotlin", "Hello wonderful world!")
        }
    }
}