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
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_act__login.*
import kotlinx.android.synthetic.main.activity_act__usuarios_cuarentena.*

class Act_Login : AppCompatActivity() {

    val urlPrincipal = "http://192.168.0.102:1337"
    lateinit var listaDatos:ArrayList<PacienteHttp>
    lateinit var notificationManager : NotificationManager
    lateinit var notificationChannel : NotificationChannel
    lateinit var builder : Notification.Builder
    private val channelId = "com.example.epn_turnos_geolocalizacion_covid"
    private val description = "Test notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__login)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        listaDatos=arrayListOf()
        cargarSipiner()


        btn_ingresar.setOnClickListener{
            val cedula=et_usuario?.getText().toString()
            val contrasenia=et_password?.getText().toString()
            InicioDeSecion(cedula,contrasenia)
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

    fun obtenerDatos():ArrayList<PacienteHttp>{

        val url = urlPrincipal + "/paciente"
        url
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Success -> {
                        val data = result.get()
                        //Log.i("http-klaxon", "Data: ${data}")
                        val pacientes= Klaxon()
                            .parseArray<PacienteHttp>(data)
                        if(pacientes!=null){
                            pacientes.forEach{
                                Log.i("http-klaxon", "Nombre: ${it.nombre}  tamaño: ${it.correo}")
                                listaDatos.add(it)
                            }
                        }
                    }
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http-klaxon", "Error: ${ex.message}")
                    }
                }
            }
        return listaDatos
    }

    fun cargarSipiner(){
        val spinner: Spinner = findViewById(R.id.sp_modo)
        ArrayAdapter.createFromResource(
            this,
            R.array.numeros,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    fun mensajeDeError(){
        val text = "Usuario o contraseña incorrecto"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    fun InicioDeSecion(ci:String,pass:String){
        var bandera=false
        val datosC=obtenerDatos()
        //credenciales CI: 1718185265 -- Pass: David_123
        datosC
            .forEach{
                if(it.cedula==ci && it.clave==pass){
                    irMenu()
                    notificacion()
                }else{
                    bandera=false
                }
            }
        if(bandera==false){
            //mensajeDeError()
        }
    }


    fun irMenu(){
        val intentExplicito= Intent(
            this,
            Act_Menu::class.java
        )
        this.startActivity(intentExplicito)
    }
}