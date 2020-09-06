package com.example.epn_turnos_geolocalizacion_covid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_act__menu.*

class Act_Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__menu)

        btn_pacientes.
        setOnClickListener{boton->
            irListaPacinetes()
        }

        btn_visualizarFocos
            .setOnClickListener{boton->
                irFocosContagio()
            }
    }

    fun irMapa(){
        val intentExplicito= Intent(
            this,
            Act_MapsFocoContagio::class.java
        )
        this.startActivity(intentExplicito)
    }

    fun irListaPacinetes(){
        val intentExplicito= Intent(
            this,
            Act_UsuariosCuarentena::class.java
        )
        this.startActivity(intentExplicito)
    }

    fun irFocosContagio(){
        val intentExplicito= Intent(
            this,
            Act_MapsFocoContagio::class.java
        )
        this.startActivity(intentExplicito)
    }

}