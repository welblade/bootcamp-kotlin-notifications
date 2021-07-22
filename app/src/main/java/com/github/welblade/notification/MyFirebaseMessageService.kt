package com.github.welblade.notification

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessageService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Log.i("Firebase Message", "New token received -> $token")
        //sendRegistrationToServer(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        Log.i("Firebase Message", "New message received from -> ${message.from}")
        if(message.notification != null){
            this.showNotification(
                "777",
                message.notification?.title.toString(),
                message.notification?.body.toString(),
            )
        }
    }
}