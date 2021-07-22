package com.github.welblade.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat

fun Context.showNotification(channelId: String, title: String, body: String){
    val notificationManager =
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val intent = Intent(this, MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    val notificationBuilder: NotificationCompat.Builder =
        NotificationCompat.Builder(this, channelId).apply {
            setSmallIcon(R.drawable.ic_report)
            setContentTitle(title)
            setContentText(body)
            setAutoCancel(true)
            setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
            setContentIntent(pendingIntent)
        }
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        val notificationChannel =
            NotificationChannel(channelId, body, NotificationManager.IMPORTANCE_HIGH).apply{
                lightColor = Color.CYAN
                enableVibration(true)
            }
        notificationManager.createNotificationChannel(notificationChannel)
    }else{
        notificationBuilder.priority = NotificationCompat.PRIORITY_HIGH
    }
    notificationManager.notify(channelId.toInt(), notificationBuilder.build())
}
