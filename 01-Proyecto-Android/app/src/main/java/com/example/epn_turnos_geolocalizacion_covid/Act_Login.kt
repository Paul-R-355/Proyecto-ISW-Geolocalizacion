package com.example.epn_turnos_geolocalizacion_covid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_act__login.*

class Act_Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__login)
        btn_ingresar.setOnClickListener{
            irMenu()
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