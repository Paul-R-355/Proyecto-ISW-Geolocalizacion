package com.example.epn_turnos_geolocalizacion_covid

import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.activity_act__usuarios_cuarentena.*


class Act_MapsUsuario : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_mapsusuario)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        establecerConfiguracionMapa(mMap)
        val paciente= intent.getParcelableExtra<Pacientes>("pacienteA")
        Log.i("List-view", "Paciente Select:  ${paciente}")

        if(paciente.nombre=="Paul"){
            rutaUsuarioCercoRoto()
        }else{
            localizacionUsuario(paciente)
        }

    }

    fun rutaUsuarioCercoRoto(){

        val origen = LatLng(-0.243340, -78.536083)
        val origenUno = LatLng(-0.243399, -78.536471)
        val origenDos = LatLng(-0.243683, -78.537662)
        val origenTres = LatLng(-0.243584, -78.538880)
        val origenCuatro = LatLng(-0.243603, -78.539277)

        //val quito = LatLng(-0.2225062304531491, -78.5160976202472)

        mMap.addMarker(MarkerOptions().position(origen).title("Paul"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(origen, 18F))

        val circle: Circle = mMap.addCircle(
            CircleOptions()
                .center(origen)
                .radius(15.0)//radio en metros
                .strokeWidth(10f)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 0, 180, 0))
                .clickable(true)
        )

        val line = mMap.addPolyline(
            PolylineOptions()
                .add(origen,origenUno)
                .width(15f)
                .color(Color.RED)
        )
        val line1 = mMap.addPolyline(
            PolylineOptions()
                .add(origenUno,origenDos)
                .width(15f)
                .color(Color.RED)
        )
        val line2 = mMap.addPolyline(
            PolylineOptions()
                .add(origenDos,origenTres)
                .width(15f)
                .color(Color.RED)
        )
        val line3 = mMap.addPolyline(
            PolylineOptions()
                .add(origenTres,origenCuatro)
                .width(15f)
                .color(Color.RED)
        )

        val melbourne = mMap.addMarker(
            MarkerOptions().position(origenUno)
                .icon(
                    BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                )
                .title("Paul")

        )

        val melbourneDos = mMap.addMarker(
            MarkerOptions().position(origenDos)
                .icon(
                    BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                )
                .title("Paul")
        )

        val melbourneTres = mMap.addMarker(
            MarkerOptions().position(origenTres)
                .icon(
                    BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                )
                .title("Paul")
        )

        val melbourneCuatro = mMap.addMarker(
            MarkerOptions().position(origenCuatro)
                .icon(
                    BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                )
                .title("Paul")
        )

    }



    fun localizacionUsuario(paciente : Pacientes){

        val origen = LatLng(paciente.longitud!!, paciente.latitud!!)
        val nombre=paciente.nombre+" "+paciente.apellido

        mMap.addMarker(MarkerOptions().position(origen).title(nombre))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(origen, 18F))

        val circle: Circle = mMap.addCircle(
            CircleOptions()
                .center(origen)
                .radius(15.0)//radio en metros
                .strokeWidth(10f)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 0, 180, 0))
                .clickable(true)
        )
    }


    fun establecerConfiguracionMapa(mapa:GoogleMap){
        val contexto = this.applicationContext
        with(mapa){
            val permisosFineLocation = ContextCompat
                .checkSelfPermission(
                    contexto,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )
            val tienePermisos = permisosFineLocation== PackageManager.PERMISSION_GRANTED
            if(tienePermisos){
                mapa.isMyLocationEnabled=true
            }
            uiSettings.isZoomControlsEnabled =true
            uiSettings.isMyLocationButtonEnabled=true
        }
    }


}