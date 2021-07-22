package com.github.welblade.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.ktx.messaging

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

        FirebaseInstallations.getInstance().getToken(true).addOnCompleteListener {
            val token = it.result!!.token
            // DO your thing with your firebase token
            // Log and toast
            val msg = "Token -> $token"
            Log.d("Firebase Message", msg)
        }
//        Firebase.messaging.token.addOnCompleteListener(OnCompleteListener { task ->
//            if (!task.isSuccessful) {
//                Log.w("Firebase Message", "Fetching FCM registration token failed", task.exception)
//                return@OnCompleteListener
//            }
//            // Get new FCM registration token
//            val token = task.result
//
//            // Log and toast
//            val msg = "Token -> $token"
//            Log.d("Firebase Message", msg)
//        })
    }
}