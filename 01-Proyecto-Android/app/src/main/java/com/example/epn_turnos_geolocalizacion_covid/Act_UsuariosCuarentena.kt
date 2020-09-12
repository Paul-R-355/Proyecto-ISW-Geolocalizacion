package com.example.epn_turnos_geolocalizacion_covid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_act__usuarios_cuarentena.*

class Act_UsuariosCuarentena : AppCompatActivity() {
    val listaPacientes = arrayListOf<Pacientes>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__usuarios_cuarentena)
        //arreglo de pacientes

        listaPacientes.add(Pacientes("David", "Cruz", -0.3527114000000001, -78.5414629))
        listaPacientes.add(Pacientes("Alejandro", "Choez", -0.3461884, -78.5534792))
        listaPacientes.add(Pacientes("Nicole", "Antoneda", -0.3533981, -78.5476427))
        listaPacientes.add(Pacientes("Rosa", "Melando", -0.3389788, -78.5452394))
        listaPacientes.add(Pacientes("Jose", "Arciniega", -0.348935, -78.5579424))
        listaPacientes.add(Pacientes("Paul", "Lopez", -0.3331424, -78.5548525))
        listaPacientes.add(Pacientes("Olga", "Velez", -0.3389788, -78.5418062))
        listaPacientes.add(Pacientes("Carlos", "Chicaiza", -0.3211263, -78.5572557))
        listaPacientes.add(Pacientes("Maria", "Magdalena", -0.3276493, -78.4480791))
        listaPacientes.add(Pacientes("Eugenio", "Espejo", -0.3352023, -78.4497957))
        listaPacientes.add(Pacientes("Domenica", "Cumbal", -0.3293659, -78.4580354))

        val adaptador= ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listaPacientes
        )
        lv_usuarios.adapter=adaptador
        lv_usuarios
            .onItemClickListener= AdapterView.OnItemClickListener{ parent, view, position, id ->
            Log.i("List-view", "position $position")
        }
        btn_buscarenMapa
            .setOnClickListener{ boton->
                irMapa()
            }
        btn_cancelar
            .setOnClickListener{
                irMenu()
            }
        btn_buscar.setOnClickListener {
            buscarPaciente()
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
    //Arreglar!! Siempre manda a else :v
    fun buscarPaciente(){
        val nombre = "David"
        val apellido = "Cruz"
        val longitud = -0.3527114000000001
        val latitud = -78.5414629
        val existe: Boolean = listaPacientes.contains(Pacientes(nombre, apellido, longitud, latitud))
        if (existe) {
            Toast.makeText(this,"Paciente encontrado"+ listaPacientes.get(4), Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(this,"Paciente No encontrado"+ listaPacientes.get(0), Toast.LENGTH_SHORT).show()
        }
    }

}