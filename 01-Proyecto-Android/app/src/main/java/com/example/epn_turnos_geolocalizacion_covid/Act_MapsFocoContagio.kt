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
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader


class Act_MapsFocoContagio : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__maps_foco_contagio)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        establecerConfiguracionMapa(mMap)
        llenarFocosDeContagio()
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

    fun llenarFocosDeContagio(){

        val origen = LatLng(-0.232283, -78.513623)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(origen, 12F))
        var datos:ArrayList<LatLng>
        datos= arrayListOf()

        datos.add(LatLng(-0.3527114000000001,-78.5414629))
        datos.add(LatLng(-0.3533981,-78.5476427))
        datos.add(LatLng(-0.3533981,-78.5476427))
        datos.add(LatLng(-0.3533981,-78.5476427))
        datos.add(LatLng(-0.3389788,-78.5452394))
        datos.add(LatLng(-0.348935,-78.5579424))
        datos.add(LatLng(-0.3331424,-78.5548525))
        datos.add(LatLng(-0.3389788,-78.5418062))
        datos.add(LatLng(-0.3211263,-78.5572557))
        datos.add(LatLng(-0.3276493,-78.4480791))
        datos.add(LatLng(-0.3352023,-78.4497957))
        datos.add(LatLng(-0.3293659,-78.4580354))
        datos.add(LatLng(-0.3327991,-78.44395919999999))
        datos.add(LatLng(-0.334859,-78.4542589))
        datos.add(LatLng(-0.2847346,-78.5297899))
        datos.add(LatLng(-0.290571,-78.5455827))
        datos.add(LatLng(-0.2940042,-78.5287599))
        datos.add(LatLng(-0.2957208,-78.5342531))
        datos.add(LatLng(-0.3187231,-78.5527925))
        datos.add(LatLng(-0.3314258,-78.54935930000001))
        datos.add(LatLng(-0.3173498,-78.5466127))
        datos.add(LatLng(-0.3527114000000001,-78.5414629))
        datos.add(LatLng(-0.3352023,-78.4497957))
        datos.add(LatLng(-0.3352023,-78.4497957))
        datos.add(LatLng(-0.3372622,-78.44052600000001))
        datos.add(LatLng(-0.3269627,-78.54455280000001))
        datos.add(LatLng(-0.3374339,-78.5534792))
        datos.add(LatLng(-0.3216413,-78.55313580000001))
        datos.add(LatLng(-0.3307392,-78.5440378))
        datos.add(LatLng(-0.3396654,-78.5524492))
        datos.add(LatLng(-0.3403521,-78.4458475))
        datos.add(LatLng(-0.3364039,-78.4503107))
        datos.add(LatLng(-0.3269627,-78.4520273))
        datos.add(LatLng(-0.3388071,-78.450654))
        datos.add(LatLng(-0.3434419,-78.4431009))
        datos.add(LatLng(-0.3417253,-78.4482507))
        datos.add(LatLng(-0.342412,-78.4396677))
        datos.add(LatLng(-0.3286793,-78.4528856))
        datos.add(LatLng(-0.3434419,-78.4431009))
        datos.add(LatLng(-0.3183285,-78.49311230000001))
        datos.add(LatLng(-0.3174702,-78.4900224))
        datos.add(LatLng(-0.3202167,-78.491224))
        datos.add(LatLng(-0.3203884,-78.48847739999999))
        datos.add(LatLng(-0.3203884,-78.48847739999999))
        datos.add(LatLng(-0.3226199,-78.48487249999999))
        datos.add(LatLng(-0.3227916,-78.4879624))
        datos.add(LatLng(-0.3318895,-78.5581719))
        datos.add(LatLng(-0.3348077,-78.54821560000001))
        datos.add(LatLng(-0.3231349,-78.54941719999999))
        datos.add(LatLng(-0.3236499,-78.55456700000001))
        datos.add(LatLng(-0.3394425,-78.556112))
        datos.add(LatLng(-0.341674,-78.55679859999999))
        datos.add(LatLng(-0.3418457,-78.546499))
        datos.add(LatLng(-0.3478537,-78.5528504))
        datos.add(LatLng(-0.3469954,-78.5463273))
        datos.add(LatLng(-0.3251948,-78.55628369999999))
        datos.add(LatLng(-0.3336061,-78.44642039999999))
        datos.add(LatLng(-0.3313745,-78.4580933))
        datos.add(LatLng(-0.3318895,-78.54217559999999))
        datos.add(LatLng(-0.2877732,-78.5313609))
        datos.add(LatLng(-0.2973861,-78.5313609))
        datos.add(LatLng(-0.2927513,-78.5426906))
        datos.add(LatLng(-0.2803918,-78.573418))
        datos.add(LatLng(-0.2803918,-78.573418))
        datos.add(LatLng(-0.2827951,-78.5741046))
        datos.add(LatLng(-0.2841683,-78.572388))
        datos.add(LatLng(-0.2788469,-78.58200100000001))
        datos.add(LatLng(-0.2810785,-78.5818294))
        datos.add(LatLng(-0.2812501,-78.5801127))
        datos.add(LatLng(-0.28331,-78.58045610000001))
        datos.add(LatLng(-0.2778169,-78.56586489999999))
        datos.add(LatLng(-0.2798769,-78.5653499))
        datos.add(LatLng(-0.2755854,-78.5698131))
        datos.add(LatLng(-0.2824517,-78.58268769999999))
        datos.add(LatLng(-0.2764437,-78.56225999999999))
        datos.add(LatLng(-0.2845117,-78.5801127))
        datos.add(LatLng(-0.2876015,-78.58062769999999))
        datos.add(LatLng(-0.2788469,-78.560715))
        datos.add(LatLng(-0.2700923,-78.5665515))
        datos.add(LatLng(-0.2814218,-78.5653499))
        datos.add(LatLng(-0.2876015,-78.58062769999999))
        datos.add(LatLng(-0.2714655,-78.56637980000001))
        datos.add(LatLng(-0.2242591,-78.52054630000001))
        datos.add(LatLng(-0.2244308,-78.5152247))
        datos.add(LatLng(-0.2242591,-78.5250094))
        datos.add(LatLng(-0.226319,-78.52174789999999))
        datos.add(LatLng(-0.2261474,-78.5143664))
        datos.add(LatLng(-0.2191286,-78.51823760000001))
        datos.add(LatLng(-0.2271966,-78.5268207))
        datos.add(LatLng(-0.22548,-78.51789429999999))
        datos.add(LatLng(-0.2454233,-78.5323138))
        datos.add(LatLng(-0.2322055,-78.4892268))
        datos.add(LatLng(-0.2328922,-78.4907718))
        datos.add(LatLng(-0.2335788,-78.48716690000001))
        datos.add(LatLng(-0.2823301,-78.4606837))
        datos.add(LatLng(-0.2787253,-78.45673549999999))
        datos.add(LatLng(-0.2797552,-78.4538172))
        datos.add(LatLng(-0.2785536,-78.46514689999999))
        datos.add(LatLng(-0.2800986,-78.46566180000001))
        datos.add(LatLng(-0.2833601,-78.4555338))
        datos.add(LatLng(-0.2737472,-78.4601687))
        datos.add(LatLng(-0.2830168,-78.4522723))
        datos.add(LatLng(-0.2830168,-78.4522723))
        datos.add(LatLng(-0.2830168,-78.4522723))
        datos.add(LatLng(-0.2861066,-78.45450390000001))
        datos.add(LatLng(-0.2867933,-78.4565638))
        datos.add(LatLng(-0.2871366,-78.4491824))
        datos.add(LatLng(-0.2876516,-78.4519289))
        datos.add(LatLng(-0.2897115,-78.44626409999999))
        datos.add(LatLng(-0.1389081,-78.4949301))
        datos.add(LatLng(-0.1389081,-78.4949301))
        datos.add(LatLng(-0.150581,-78.4963034))
        datos.add(LatLng(-0.1450878,-78.46609100000001))
        datos.add(LatLng(-0.2038787,-78.4413718))
        datos.add(LatLng(-0.2059387,-78.45304470000001))
        datos.add(LatLng(-0.1928925,-78.4317587))
        datos.add(LatLng(-0.2025055,-78.433132))
        datos.forEach{

            /*mMap.addMarker(
                MarkerOptions().position(it)
                    .icon(
                        BitmapDescriptorFactory
                            .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                    )
                    .title("Paul"))*/

            val circle: Circle = mMap.addCircle(
                CircleOptions()
                    .center(it)
                    .radius(300.0)//radio en metros
                    .strokeWidth(5f)
                    .strokeColor(Color.RED)
                    .fillColor(Color.argb(128, 180, 0, 0))
                    .clickable(true)
            )
        }
    }
}
