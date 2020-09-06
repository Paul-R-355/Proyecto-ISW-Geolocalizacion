package com.example.epn_turnos_geolocalizacion_covid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_act__usuarios_cuarentena.*

class Act_UsuariosCuarentena : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__usuarios_cuarentena)
        btn_buscarenMapa
            .setOnClickListener{boton->
                irMapa()
            }
        btn_cancelar
            .setOnClickListener{
                irMenu()
            }

    }

    fun irMapa(){
        val intentExplicito= Intent(
            this,
            Act_MapsUsuario::class.java
        )
        this.startActivity(intentExplicito)
    }
    fun irMenu(){
        val intentExplicito= Intent(
            this,
            Act_Menu::class.java
        )
        this.startActivity(intentExplicito)
    }
}