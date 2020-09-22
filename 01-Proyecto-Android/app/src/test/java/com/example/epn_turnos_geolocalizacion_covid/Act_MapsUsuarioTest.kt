package com.example.epn_turnos_geolocalizacion_covid

import android.app.NotificationManager
import android.graphics.Color
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import com.google.android.gms.maps.model.Circle
import com.google.android.gms.maps.model.CircleOptions
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull

internal class Act_MapsUsuarioTest {
    /*El controlador podrá visualizar ubicación y
     perímetro permitido de movilización; el sistema
     mostrará con un símbolo de localización ( )
     la ubicación donde se encuentra el miembro de la EPN,
     es decir, el lugar donde cumplirá el aislamiento social.
      Mientras que el perímetro se marcará con una figura
      circular y de color verde. Si se da clic sobre el
      símbolo de ubicación, se visualizará la información
      del paciente como: nombre, apellidoEl controlador
      podrá visualizar ubicación y perímetro permitido de
      movilización; el sistema mostrará con un símbolo de
      localización ( ) la ubicación donde se encuentra el
      miembro de la EPN, es decir, el lugar donde cumplirá
      el aislamiento social. Mientras que el perímetro se
      marcará con una figura circular y de color verde. Si
      se da clic sobre el símbolo de ubicación, se
      visualizará la información del paciente como:
      nombre, apellido
    * */

    //MOCK DE LA ACTIVIDAD DE LOGIN PARA LA ESTABLECER UN BEFORE DE NOTIFICACIÓN
    val login = mock<Act_Login>()
    //MOCK DE LA ACTIVIDAD DONDE SE DESPLIEGA EL MAPA
    val mapaUsuario = mock<Act_MapsUsuario>()
    private lateinit var mMap: GoogleMap

    @Before
    fun despliegueNotificacion() {
        var mockNotificationBuilderProvider = login.notificationChannel
        var mockNotificationBuilder = login.builder
        var mockNotificationManager: NotificationManager? = login.notificationManager
        //arrange
        val data: MutableMap<String, String> = HashMap()
        data["Paciente"] = "Paciente"
        verify(mockNotificationBuilder)
    }

    @Test
    fun localizacionUsuario2() {
        val device = UiDevice.getInstance(getInstrumentation())
        val marker = device.findObject(UiSelector().descriptionContains("Paul Reinoso"))
        marker.click()
        assertNotNull(marker)
        val origen = LatLng(-0.243340, -78.536083)
        val circuloExp: Circle = mMap.addCircle(
            CircleOptions()
                .center(origen)
                .radius(15.0)//radio en metros
                .strokeWidth(10f)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 0, 180, 0))
                .clickable(true)
        )
        val pacienteTest = Pacientes("Paul", "Reinoso",-0.243340,-78.536083)
        assertNotNull(circuloExp)
        verify(mapaUsuario.localizacionUsuario(pacienteTest)).equals(circuloExp)
    }



}