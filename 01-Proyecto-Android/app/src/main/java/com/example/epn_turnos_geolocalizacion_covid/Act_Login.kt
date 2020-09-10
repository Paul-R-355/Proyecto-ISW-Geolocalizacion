package com.example.epn_turnos_geolocalizacion_covid

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_act__login.*

class Act_Login : AppCompatActivity() {

    lateinit var notificationManager : NotificationManager
    lateinit var notificationChannel : NotificationChannel
    lateinit var builder : Notification.Builder
    private val channelId = "com.example.epn_turnos_geolocalizacion_covid"
    private val description = "Test notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__login)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        btn_ingresar.setOnClickListener{
            irMenu()
            notificacion()
        }
    }


    fun notificacion(){
        val intent = Intent(this,Act_UsuariosCuarentena::class.java)
        val pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this,channelId)
                .setContentTitle("Paul Reinoso SALIO DEL PERIMETRO")
                .setSmallIcon(R.drawable.campana)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.coronavirus))
                .setContentIntent(pendingIntent)

        }else{
            builder = Notification.Builder(this)
                .setContentTitle("Paul Reinoso SALIO DEL PERIMETRO")
                .setSmallIcon(R.drawable.campana)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.coronavirus))
                .setContentIntent(pendingIntent)
        }
        notificationManager.notify(1234,builder.build())
    }

    fun irMenu(){
        val intentExplicito= Intent(
            this,
            Act_Menu::class.java
        )
        this.startActivity(intentExplicito)
    }
}