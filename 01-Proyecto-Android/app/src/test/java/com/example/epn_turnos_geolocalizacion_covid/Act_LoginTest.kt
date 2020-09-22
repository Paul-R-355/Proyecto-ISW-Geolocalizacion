package com.example.epn_turnos_geolocalizacion_covid


import junit.framework.Assert.assertEquals
//import com.google.common.truth.Truth.assertThat
import android.app.NotificationManager
import android.provider.Settings.Global.getString
import androidx.core.app.NotificationCompat
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import junit.framework.Assert.assertNotNull
import kotlinx.android.synthetic.main.activity_act__usuarios_cuarentena.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.RETURNS_SELF
import org.mockito.Mockito.eq
import org.mockito.internal.verification.Times
import java.util.regex.Pattern.matches

private val Nothing?.activity: Any
    get() {
        TODO("Not yet implemented")
    }

//@RunWith(MockitoJUnitRunner)//
class Act_LoginTest {
    //Creacion del mock de la actividad
    val login = mock<Act_Login>()
    var uiDevice = null
    @Before
    @Throws(Exception::class)
    fun obtenerDatos():ArrayList<PacienteHttp>{
        //Se obtiene los datos de la base de datos
        var arrayUsuarioDB = login.obtenerDatos()
        //Se comprueba que la basede datos no devuelva un null
        assertNotNull(arrayUsuarioDB)
        return  arrayUsuarioDB
    }
    @Test
    @Throws(Exception::class)
    fun testInicioSesion() {
        var cedula="1718185265"
        var pass="David_123"
        var arrayDB = login.obtenerDatos()
        var arrayTest = arrayOf(cedula,pass).toString()
        //verify(login, Times(1)).startActivity(login.irMenu())
    }

    var mockNotificationBuilderProvider = login.notificationChannel
    var mockNotificationBuilder = login.builder
    var mockNotificationManager: NotificationManager? = login.notificationManager

    //system under test
    var notificationWrapper = null

    @Before
    /* fun setUp() {
         mockNotificationBuilderProvider = mock<Act_Login>(
             mockNotificationBuilderProvider::class.java
         )
         mockNotificationBuilder = mock<>(
             mockNotificationBuilder::class.java,
             RETURNS_SELF.toString()
         )
         mockNotificationManager = mock(
             NotificationManager::class.java)
     }*/

    @Test
    fun givenTitleInData_whenPost_thenNotificationHasContentTitle2() {
        //arrange
        val data: MutableMap<String, String> = HashMap()
        data["Paciente"] = "Paciente"
        //act
        //notificationWrapper.postNotification(data)
        //assert
        verify(mockNotificationBuilder).setContentTitle(ArgumentMatchers.eq("Paul Reinoso SALIO DEL PERIMETRO").toString())
    }


    @Test
    fun shouldClickOnAllCitiesOpenMap2() {
        val activityRule = null
        val expectedAppName = activityRule.getString(R.layout.activity_act_mapsusuario)
        val allNotificationAsBundleText: String =
            activityRule.getString(R.drawable.coronavirus).toString()
        val firstItemPos: Any = ""
        //onView(withId(R.id.list))
          //  .perform(actionOnItemAtPosition<Any>(expectedAppName, clickOnSendNotification = login.btn_buscarenMapa.hasOnClickListeners()))
        //val mapsUsuario = uiDevice.find((R.layout.activity_act_mapsusuario))
        //mapsUsuario.click()

    }

    private fun <T> actionOnItemAtPosition(
        firstItemPos: Any,
        clickOnSendNotification: Any
    ): ViewAction? {
        TODO("Not yet implemented")
    }


    @Test
    @Throws(Exception::class)
    fun  shouldClickOnAllCitiesOpenMap() {
        assertEquals(5,3+2)
    }

}

private fun Nothing?.getString(appName: Int): Any {
    TODO("Not yet implemented")
}
